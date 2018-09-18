# testWebapp

Java project structure for building Web Application using
  - Gradle
  - Spring Boot
  - Jersey framework for REST API
  - mybatis for the persistence part
  - AngularJS for the frontend part
  - Grunt as frontend compiler

## Run with gradle:
### gradle bootRun

## Override system properties:
### gradle bootRun -Pargs=--spring.datasource.url=jdbc:postgresql://10.5.0.4:5432/testwebapp?user=testwebapp,--Dspring.datasource.password=testwebapp

## Run with Docker-Compose:
# docker-compose up -d