package guru.qa.tests;

import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

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
        step("Open students registration form", () -> {
                    registrationPage.openPage();
                });

        step("Fill students registration form", () -> {
            step("Fill common data", () -> {
                registrationPage.typeFirstName(firstName);
                registrationPage.typeLastName(lastName);
                registrationPage.typeEmail(userEmail);
                registrationPage.typePhoneNumber(userNumber);
                registrationPage.chooseGender(gender);
            });
            step("Set date", () -> {
                registrationPage.calendar.setDate(day, month, year);
            });
            step("Set subject", () -> {
                registrationPage.typeSubject(subject);
            });
            step("Set hobbies", () -> {
                registrationPage.setHobbies(hobbie1, hobbie2, hobbie3);
            });
            step("Set address", () -> {
                registrationPage.typeAddress(currentAddress);
                registrationPage.choseStateAndCity(state, city);
            });
            step("Upload picture", () -> {
                registrationPage.uploadPicture(fileName);
            });
            step("Submit form", () -> {
                registrationPage.clickSubmit();
            });
        });

        step("Verify successful form submit", () -> {
            registrationPage.checkResults(firstName, lastName, userEmail, userNumber, subject, currentAddress, city);
        });
    }
}
