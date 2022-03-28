import com.codeborne.selenide.Configuration;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class TestBase {

    @BeforeAll
    public static void tokenSetUp() {
        Configuration.startMaximized = true;
        String body;
        body = "{\"login\": \"adilkhan.a@rahmetapp.kz\", \"password\": \"razdvatri\", \"client_id\": \"34958380\", \"grant_type\": \"password\"}";
        Response authorizationToken =
                given()
                        .contentType(JSON)
                        .body(body)
                        .when()
                        .post("https://gateway.choco.kz/auth/token")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        String token = authorizationToken.path("data.token");
        open("https://cabinet.rahmet.biz/assets/img/sidebar/main-page--active.svg");
        getWebDriver().manage().addCookie(new Cookie("Auth-Token", token));
    }

    @BeforeEach
    public void beforeEach() {
        open("https://cabinet.rahmet.biz");
    }
}
