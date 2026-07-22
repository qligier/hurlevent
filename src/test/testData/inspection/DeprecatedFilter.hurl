GET https://example.org/api
HTTP 200
[Asserts]
cookie "LSID[Expires]" <weak_warning descr="Deprecated filter">format</weak_warning> "%a, %d %b %Y %H:%M:%S" == "Wed, 13 Jan 2021 22:23:01"
bytes <weak_warning descr="Deprecated filter">decode</weak_warning> "gb2312" == "你好世界"
