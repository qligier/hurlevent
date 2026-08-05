POST https://example.org/api/hits
Content-Type: application/json
[1, 2, 3]
HTTP 200

POST https://example.org/api/hits
Content-Type: application/json
[
    {"name": "{{name}}", "value": 1},
    [1, 2, 3]
]
HTTP 200

POST https://example.org/api/hits
Content-Type: application/json

[1, 2, 3]

HTTP 200

POST https://example.org/api/hits
Content-Type: application/json

[
    {"name": "{{name}}", "value": 1},
    [1, 2, 3]
]

HTTP 200

# JSON body
POST http://httpbin.org/post
Content-Type: application/json
{
  "user": {
    "name": "Jane Doe",
    "age": 30,
    "active": true,
    "tags": ["admin", "editor"],
    "address": {
      "city": "Portland",
      "state": "OR",
      "zip": "97201"
    }
  }
}
HTTP 200

POST http://httpbin.org/post
```json
{
  "uuid": "{{request_uuid}}",
  "action": "verify"
}
```
HTTP 200
