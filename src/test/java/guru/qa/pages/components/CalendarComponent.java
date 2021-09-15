package guru.qa.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {

        $("#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").selectOption(month);
        $("select.react-datepicker__year-select").selectOption(year);
        $x("//div[@class='react-datepicker__week']/*[text()=" + day + "]").click();
    }
}
