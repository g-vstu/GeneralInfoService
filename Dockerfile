FROM openjdk:8-jdk-alpine
FROM maven:alpine
RUN mkdir /app
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests
COPY ./target/employeeManager-0.0.1-SNAPSHOT.jar /app/app.jar
CMD "java" "-jar" "app.jar"