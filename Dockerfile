FROM java:8
EXPOSE 8080
ADD /target/restapp-0.0.1-SNAPSHOT.jar restapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "restapp-0.0.1-SNAPSHOT.jar", "--spring.datasource.url=jdbc:postgresql://10.0.0.3/springdb"]