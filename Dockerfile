FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./target/Demo2Application-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","Demo2Application-0.0.1-SNAPSHOT.jar"]