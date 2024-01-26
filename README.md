# Spring Boot Push Service mit Websocket

Der Service kann standalone in Docker laufen

- The original package name 'websocket-push-service' is invalid and this project uses 'websocketpushservice' instead.

## Build, install and run Application in Docker Container

- mvn clean install
- docker buildx build --platform linux/arm64 -t country-push-service .
- docker run --name CountryPushService -p 8082:8080 -t country-push-service

Weiter gehende Infos zum Thema build container:

- https://www.docker.com/blog/9-tips-for-containerizing-your-spring-boot-code/
- https://hub.docker.com/_/openjdk

# Requests wenn alles läuft

- http://localhost:8082/ -> für Docker container
- http://localhost:8080/ -> local
