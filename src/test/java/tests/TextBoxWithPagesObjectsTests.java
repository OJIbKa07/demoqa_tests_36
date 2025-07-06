package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static tests.TestData.*;

public class TextBoxWithPagesObjectsTests extends TestBase{
    TestDataGenerator data = new TestDataGenerator();
    String fullUserName = data.getFullUserName();
    String userEmail = data.getEmail();
    String currentAddress = data.getAddress();
    String permanentAddress = data.getAddress();

    @Test
    void successfulTextBoxTest() {
        textBoxPages.openPage()
                .removeAds()
                .setUserName(fullUserName)
                .setEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitForm();

        textBoxPages
                .verifyResult("Name:", fullUserName)
                .verifyResult("Email:", userEmail)
                .verifyResult("Current Address :", currentAddress)
                .verifyResult("Permananet Address :", permanentAddress);
    }
}
