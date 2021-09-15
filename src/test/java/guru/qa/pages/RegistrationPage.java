package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement formTitle = $(".practice-form-wrapper"),
                    firstNameInput = $("#firstName"),
                    lastNameInput = $("#lastName"),
                    userEmailInput =  $("#userEmail"),
                    userNumber = $("#userNumber"),
                    subjectsInput = $("#subjectsInput"),
                    hobbiesWrapper = $("#hobbiesWrapper"),
                    currentAddress = $("#currentAddress"),
                    stateDropdown = $("#stateCity-wrapper").$(byText("Select State")),
                    stateCityDropdown = $("#stateCity-wrapper").$(byText("Select City")),
                    stateSelector = $("#state"),
                    citySelector = $("#city"),
                    uploadPictureButton = $("#uploadPicture"),
                    submitButton = $("#submit"),
                    resultsValue = $("tbody");

    private final String FORM_TITLE = "Student Registration Form";

    public CalendarComponent calendar = new CalendarComponent();

    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage typePhoneNumber (String value) {
        userNumber.setValue(value);
        return this;
    }

    public RegistrationPage chooseGender (String value) {
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }

    public RegistrationPage typeSubject(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbie1, String hobbie2, String hobbie3) {
        hobbiesWrapper.$(byText(hobbie1)).click();
        hobbiesWrapper.$(byText(hobbie2)).click();
        hobbiesWrapper.$(byText(hobbie3)).click();
        return this;
    }

    public RegistrationPage typeAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage choseStateAndCity(String state, String city) {
        stateDropdown.scrollIntoView(true).click();
        stateSelector.$(byText(state)).click();
        stateCityDropdown.click();
        citySelector.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage uploadPicture(String fileName) {
        uploadPictureButton.uploadFromClasspath(fileName);
        return this;
    }

    public void checkResults(String firstName, String lastName, String userEmail, String userNumber, String subject,
                             String currentAddress, String city) {
        resultsValue.shouldHave(
                    text(firstName + " " + lastName),
                    text(userEmail),
                    text(userNumber),
                    text(subject),
                    text(currentAddress),
                    text(city)
        );
    }

}
