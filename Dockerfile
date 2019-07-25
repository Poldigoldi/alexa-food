FROM tomcat:8.0-alpine
LABEL maintainer="deepak@softwareyoga.com"

ADD /Volumes/Internal_HDD/UNI/Bristol/Thesis/alexa-food/target/helloworldservlet.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
