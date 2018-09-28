FROM java:8-jdk-alpine

RUN apk update --no-progress && apk add --no-progress tzdata && cp /usr/share/zoneinfo/Europe/Rome /etc/localtime && echo "Europe/Rome" > /etc/timezone && apk del --no-progress tzdata

VOLUME /tmp

COPY build/libs/*.jar app.jar

RUN addgroup -S -g 1000 toor && adduser -S -u 1000 -G toor toor
RUN sh -c 'touch /app.jar' && chmod 644 /app.jar

USER root

ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]