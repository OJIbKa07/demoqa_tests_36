package tests;

import org.junit.jupiter.api.Test;
import tests.TestData;

import java.util.Date;

import static tests.TestData.*;

public class PracticeFormWithPagesObjectsTest extends TestBase {
    SuitTestData data = new SuitTestData();

    @Test
    void successfulPracticeFormTest() {

        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(data.userName)
                .setLastName(data.lastName)
                .setEmail(data.userEmail)
                .setGender(data.gender)
                .setNumber(data.phoneNumber)
                .setBirthDate(data.dayOfBirth, data.monthOfBirth, data.yearOfBirth)
                .setSubjects(data.subjects)
                .setHobbies(data.hobbies)
                .uploadPicture(uploadFile)
                .setAddress(data.address)
                .selectStateAndCity(data.state, data.city)
                .submitForm();

        practiceFormPages.verifyResultsModalAppears()
                .verifyResult("Student Name", data.userName + " " + data.lastName)
                .verifyResult("Student Email", data.userEmail)
                .verifyResult("Gender", data.gender)
                .verifyResult("Mobile", data.phoneNumber)
                .verifyResult("Date of Birth", data.dayOfBirth + " " + data.monthOfBirth + "," + data.yearOfBirth)
                .verifyResult("Subjects", data.subjects)
                .verifyResult("Hobbies", data.hobbies)
                .verifyResult("Picture", uploadFile)
                .verifyResult("Address", data.address)
                .verifyResult("State and City", data.state + " " + data.city);
    }

    @Test
    void successfulMinFormTest() {
        TestDataGenerator testData = new TestDataGenerator();

        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(data.userName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setNumber(data.phoneNumber)
                .submitForm();

        practiceFormPages.verifyResultsModalAppears()
                .verifyResult("Student Name", data.userName + " " + data.lastName)
                .verifyResult("Gender", data.gender)
                .verifyResult("Mobile", data.phoneNumber);
    }

    @Test
    void negativeMinFormTest() {
        TestDataGenerator testData = new TestDataGenerator();

        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(data.userName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setNumber("")
                .submitForm();

        practiceFormPages.verifyResultsModalAppearsNeg();
    }
}
