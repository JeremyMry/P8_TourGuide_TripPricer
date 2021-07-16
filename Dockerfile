FROM openjdk:11
RUN mkdir /app
COPY ./target/tripPricer-0.0.1-SNAPSHOT.jar /app/tripPricer-0.0.1-SNAPSHOT.jar
WORKDIR /app
EXPOSE 8082
CMD "java" "-jar" "tripPricer-0.0.1-SNAPSHOT.jar"