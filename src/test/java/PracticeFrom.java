import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFrom {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fullFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Olga");
        $("#lastName").setValue("Palushina");
        $("#userEmail").setValue("lqoka2015@yandex.ru");

        $(byText("Female")).click();

        $("#userNumber").setValue("92224040555");

        $(".subjects-auto-complete__control .subjects-auto-complete__indicator-separator").setValue("1");

        // календарь
        $("#react-datepicker__input-container").click();
        $(byText("14")).click();
        $("#react-datepicker__month-select").selectOption("July");
        $("#react-datepicker__year-select").selectOption("2003");

        //subject
        $("#subjects-auto-complete__control").setValue("9222404");

        //хобби
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-2").click();
        $("#hobbies-checkbox-3").click();

        //address

        $("#form-control").setValue("Russia");
        $(".stateCity-wrapper");



    }
}