FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY target/mod2-0.0.1-SNAPSHOT.jar app.jar

ENV STUDENT_GENERATOR_ENABLED=true
ENV SPRING_SHELL_LOGLEVEL=DEBUG


CMD ["java", "-jar", "app.jar"]