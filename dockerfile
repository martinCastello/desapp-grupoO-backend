FROM openjdk:11-jdk
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} app.war
ENTRYPOINT ["java","-jar","/app.war"]