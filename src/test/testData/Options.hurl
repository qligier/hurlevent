GET https://example.org/a
[Options]
connect-timeout: 10s
digest: true
fail-with-body: true
header: X-Custom: value
http2-prior-knowledge: true
limit-rate: 1000
max-time: 30
negotiate: false
netrc: true
netrc-file: /home/user/.netrc
netrc-optional: false
no-header: X-Custom
no-jsonpath-coercion: true
ntlm: false
pinnedpubkey: sha256//YhKJKSzoTt2b5FP18fvpHo7fJYqQCjAa3HWY3tvRMwE=
repeat: 3
retry: 5
retry-interval: 500ms
tls-max: 1.3
tls-min: 1.2
variables-file: vars.env
verbose: true
verbosity: debug
HTTP 200
