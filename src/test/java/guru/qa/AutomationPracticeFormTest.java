package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    @BeforeAll
     static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("John");
        $("#lastName").setValue("Shephard");
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

        $("button#submit").click();

    }

}
