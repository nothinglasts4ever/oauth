## Usage
To get JWT token use the following command:
```shell script
curl client:53cr3t@localhost:8080/oauth/token -dgrant_type=password -dusername=Duff123 -dpassword=secret1 -dscope=any
```
or via Postman:
```
curl --location --request POST 'client:53cr3t@localhost:8080/oauth/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: JSESSIONID=0F2895D3804E0EE0DE4DDE2DEF06C936' \
--data-urlencode 'scope=any' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=Duff123' \
--data-urlencode 'password=secret1'
```
Example response:
```json
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTcyODA0OTQsInVzZXJfbmFtZSI6IkR1ZmYxMjMiLCJqdGkiOiJjM2Q0YzE3YS1jMzQ5LTQ5ODUtYjYwNi00Y2U4ZTJlZjhhMTgiLCJjbGllbnRfaWQiOiJjbGllbnQiLCJzY29wZSI6WyJhbnkiXX0.wumA1DRNI2M35SXjjy4m9u2vD1-BS5GE4XGfmNLeluI",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTk4MjkyOTQsInVzZXJfbmFtZSI6IkR1ZmYxMjMiLCJqdGkiOiI1MDFhYTlmYi00ZGExLTQ0YzAtODM5Mi0xNjMwOTc1MjFkM2UiLCJjbGllbnRfaWQiOiJjbGllbnQiLCJzY29wZSI6WyJhbnkiXSwiYXRpIjoiYzNkNGMxN2EtYzM0OS00OTg1LWI2MDYtNGNlOGUyZWY4YTE4In0.NtWzJAZvzjdgl6O9g4AmyfXPQI-A_lPv4x5vTMb6Dyg",
    "expires_in": 43199,
    "scope": "any",
    "jti": "c3d4c17a-c349-4985-b606-4ce8e2ef8a18"
}
```
Payload data:
```json
{
  "exp": 1597280494,
  "user_name": "Duff123",
  "jti": "c3d4c17a-c349-4985-b606-4ce8e2ef8a18",
  "client_id": "client",
  "scope": [
    "any"
  ]
}
```
After that **access_token** needs to be put to *Authorization* header of subsequent requests next to *Bearer* word like the following:
```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1OTcyODA0OTQsInVzZXJfbmFtZSI6IkR1ZmYxMjMiLCJqdGkiOiJjM2Q0YzE3YS1jMzQ5LTQ5ODUtYjYwNi00Y2U4ZTJlZjhhMTgiLCJjbGllbnRfaWQiOiJjbGllbnQiLCJzY29wZSI6WyJhbnkiXX0.wumA1DRNI2M35SXjjy4m9u2vD1-BS5GE4XGfmNLeluI
```