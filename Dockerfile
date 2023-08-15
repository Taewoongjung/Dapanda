FROM openjdk:17 AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew boot.jar

FROM openjdk:17
COPY --from=builder /build/libs/app.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
