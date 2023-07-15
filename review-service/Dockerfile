FROM openjdk:8
ADD ./target/review-service-1.0.jar review.jar
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=docker" ,"/review.jar"]