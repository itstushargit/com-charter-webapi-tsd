## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.charter.webapi.rewards.ComCharterWebapiTsdApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Testing the application locally

Once the application up and running please test it from any rest client or from browser by accessing the below REST end point.

"http://localhost:8080/rewards/1001/availablePoints"

Sample test data is configured in the application YML file under src/main/resources folder. Three customers are configured to test (1001, 1002 and 1003 as customer id). You can access the above GET REST API for any of the customer. Even you should be able to add more customer transactions following the same data format and test.

The swagger file of the rest end point is also available in the src/main/resources folder.
