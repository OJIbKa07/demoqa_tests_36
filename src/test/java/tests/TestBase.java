package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.PracticeFormPages;
import pages.TextBoxPages;

public class TestBase {
    PracticeFormPages practiceFormPages = new PracticeFormPages();
    TextBoxPages textBoxPages = new TextBoxPages();

    @BeforeAll
    static void basicBrowserSettings() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
}
