package tests;

import org.junit.jupiter.api.Test;
import tests.TestData;

import static tests.TestData.*;

public class PracticeFormWithPagesObjectsTest extends TestBase {


    @Test
    void successfulPracticeFormTest() {

        practiceFormPages.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setBirthDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(uploadFile)
                .setAddress(address)
                .selectStateAndCity(state, city)
                .submitForm();

        practiceFormPages.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", uploadFile)
                .verifyResult("Address", address)
                .verifyResult("State and City", state + " " + city);
    }

    @Test
    void successfulMinFormTest() {

        practiceFormPages.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber(phoneNumber)
                .submitForm();

        practiceFormPages.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber);
    }

    @Test
    void negativeMinFormTest() {

        practiceFormPages.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber("")
                .submitForm();

        practiceFormPages.verifyResultsModalAppearsNeg();
    }
}
