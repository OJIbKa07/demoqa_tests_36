package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPages;

public class TextBoxWithPagesObjectsTests extends TestBase{
    TextBoxPages textBoxPages = new TextBoxPages();
    String userName = "Olga Palushina";
    String email = "lqokag@gmail.com";
    String currentAddress= "Russia, Kaluga";
    String permanentAddress= "Russia, Kaluga";

    @Test
    void successfulTextBoxTest() {
        textBoxPages.openPage()
                .removeAds()
                .setUserName(userName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(currentAddress)
                .submitForm();

        textBoxPages
                .verifyResult("Name:", userName)
                .verifyResult("Email:", email)
                .verifyResult("Current Address :", currentAddress)
                .verifyResult("Permananet Address :", permanentAddress);
    }
}
