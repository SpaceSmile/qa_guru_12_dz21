package com.browserstack.helpers;

import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    public static String videoUrl(String sessionId) {

        String url = format(config.sessionsUrl(), sessionId);

        return given()
                .auth().basic(config.username(), config.accessKey())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video.url");
    }
}
