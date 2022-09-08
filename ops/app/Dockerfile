FROM amazoncorretto:17.0.4-alpine AS build

COPY gradle gradle
COPY gradlew .
COPY settings.gradle.kts .
COPY build.gradle.kts .
COPY service service
COPY app app
RUN ./gradlew app:bootJar -x test

FROM amazoncorretto:17.0.4-alpine AS run

ENV TZ=Asia/Seoul
RUN apk add --no-cache tzdata && \
	cp /usr/share/zoneinfo/$TZ /etc/localtime && \
	echo $TZ > /etc/timezone && \
	apk del tzdata
COPY ops/app ops/app
COPY --from=build app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
# docker build -f ops/app/Dockerfile . -t edm-app
# docker run -e SPRING_PROFILES_ACTIVE=local -p 8080:8080 -t edm-app edm-app