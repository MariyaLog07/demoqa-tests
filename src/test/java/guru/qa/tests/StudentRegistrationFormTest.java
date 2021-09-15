package guru.qa.tests;

import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static guru.qa.tests.TestData.*;

public class StudentRegistrationFormTest extends TestBase {

    Faker faker = new Faker();
    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String currentAddress = faker.address().fullAddress();

    @Test
    void positiveFillTest() {
        registrationPage.openPage();
        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.typePhoneNumber(userNumber);
        registrationPage.chooseGender(gender);
        registrationPage.calendar.setDate(day, month, year);
        registrationPage.typeSubject(subject);
        registrationPage.setHobbies(hobbie1, hobbie2, hobbie3);
        registrationPage.typeAddress(currentAddress);
        registrationPage.choseStateAndCity(state, city);
        registrationPage.uploadPicture(fileName);
        registrationPage.clickSubmit();
        registrationPage.checkResults(firstName, lastName, userEmail, userNumber, subject, currentAddress, city);
    }
}
