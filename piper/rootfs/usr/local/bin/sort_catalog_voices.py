"""Move re-downloadable voice models out of the backed-up part of /data.

Catalog voices and uploaded ones sit side by side: wyoming-piper downloads
into --download-dir, and the web interface uploads there too. Only the uploads
are irreplaceable, while a single catalog voice is 20-110 MB of every backup
the add-on is part of, for something a restore fetches again on demand.

So the catalog copies are moved into a subdirectory that config.yaml leaves
out of backups, and that subdirectory is handed back to wyoming-piper as
another --data-dir. Nothing is re-downloaded now; after a restore the
subdirectory is simply absent, which is the state of a fresh install.

A file is moved only when its md5 matches what the catalog lists for that
name, so a voice that merely borrows a catalog name -- a fine-tune exported as
en_US-lessac-medium.onnx, say -- stays in /data and stays in backups. Names
are checked before hashing, so the common case of a custom voice under a
custom name reads no bytes at all.

This runs at startup because the add-on does not control where wyoming-piper
writes: a voice downloaded while the add-on is running stays in /data until
the next start and is moved then.
"""

import argparse
from pathlib import Path
from typing import Dict, List, Set

from wyoming_piper.download import get_voices
from wyoming_piper.file_hash import get_file_hash


def catalog_digests(download_dir: Path) -> Dict[str, Set[str]]:
    """Map file name to the md5 digests the catalog publishes for that name.

    A set rather than one digest: the same file is listed under a voice and
    under each of its aliases, and nothing guarantees those agree.
    """
    digests: Dict[str, Set[str]] = {}

    # update_voices is left off: this must not depend on the network, and the
    # Piper service downloads the current voices.json moments later anyway.
    for voice in get_voices(download_dir).values():
        for file_path, file_info in voice.get("files", {}).items():
            digest = file_info.get("md5_digest")
            if digest:
                digests.setdefault(Path(file_path).name, set()).add(digest)

    return digests


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("data_dir", help="Directory voices are downloaded into")
    parser.add_argument("catalog_dir", help="Directory to move catalog voices to")
    args = parser.parse_args()

    data_dir = Path(args.data_dir)
    catalog_dir = Path(args.catalog_dir)
    digests = catalog_digests(data_dir)

    moved: List[str] = []
    moved_bytes = 0

    for onnx_path in sorted(data_dir.glob("*.onnx")):
        # A voice is the model and its config together. Moving one without the
        # other would hide the voice from both directories.
        pair = [onnx_path, onnx_path.with_name(f"{onnx_path.name}.json")]

        if not all(path.is_file() and not path.is_symlink() for path in pair):
            continue

        if not all(path.name in digests for path in pair):
            continue

        if not all(get_file_hash(path) in digests[path.name] for path in pair):
            continue

        catalog_dir.mkdir(parents=True, exist_ok=True)
        for path in pair:
            moved_bytes += path.stat().st_size
            # Same filesystem, so this is a rename: the voice is in exactly one
            # of the two directories at every point, never half-copied.
            path.replace(catalog_dir / path.name)

        moved.append(onnx_path.name[: -len(".onnx")])

    if moved:
        print(
            f"Moved {len(moved)} re-downloadable voice(s), "
            f"{moved_bytes / (1024 * 1024):.0f} MiB, to {catalog_dir}, "
            f"which is left out of backups: {', '.join(moved)}"
        )


if __name__ == "__main__":
    main()
