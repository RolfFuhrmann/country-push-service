# Spring Boot Push Service based on Websocket

The service can run standalone in Docker.

## Build, install and run Application in Docker

- mvn clean install
- docker buildx build --platform linux/arm64 -t country-push-service .
- docker run --name CountryPushService -p 8082:8080 -t country-push-service

Further information on the topic of build containers:

- https://www.docker.com/blog/9-tips-for-containerizing-your-spring-boot-code/
- https://hub.docker.com/_/openjdk

## Requests when everything is running

- In Docker http://localhost:8082
- local -> http://localhost:8080

## Testing

Alle Endpoints können mit Insomnia getestet werden

- Hinzufügen eines neuen WS Request mit: ws://localhost:8080/websocket und dann Button Connect drücken.
- Hinzufügen eines neuen POST Request mit: http://localhost:8080/send/country
