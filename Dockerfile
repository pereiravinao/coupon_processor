FROM eclipse-temurin:17-jdk-alpine

ENV SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/coupondb
ENV SPRING_DATASOURCE_USERNAME=postgres
ENV SPRING_DATASOURCE_PASSWORD=admin
ENV SPRING_RABBITMQ_HOST=rabbitmq
ENV RABBITMQ_DEFAULT_USER=guest
ENV RABBITMQ_DEFAULT_PASS=guest

WORKDIR /app

COPY target/coupon-processor-1.0.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]