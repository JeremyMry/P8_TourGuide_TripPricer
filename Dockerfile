FROM openjdk:11
WORKDIR /out/artifacts/gpsUtil_jar
ADD tripPricer.jar tripPricer.jar
EXPOSE 8082
CMD java -jar tripPricer.jar
