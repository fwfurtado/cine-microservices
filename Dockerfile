FROM openjdk:8-jdk-alpine
ARG JAR_FILE

RUN mkdir /application

COPY ${BUILD_VERSION} /application/app.jar

EXPOSE 8080

WORKDIR /application

ENTRYPOINT java $JAVA_OPTS -jar app.jar

