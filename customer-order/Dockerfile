FROM openjdk:17-jdk-oracle
ARG JAR_FILE=target/*.jar
COPY ./target/customer-order-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java","-jar","app.jar" ]