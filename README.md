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

All endpoints can be tested manually using the URLs below (with Insomnia, Postman etc.). The prerequisite is that the service is started locally.

- Add a new WS request to test the WebSocketController: ws://localhost:8080/websocket and then press the 'Connect' button.
- Add a new POST request to test the PushController: http://localhost:8080/send/country.
