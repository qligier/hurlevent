POST https://example.org/api/hits
Content-Type: application/xml

<?xml version="1.0"?>
<Request>
   <Login>myLogin</Login>
   <Password>myPassword</Password>
</Request>

HTTP 200

# XML body
POST http://httpbin.org/post
Content-Type: application/xml
<user>
  <name>Jane Doe</name>
  <email>jane@example.com</email>
  <role>admin</role>
</user>
HTTP 200

# XML body
POST http://httpbin.org/post
Content-Type: application/xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<user>
  <name>Jane Doe</name>
  <email>jane@example.com</email>
  <role>admin</role>
</user>
```
HTTP 200
