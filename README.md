# spring-config-server-poc-issue

To run the server:
```bash
java -Dspring.profiles.active=native -Dserver.port=8888 -jar target\config-server-0.0.1-SNAPSHOT.jar
```

To run the client:
```bash
java -Dspring.profiles.active=dev -jar target\config-client-0.0.1-SNAPSHOT.jar`
```