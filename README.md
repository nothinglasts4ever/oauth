## Usage
To get JWT token use the following command:
*curl client:53cr3t@localhost:8080/oauth/token -dgrant_type=client_credentials -dscope=any*

Example response:
```json
{
    "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOlsiYXBpIl0sInNjb3BlIjpbInJlYWQiXSwiZXhwIjoxNTk3MjU4NTMwLCJqdGkiOiIwZTBiNTZlYy1mMTc2LTRlNzktODQ1NS04NzgwMDEzYzI3MWIiLCJjbGllbnRfaWQiOiJjbGllbnQifQ.45fO43YAbreHbTjrEHvo8Yt9D4eCGCo8ibSGSubK1Rk",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "read",
    "jti": "0e0b56ec-f176-4e79-8455-8780013c271b"
}
```

localhost:8080/oauth/token?grant_type=password&username=Duff123&password=secret1&client_id=client

curl client:53cr3t@localhost:8080/oauth/token -dgrant_type=password -dusername=Duff123 -dpassword=secret1

## ok
```shell script
curl client:53cr3t@localhost:8080/oauth/token -dgrant_type=password -dusername=Duff123 -dpassword=secret1 -dscope=any
```

```json
{"access_token":"sNewoGbv48v6gKMQGIzPKkNWMuI",
"token_type":"bearer",
"refresh_token":"deAqMf6uDAKYVsaXaQubBvbjpeQ",
"expires_in":43199,
"scope":"any"}
```

```xml
 <dependency>
            <groupId>org.springframework.security.oauth</groupId>
            <artifactId>spring-security-oauth2</artifactId>
            <version>2.5.0.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.security.oauth.boot</groupId>
            <artifactId>spring-security-oauth2-autoconfigure</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```