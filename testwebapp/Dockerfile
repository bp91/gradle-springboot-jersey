FROM bp91/ubuntu16.04-tomcat9-java8:latest

RUN chmod 775 /opt/tomcat/bin/catalina.sh

RUN chown root:root /opt/tomcat/bin/catalina.sh

COPY build/libs/*.war /tmp/webapps/

RUN cp -r /tmp/webapps/* /opt/tomcat/webapps/

EXPOSE 8080

ENV JAVA_OPTS ""
ENV JVM_OPTS ""
ENV CATALINA_OPTS ""

CMD sh /opt/tomcat/bin/catalina.sh start $JAVA_OPTS $JVM_OPTS $CATALINA_OPTS && touch /opt/tomcat/logs/testWebapp-0.0.1-SNAPSHOT.log && tail -f /opt/tomcat/logs/testWebapp-0.0.1-SNAPSHOT.log