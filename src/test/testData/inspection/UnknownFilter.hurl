GET https://example.org/api
HTTP 200
[Asserts]
bytes charsetDecode <error descr="Unknown charset: abc">"abc"</error> == "你好世界"
