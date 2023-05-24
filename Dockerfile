FROM openjdk:8-jdk
EXPOSE 8087
ADD ./build/libs/consolidate-data-provider-service-*-SNAPSHOT.jar consolidate-data-provider-service.jar
ENTRYPOINT ["java", "-jar", "consolidate-data-provider-service.jar"]