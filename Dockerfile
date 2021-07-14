FROM openjdk:11
RUN mkdir /app
COPY ./out/artifacts/tripPricer_jar/tripPricer.jar /app/tripPricer.jar
WORKDIR /app
CMD "java" "-jar" "tripPricer.jar"