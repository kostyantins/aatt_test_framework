package api.requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static util.ReportUtil.logResponseTime;

public class BadgesRequests extends BasedRequest {

    public static Response getBadges() {
        final Response response =
                given()
                        .accept(ContentType.JSON)
                        .baseUri(BASE_URL)
                        .basePath(BADGES_PATH)
                        .queryParam("order", "desc")
                        .queryParam("sort", "rank")
                        .queryParam("site", "stackoverflow")
                        .get();

        return logResponseTime(response);
    }
}
