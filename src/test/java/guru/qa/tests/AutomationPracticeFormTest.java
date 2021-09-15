package guru.qa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.tests.TestData.*;


public class AutomationPracticeFormTest extends TestBase {

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue("jsh@cy.cy");
        $("#userNumber").setValue("9999999999");

        $("#genterWrapper").$(byText("Male")).click();

        $("#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").selectOptionByValue("10");
        $("select.react-datepicker__year-select").selectOptionByValue("2070");
        $x("//div[@class='react-datepicker__week']/*[text()=7]").click();

        $("#subjectsInput").setValue("Computer Science").pressEnter();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#currentAddress").setValue("Moscow");

        $("#stateCity-wrapper").$(byText("Select State")).scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#uploadPicture").uploadFromClasspath("art-008.jpg");

        $("#submit").click();

        $(byText("Thanks for submitting the form")).should(exist);
        $x("//td[text()='Student Name']/following-sibling::td").shouldHave(text(firstname + " " + lastname));
        $x("//td[text()='Student Email']/following-sibling::td").shouldHave(text("jsh@cy.cy"));
        $x("//td[text()='Gender']/following-sibling::td").shouldHave(text("Male"));
        $x("//td[text()='Mobile']/following-sibling::td").shouldHave(text("9999999999"));
        $x("//td[text()='Date of Birth']/following-sibling::td").shouldHave(text("07 November,2070"));
        $x("//td[text()='Subjects']/following-sibling::td").shouldHave(text("Computer Science"));
        $x("//td[text()='Hobbies']/following-sibling::td").shouldHave(text("Sports, Reading, Music"));
        $x("//td[text()='Address']/following-sibling::td").shouldHave(text("Moscow"));
        $x("//td[text()='State and City']/following-sibling::td").shouldHave(text("Haryana Karnal"));
        $x("//td[text()='Picture']/following-sibling::td").shouldHave(text("art-008.jpg"));
    }

}
