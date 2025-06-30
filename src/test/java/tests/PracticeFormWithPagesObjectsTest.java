package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormWithPagesObjectsTest extends TestBase {
    String userName = "Olga";
    String lastName = "Palushina";
    String email = "lqokag@gmail.com";
    String gender = "Female";
    String phoneNumber = "8965412365";
    String[] birthday  = new String[] {"31", "July", "2003"};
    String subjects = "Maths";
    String hobbies = "Reading";
    String uploadFile = "MyPhoto.jpg";
    String address= "123 Main St.";
    String[] stateAndCity  = new String[] {"NCR", "Delhi"};

    @Test
    void successfulPracticeFormTest() {

        practiceFormPages.openPage()
                .setFirstName(userName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(phoneNumber)
                .setBirthDate(birthday[0], birthday[1], birthday[2])
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .uploadPicture(uploadFile)
                .setAddress(address)
                .selectStateAndCity(stateAndCity[0], stateAndCity[1])
                .submitForm();

        practiceFormPages.verifyResultsModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", phoneNumber)
                .verifyResult("Date of Birth", birthday[0] + " " + birthday[1] + "," + birthday[2])
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", uploadFile)
                .verifyResult("Address", address)
                .verifyResult("State and City", stateAndCity[0] + " " + stateAndCity[1]);
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
