FROM openjdk:8
EXPOSE 8003
ADD ./target/moto-service-1.0.jar moto.jar
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=docker" ,"/moto.jar"]