# testwebapp

Java project structure for building Web Application using

- Gradle
- Spring Boot
- Jersey framework for REST API
- mybatis for the persistence part
- AngularJS for the frontend part
- Grunt as frontend compiler

## Run with gradle; into testwebapp:

`gradle bootRun`

## Override system properties; into testwebapp:

`gradle bootRun -Pargs=--spring.datasource.url=jdbc:postgresql://localhost:5432/testwebapp?user=testwebapp,--spring.datasource.password=testwebapp,--server.port=8081`

## Run with Docker-Compose:

`docker-compose up -d`
