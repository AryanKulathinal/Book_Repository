FROM openjdk:17-oracle
COPY ./target/books-0.0.1-SNAPSHOT.jar books-service.jar
CMD ["java","-jar","books-service.jar"]