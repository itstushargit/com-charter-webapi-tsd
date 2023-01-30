## Project requirement

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.

A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

Given a record of every transaction during a three-month period, calculate the reward points earned for each customer per month and total.

## Software Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. 

One way is to run the Docker image by running the below command.
`docker run -d -p 8080:8080 docker.io/library/com-charter-webapi-tsd`

Another way is to execute the `main` method in the `com.charter.webapi.rewards.ComCharterWebapiTsdApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Testing the application locally

Once the application up and running please test it from any rest client or from browser by accessing the below REST end point.

http://localhost:8080/rewards/{customerId}/availablePoints

Sample test data is configured in the application YML file under "src/main/resources" folder. Three customers are configured to test (customer id `1001`, `1002` and `1003`). You can get success response from the above GET REST API by using any of these customerIds. Even you should be able to add more customer transactions following the same data format and test.

If you provide any customer id which is not available or in the application yml, you will get a error response saying customer not available.

The swagger file of the rest end point is also available in the "src/main/resources" folder.

