FROM openjdk:8
ADD ./target/carro-service-1.0.jar carro.jar
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=docker" ,"/carro.jar"]