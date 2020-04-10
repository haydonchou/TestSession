# TestSession
Test shared session

I used @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES) and @Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES), 
and now I have problems with springcloudcontext.


## Environment


- jdk 1.8+
- redis
- nginx


## Setup

### redis

```
spring:
  redis:
    host: 127.0.0.1
    port: 6379
```

### nginx

```
upstream testsession{
        server 127.0.0.1:8080;
        server 127.0.0.1:8081;
}
server {
        listen       80;
        server_name  localhost;

        location /public {
            proxy_pass http://testsession;
        }
}
```

### TestSession

1.Build

Modify redis configuration

```
cd TestSession
mvn clean package
```
get target/TestSession-0.0.1-SNAPSHOT.jar

2.Run two services

```
java -jar TestSession-0.0.1-SNAPSHOT.jar --server.port=8080
```
```
java -jar TestSession-0.0.1-SNAPSHOT.jar --server.port=8081
```

3.Browser access http://127.0.0.1/public/test?code=123456

1st return success：123456  
2nd return failed: "No bean named 'scopedTarget.testRequest' available"  
3rd return success：123456  
4th return failed: "No bean named 'scopedTarget.testRequest' available"  
5th return success：123456  

clear browser session.  

6th return success：123456  
7th return failed: "No bean named 'scopedTarget.testRequest' available"  
8th return success：123456  
9th return failed: "No bean named 'scopedTarget.testRequest' available"  

 **  If you set spring.cloud.refresh.enabled=false, there is no problem with all requests.  **  


@EnableOAuth2Sso is used like this. Now that it has a problem, I wrote a demo project to test the session.  
