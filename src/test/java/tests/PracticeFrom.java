package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFrom {

    @BeforeAll
    static void basicBrowserSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fullFormTest() {
        open("/automation-practice-form");

        // Блок Name
        $("#firstName").setValue("Olga");
        $("#lastName").setValue("Palushina");

        // Блок Email
        $("#userEmail").setValue("lqoka2015@yandex.ru");

        // Блок выбора пола
        $(byText("Female")).click();

        // Блок Mobile
        $("#userNumber").setValue("92224040555");

        // Блок выбора даты рождения
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2003");
        $$(".react-datepicker__day").findBy(text("14")).click();

        // Блок Subjects
        $("#subjectsInput").setValue("Math");
        $$(".subjects-auto-complete__option").findBy(text("Maths")).click();
        $("#subjectsInput").setValue("Phy");
        $$(".subjects-auto-complete__option").findBy(text("Physics")).click();
        $("#subjectsInput").setValue("Eng");
        $$(".subjects-auto-complete__option").findBy(text("English")).click();

        // Блок Hobbies
        $("label[for='hobbies-checkbox-1']").click();
        $("label[for='hobbies-checkbox-3']").click();

        // Блок загрузки фото из ресурсов проекта
        $("#uploadPicture").uploadFromClasspath("MyPhoto.jpg");


        // Блок Current Address
        $("#currentAddress")
                .scrollTo()
                .shouldBe(visible, enabled)
                .setValue("Russia, Kaluga");

        // Блок State and City
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").pressEnter();


        // Проверка текста в форме после заполнения
        $(".table-responsive").shouldHave(text("Olga Palushina"));
        $(".table-responsive").shouldHave(text("lqoka2015@yandex.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("9222404055"));
        $(".table-responsive").shouldHave(text("14 July,2003"));
        $(".table-responsive").shouldHave(text("Maths, Physics, English"));
        $(".table-responsive").shouldHave(text("Sports, Music"));
        $(".table-responsive").shouldHave(text("MyPhoto.jpg"));
        $(".table-responsive").shouldHave(text("Russia, Kaluga"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}