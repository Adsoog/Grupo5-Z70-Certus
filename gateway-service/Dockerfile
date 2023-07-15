FROM openjdk:8
ADD ./target/gateway-service-1.0.jar gateway.jar
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=docker" ,"/gateway.jar"]