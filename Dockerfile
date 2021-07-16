FROM openjdk:11
WORKDIR /target
ADD tripPricer-0.0.1-SNAPSHOT.jar tripPricer-0.0.1-SNAPSHOT.jar
EXPOSE 8082
CMD java -jar tripPricer-0.0.1-SNAPSHOT.jar
