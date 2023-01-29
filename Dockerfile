FROM openjdk:8
ADD target/com-charter-webapi-tsd.jar com-charter-webapi-tsd.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "com-charter-webapi-tsd.jar"]