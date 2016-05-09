package cat.meteo.exercise.integrationTest;

import static com.jayway.restassured.RestAssured.given;

/**
 *
 * @author marc
 */
public class TestCalls {
    
    public static void doGet(String resource, int port, int expectedStatus) {
        given().
                port(port).
        when().
            get(resource).
        then().
            statusCode(expectedStatus);
    }
}
