FROM openjdk:11
COPY ".target/code.challenge/target/code.challenge-0.0.1-SNAPSHOT.war" "app.war"
EXPOSE 8080
ENTRYPOINT ["java", "-war" "app.war"]