FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/manager-0.0.1-SNAPSHOT.jar bank.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "bank.jar"]