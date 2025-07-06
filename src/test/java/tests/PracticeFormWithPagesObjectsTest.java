package tests;

import org.junit.jupiter.api.Test;
import tests.TestData;

import java.util.Date;

import static tests.TestData.*;

public class PracticeFormWithPagesObjectsTest extends TestBase {
    TestDataGenerator data = new TestDataGenerator();
    String userName = data.getFirstName();
    String lastName = data.getLastName();
    String userEmail = data.getEmail();
    String gender = data.getGender();
    String phoneNumber = data.getPhoneNumber();
    String address = data.getAddress();
    String subjects = data.getSubject();
    String hobbies = data.getHobby();

    Date birthday = data.getBirthday();
    String dayOfBirth = data.getDayOfBirth(birthday);
    String monthOfBirth = data.getMonthOfBirth(birthday);
    String yearOfBirth = data.getYearOfBirth(birthday);

    String state = data.getState();
    String city = data.getCity(state);

    @Test
    void successfulPracticeFormTest() {

        practiceFormPages.openPage()
                .removeAds()
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
        TestDataGenerator testData = new TestDataGenerator();

        practiceFormPages.openPage()
                .removeAds()
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
        TestDataGenerator testData = new TestDataGenerator();

        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(userName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber("")
                .submitForm();

        practiceFormPages.verifyResultsModalAppearsNeg();
    }
}
