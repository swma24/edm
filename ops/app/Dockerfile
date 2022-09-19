FROM amazoncorretto:17.0.4-alpine AS build

COPY gradle gradle
COPY gradlew .
COPY settings.gradle.kts .
COPY build.gradle.kts .
RUN ./gradlew dependencies # caching dependencies
COPY service service
COPY app app
RUN ./gradlew clean
RUN ./gradlew app:bootJar --parallel

FROM amazoncorretto:17.0.4-alpine AS run

ENV TZ=Asia/Seoul
RUN apk add --no-cache tzdata && \
	cp /usr/share/zoneinfo/$TZ /etc/localtime && \
	echo $TZ > /etc/timezone && \
	apk del tzdata
COPY config config
COPY --from=build app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
# docker build -f ops/app/Dockerfile . -t edm-app
# docker run -e SPRING_PROFILES_ACTIVE=test -e VAULT_URI=... -p 8080:8080 -t edm-app