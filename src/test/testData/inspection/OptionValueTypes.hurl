GET https://example.org/api
[Options]
# Booleans
compressed: true
insecure: false
skip: {{skip}}
compressed: <error descr="Invalid value for option 'compressed': expected true or false">yes</error>
http2: <error descr="Invalid value for option 'http2': expected true or false">"true"</error>
location: <error descr="Invalid value for option 'location': expected true or false">1</error>
http2-prior-knowledge: true
no-jsonpath-coercion: {{coercion}}
ntlm: <error descr="Invalid value for option 'ntlm': expected true or false">yes</error>
# Counts
retry: 5
retry: -1
max-redirs: {{max}}
repeat: <error descr="Invalid value for option 'repeat': expected an integer greater than or equal to -1">-2</error>
retry: <error descr="Invalid value for option 'retry': expected an integer greater than or equal to -1">many</error>
# Naturals
limit-rate: 1000
limit-rate: <error descr="Invalid value for option 'limit-rate': expected a non-negative integer">-1</error>
# Durations
delay: 500ms
delay: 2s
retry-interval: 1m
max-time: 30
max-time: 1h
connect-timeout: {{timeout}}
retry-interval: <error descr="Invalid value for option 'retry-interval': expected a duration (an integer with an optional unit: ms, s, m or h)">1.5s</error>
delay: <error descr="Invalid value for option 'delay': expected a duration (an integer with an optional unit: ms, s, m or h)">2d</error>
# Verbosity
verbosity: brief
verbosity: debug
verbosity: <error descr="Invalid value for option 'verbosity': expected one of brief, verbose or debug">loud</error>
# Variables
variable: name=value
variable: count=10
variable: title={{title}}
variable: année = été
variable: <error descr="Invalid value for option 'variable': expected a variable definition (name=value)">novalue</error>
variable: <error descr="Invalid value for option 'variable': expected a variable definition (name=value)">{{name}}=value</error>
variable: <error descr="Invalid value for option 'variable': the variable name 'newUuid' conflicts with a function, use a different name">newUuid=1</error>
# Options that accept any string
proxy: http://localhost:8080
output: out.txt
user: alice:secret
HTTP 200
