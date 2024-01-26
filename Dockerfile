# Start with a base image containing Java runtime
FROM openjdk:17

# Add Maintainer Info

# Add a volume pointing to /app
VOLUME /app

# Listen to port 8082 inside the platform
EXPOSE 8082

# The application's jar file
ARG JAR_FILE=target/country-push-service-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} country-push-service-0.0.1-SNAPSHOT.jar

# Run the jar file
ENTRYPOINT ["java","-jar","country-push-service-0.0.1-SNAPSHOT.jar"]