FROM tomcat:8.0-alpine
LABEL maintainer="leonard.c.goldschmidt@gmail.com"

#ADD .keystore /usr/local/tomcat/conf/
#COPY server.xml /usr/local/tomcat/conf/
#COPY context.xml /usr/local/tomcat/conf/
#COPY web.xml /usr/local/tomcat/webapps/ROOT/WEB-INF/

ADD helloworldservlet.war /usr/local/tomcat/webapps/

EXPOSE 443
#EXPOSE 8080
CMD ["catalina.sh", "run"]
