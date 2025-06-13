import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class TextBoxTests {


    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fullFormTest() {
        open("/text-box");

        $("#userName").setValue("Olga Palushina");
        $("#userEmail").setValue("lqoka2015@yandex.ru");
        $("#currentAddress").setValue("Russia, Kaluga");
        $("#permanentAddress").setValue("Russia, Kaluga");

        $("#submit").click();
        $("#output").shouldHave(text("Olga Palushina"), text("lqoka2015@yandex.ru"), text("Russia, Kaluga"), text("Russia, Kaluga"));

    }
}