GET https://example.org/api
HTTP 200
[Asserts]
jsonpath "$.token" base64Decode == hex,3c3c3f3f3f3e3e;
bytes base64Encode == "PDw/Pz8+Pg=="
jsonpath "$.token" base64UrlSafeDecode == hex,3c3c3f3f3f3e3e;
bytes base64UrlSafeEncode == "PDw_Pz8-Pg"
bytes charsetDecode "gb2312" xpath "string(//body)" == "你好世界"
jsonpath "$.books" count == 12
cookie "LSID[Expires]" dateFormat "%a, %d %b %Y %H:%M:%S" == "Wed, 13 Jan 2021 22:23:01"
certificate "Expire-Date" daysAfterNow > 15
certificate "Start-Date" daysBeforeNow < 100
jsonpath "$.books" first == "Dune"
jsonpath "$.text" htmlEscape == "a &gt; b"
jsonpath "$.escaped_html[1]" htmlUnescape == "Foo © bar 𝌆"
variable "books" jsonpath "$[0].name" == "Dune"
jsonpath "$.books" last == "Les Misérables"
redirects count == 2
redirects nth 0 location == "https://example.org/step2"
jsonpath "$.books" nth 2 == "Children of Dune"
jsonpath "$.ips" replace ", " "|" == "192.168.2.1|10.0.0.20|10.0.0.10"
jsonpath "$.message" replaceRegex "B[aoi]b" "Dude" == "Welcome Dude!"
jsonpath "$.ips" split ", " count == 3
header "Expires" toDate "%a, %d %b %Y %H:%M:%S GMT" daysBeforeNow > 1000
jsonpath "$.published" toDate "%Y-%m-%dT%H:%M:%S%.fZ" dateFormat "%A" == "Monday"
jsonpath "$.published" toDate "%+" dateFormat "%A" == "Monday" # %+ can be used to parse ISO 8601 / RFC 3339
jsonpath "$.pi" toFloat == 3.14
bytes toHex == "d188d0b5d0bbd0bbd18b"
jsonpath "$.id" toInt == 123
jsonpath "$.count" toString == "42"
jsonpath "$.encoded_url" urlDecode == "https://mozilla.org/?x=шеллы"
jsonpath "$.url" urlEncode == "https%3A//mozilla.org/%3Fx%3D%D1%88%D0%B5%D0%BB%D0%BB%D1%8B"
jsonpath "$.url" urlQueryParam "x" == "шеллы"
jsonpath "$.bytesInBase64" base64Decode utf8Decode == "Hello World"
jsonpath "$.beverage" utf8Encode toHex == "636166C3A9"
bytes decode "gb2312" xpath "string(//body)" == "你好世界"
[Captures]
param2: header "header2" regex "Hello (.*)!"
url: jsonpath "$.url" replace "http://" "https://"
url: jsonpath "$.id" replaceRegex /\d/ "x"
