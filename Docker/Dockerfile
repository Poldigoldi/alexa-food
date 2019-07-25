FROM tomcat:8.0-alpine
LABEL maintainer="leonard.c.goldschmidt@gmail.com"

COPY server.xml /usr/local/tomcat/conf/
COPY keystore.jks /usr/local/tomcat/conf/
COPY context.xml /usr/local/tomcat/conf/

ADD helloworldservlet.war /usr/local/tomcat/webapps/


EXPOSE 8080
CMD ["catalina.sh", "run"]
