import com.codeborne.selenide.Configuration;
import helpers.AllureRestAssuredFilter;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class TestBase {

//    SmokeTest mainPage = new SmokeTest();

    @BeforeAll
    public static void browser() {
        Configuration.startMaximized = true;

        open("http://rahmetbiz.chocodev.kz/");
        $("[type='text']").setValue("77078092707")
                .pressEnter();
        $(byText("adilk***@rahmetapp.kz")).click();
        $("button").click();
        $("[type='text']").setValue("4444")
                .pressEnter();
    }

    @BeforeAll
    public static void setUp() {
        Object driver = null;
        Response authorizationToken =
                given()
                        .filter(AllureRestAssuredFilter.withCustomTemplates())
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .formParam("login", "adilkhan.a@rahmetapp.kz")
                        .formParam("password", "razdvatri")
                        .formParam("client_id", "34958381")
                        .formParam("grant_type", "password")
                        .when()
                        .post("https://gateway.choco.kz/auth/token")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        String token = authorizationToken.path("data.token");

        try {
            open("http://cabinet.rahmet.biz/");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("return window.stop");
        } catch (NullPointerException e) {
            System.out.println("Error with stopping of loading page in browser");
        }

        getWebDriver().manage().addCookie(new Cookie("Auth-Token", token));
    }

    @BeforeEach
    public void beforeEach() {
        open("http://rahmetbiz.chocodev.kz/");
    }
}
