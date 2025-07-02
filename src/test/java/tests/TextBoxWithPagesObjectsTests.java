package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static tests.TestData.*;

public class TextBoxWithPagesObjectsTests extends TestBase{


    @Test
    void successfulTextBoxTest() {
        textBoxPages.openPage()
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
