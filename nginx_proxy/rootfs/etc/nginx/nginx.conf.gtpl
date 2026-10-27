{{/*
    Options saved in the Home Assistant UI are available in .options
    Some variables are available in .variables, these are added in nginx/run
*/}}
daemon off;
error_log stderr;
pid /var/run/nginx.pid;

events {
    worker_connections 1024;
}

{{- if .options.customize.active }}
include /share/{{ .options.customize.root_conf }};
{{- end }}

http {
    map_hash_bucket_size 128;

    map $http_upgrade $connection_upgrade {
        default upgrade;
        ''      close;
    }

    # Prefer the verbatim Host header (preserves port), but fall back to
    # $host when it is empty. HTTP/3 clients send an :authority pseudo-header
    # instead of a Host header, leaving $http_host empty; nginx then omits the
    # header entirely and aiohttp (HA 2026.7.0+) rejects the request with a
    # 400 "Missing 'Host' header". $host falls back to :authority/server_name.
    map $http_host $forward_host {
        default $http_host;
        ''      $host;
    }

    server_tokens off;

    server_names_hash_bucket_size 128;

    # intermediate configuration
    # https://ssl-config.mozilla.org/#server=nginx&version=1.28.3&config=intermediate&openssl=3.5.6
    ssl_protocols TLSv1.2 TLSv1.3;
    ssl_ecdh_curve X25519MLKEM768:X25519:prime256v1:secp384r1;
    ssl_ciphers ECDHE-ECDSA-AES128-GCM-SHA256:ECDHE-RSA-AES128-GCM-SHA256:ECDHE-ECDSA-AES256-GCM-SHA384:ECDHE-RSA-AES256-GCM-SHA384:ECDHE-ECDSA-CHACHA20-POLY1305:ECDHE-RSA-CHACHA20-POLY1305;
    ssl_prefer_server_ciphers off;

    {{- if .options.cloudflare }}
    include /data/cloudflare.conf;
    {{- end }}

    server {
        server_name _;
        listen 80 default_server;
        listen 443 ssl default_server;
        listen [::]:80 default_server;
        listen [::]:443 ssl default_server;
        http2 on;
        {{- if .variables.quic_port }}
        listen 443 quic reuseport default_server;
        listen [::]:443 quic reuseport default_server;
        http3 on;
        {{- end }}
        ssl_reject_handshake on;
        return 444;
    }

    server {
        server_name {{ .options.domain }};

        # These shouldn't need to be changed
        listen 80;
        listen [::]:80;
        return 301 https://$host$request_uri;
    }

    server {
        server_name {{ .options.domain }};

        ssl_session_timeout 1d;
        ssl_session_cache shared:MozSSL:10m;
        ssl_session_tickets off;
        ssl_certificate /ssl/{{ .options.certfile }};
        ssl_certificate_key /ssl/{{ .options.keyfile }};

        # dhparams file
        ssl_dhparam /data/dhparams.pem;

        {{- if not .options.real_ip_from  }}
        listen 443 ssl;
        listen [::]:443 ssl;
        http2 on;
        {{- if .variables.quic_port }}
        listen 443 quic;
        listen [::]:443 quic;
        http3 on;
        {{- end }}
        {{- else }}
        listen 443 ssl proxy_protocol;
        listen [::]:443 ssl proxy_protocol;
        http2 on;
        {{- if .variables.quic_port }}
        listen 443 quic proxy_protocol;
        listen [::]:443 quic proxy_protocol;
        http3 on;
        {{- end }}
        {{- range .options.real_ip_from }}
        set_real_ip_from {{.}};
        {{- end  }}
        real_ip_header proxy_protocol;
        {{- end }}

        {{- if .variables.quic_port }}
        add_header Alt-Svc 'h3=":{{ .variables.quic_port }}"; ma=86400';
        {{- end }}

        {{- if .options.hsts }}
        add_header Strict-Transport-Security "{{ .options.hsts }}" always;
        {{- end }}

        proxy_buffering off;

        {{- if ne .options.client_max_body_size_megabytes nil }}
        client_max_body_size {{ .options.client_max_body_size_megabytes }}m;
        {{- end }}

        {{- if .options.customize.active }}
        include /share/{{ .options.customize.default }};
        {{- end }}

        location / {
            {{- if .options.use_ssl_backend }}
            proxy_pass https://homeassistant.local.hass.io:{{ .variables.port }};
            {{- else }}
            proxy_pass http://homeassistant.local.hass.io:{{ .variables.port }};
            {{- end }}
            proxy_set_header Origin $http_origin;
            proxy_set_header X-Forwarded-Proto $scheme;
            proxy_set_header Host $forward_host;
            proxy_redirect http:// https://;
            proxy_http_version 1.1;
            proxy_set_header Upgrade $http_upgrade;
            proxy_set_header Connection $connection_upgrade;
            proxy_set_header X-Forwarded-Host $forward_host;
            {{- if not .options.real_ip_from }}
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            {{- else }}
            proxy_set_header X-Real-IP $proxy_protocol_addr;
            proxy_set_header X-Forwarded-For $proxy_protocol_addr;
            {{- end }}
        }
    }

    {{- if .options.customize.active }}
    include /share/{{ .options.customize.servers }};
    {{- end }}
}
