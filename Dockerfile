FROM openjdk:8-jdk-alpine
RUN apk --no-cache add curl
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ui.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/ui.jar"]