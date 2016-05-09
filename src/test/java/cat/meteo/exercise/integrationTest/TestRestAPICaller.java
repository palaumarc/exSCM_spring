package cat.meteo.exercise.integrationTest;

import static com.jayway.restassured.RestAssured.given;
import org.springframework.stereotype.Component;

/**
 *
 * @author marc
 */

@Component
public class TestRestAPICaller {
    
    public void doGet(String resource, int port, int expectedStatus) {
        given().
                port(port).
        when().
            get(resource).
        then().
            statusCode(expectedStatus);
    }
}
