FROM tomcat:8.0-alpine
LABEL maintainer="leonard.c.goldschmidt@gmail.com"

COPY server.xml /
ADD helloworldservlet.war /usr/local/tomcat/webapps/


EXPOSE 8080
CMD ["catalina.sh", "run"]
