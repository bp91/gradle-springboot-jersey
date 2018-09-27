# testwebapp

Java project structure for building Web Application using

- Gradle
- Spring Boot
- Jersey framework for REST API
- mybatis or hibernate for the persistence part
- AngularJS for the frontend part
- Grunt as frontend compiler

## Run with gradle; into testwebapp:

`gradle bootRun`

## Override system properties; into testwebapp:

### Mybatis

`gradle bootRun -Pargs=--spring.datasource.url=jdbc:postgresql://10.5.0.4:5432/testwebapp?user=testwebapp,--spring.datasource.username=testwebapp,--spring.datasource.password=testwebapp,spring.datasource.driver-class-name=org.postgresql.Driver,--server.port=8081`

`gradle bootRun -Pargs=--spring.datasource.url=jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2206715,--spring.datasource.username=sql2206715,--spring.datasource.password=rA2*jM7*,--spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver,--server.port=8081`

### Hibernate

`gradle bootRun -Pargs=--spring.datasource.url=jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2206715,--spring.datasource.username=sql2206715,--spring.datasource.password=rA2*jM7*,--spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect,--server.port=8081`

`gradle bootRun -Pargs=--spring.datasource.url=jdbc:postgresql://10.5.0.4:5432/testwebapp?user=testwebapp,--spring.datasource.username=testwebapp,--spring.datasource.password=testwebapp,--spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect,--server.port=8081`

## Run with Docker-Compose:

`docker-compose up -d`
