# Home Assistant App: MariaDB

## Installation

Follow these steps to get the app (formerly known as add-on) installed on your system:

1. In Home Assistant, go to **Settings** > **Apps** > **Install app**.
2. Find the "MariaDB" app and click it.
3. Click on the "INSTALL" button.

## How to use

1. Set the `logins` -> `password` field to something strong and unique.
2. Start the app.
3. Check the app log output to see the result.
4. Add the `recorder` integration to your Home Assistant configuration.

## App configuration

The MariaDB server app can be tweaked to your likings. This section
describes each of the app configuration options.

Example app configuration:

```yaml
databases:
  - homeassistant
logins:
  - username: homeassistant
    password: PASSWORD
  - username: read_only_user
    password: PASSWORD
rights:
  - username: homeassistant
    database: homeassistant
  - username: read_only_user
    database: homeassistant
    privileges:
      - SELECT
```

### Option: `databases` (required)

Database name, e.g., `homeassistant`. Multiple are allowed.
A name may only contain letters, digits, `_`, `$` and `-`.

### Option: `logins` (required)

This section defines a create user definition in MariaDB. [Create User][createuser] documentation.

### Option: `logins.username` (required)

Database user login, e.g., `homeassistant`. [User Name][username] documentation.
A user name may only contain letters, digits, spaces, `_`, `-`, `.` and `@`.

### Option: `logins.password` (required)

Password for user login. This should be strong and unique.

### Option: `rights` (required)

This section grant privileges to users in MariaDB. [Grant][grant] documentation.

### Option: `rights.username` (required)

This should be the same user name defined in `logins` -> `username`.

### Option: `rights.database` (required)

This should be the same database defined in `databases`.

### Option: `rights.privileges` (optional)

A list of privileges to grant to this user from [grant][grant] like `SELECT` and `CREATE`.
If omitted, grants `ALL PRIVILEGES` to the user. Restricting privileges of the user
that Home Assistant uses is not recommended but if you want to allow other applications
to view recorder data should create a user limited to read-only access on the database.

### Option: `mariadb_server_args` (optional)

Some users have experienced [errors][migration-issues] during Home Assistant schema updates on large databases.
Defining the recommended parameters can help if there is RAM available.

Example: `--innodb_buffer_pool_size=512M`

## Home Assistant Configuration

MariaDB will be used by the `recorder` and `history` components within Home Assistant. For more information about setting this up, see the [recorder integration][mariadb-ha-recorder] documentation for Home Assistant.

Example Home Assistant configuration:

```yaml
recorder:
  db_url: mysql://homeassistant:password@core-mariadb/homeassistant?charset=utf8mb4
```

## Support

Got questions?

You have several options to get them answered:

- The [Home Assistant Discord Chat Server][discord].
- The Home Assistant [Community Forum][forum].
- Join the [Reddit subreddit][reddit] in [/r/homeassistant][reddit]

In case you've found a bug, please [open an issue on our GitHub][issue].

[createuser]: https://mariadb.com/kb/en/create-user/
[username]: https://mariadb.com/kb/en/create-user/#user-name-component
[hostname]: https://mariadb.com/kb/en/create-user/#host-name-component
[grant]: https://mariadb.com/kb/en/grant/
[migration-issues]: https://github.com/home-assistant/core/issues/125339
[mariadb-ha-recorder]: https://www.home-assistant.io/integrations/recorder/
[discord]: https://www.home-assistant.io/join-chat
[forum]: https://community.home-assistant.io
[issue]: https://github.com/home-assistant/app-mariadb/issues
[reddit]: https://reddit.com/r/homeassistant
[repository]: https://github.com/hassio-addons/repository
