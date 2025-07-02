package tests;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class TestData {
    public static Faker faker = new Faker(new Locale("en-GB"));

    public static String
            subjects = faker.options().option("Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
                                              "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology"),
            hobbies = faker.options().option("Reading", "Sports", "Music");

    static String
            fullUserName = faker.name().fullName(),
            userName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            currentAddress = faker.address().streetAddress(),
            permanentAddress = faker.address().streetAddress(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            address = faker.address().streetAddress(),
            gender = faker.demographic().sex();

    static String uploadFile = "MyPhoto.jpg";

    static Date fakerDateOfBirthday = faker.date().birthday();
    static String
            dayOfBirth = (new SimpleDateFormat("dd", Locale.ENGLISH)).format(fakerDateOfBirthday),
            monthOfBirth = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(fakerDateOfBirthday),
            yearOfBirth = (new SimpleDateFormat("y", Locale.ENGLISH)).format(fakerDateOfBirthday);

    static Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );

    static String state = faker.options().option(mapStateWithCity.keySet().toArray()).toString();
    static String city = faker.options().option(mapStateWithCity.get(state));



}
