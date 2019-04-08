package aatt_api;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.restassured.http.ContentType;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import util.AllureAPITestListener;

import static api.requests.BadgesRequests.getBadges;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static util.PropertiesReader.getProperty;

@Listeners(AllureAPITestListener.class)
public class BadgesTest {

    // with request layer and additional logs (response time)
    @Test
    @Feature("Badges")
    @Link("Test case number here")
    @Description("Test verify if badges call status code is 200 and contains 'cryptography' badge name")
    public void testLogoExist() {
        getBadges()
                .then()
                .statusCode(200)
                .body("items.name", hasItems("cryptography"),
                        "items.award_count", hasItems(33));
    }

    // without request layer, just bdd template
    @Test
    @Feature("Badges")
    @Link("Test case number here")
    @Description("Test verify if badges call status code is 200 and contains 'cryptography' badge name")
    public void testLogoExist_() {
        given()
                .accept(ContentType.JSON)
                .baseUri(getProperty("api.base.url"))
                .basePath(getProperty("api.base.badges.path"))
                //delete if do not need print logs
                .log().all().
        when()
                .queryParam("order", "desc")
                .queryParam("sort", "rank")
                .queryParam("site", "stackoverflow")
                .get().
        then()
                .statusCode(200)
                .body("items.name", hasItems("cryptography"),
                        "items.award_count", hasItems(33))
                //delete if do not need print logs
                .log().all();
    }
}
