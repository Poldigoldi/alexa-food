FROM tomcat:8.0-alpine
LABEL maintainer="leonard.c.goldschmidt@gmail.com"

ADD keystore.jks /usr/local/tomcat/conf/
COPY server.xml /usr/local/tomcat/conf/

ADD sample.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]

