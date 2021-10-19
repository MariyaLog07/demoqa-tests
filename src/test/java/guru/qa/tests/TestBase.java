package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.config.CredentialsConfig;
import guru.qa.tests.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.aeonbits.owner.ConfigFactory;
import static java.lang.String.format;


public class TestBase {
    static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    static String loginForSelenoid = credentials.login();
    static String passwordForSelenoid = credentials.password();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.remote =
                format("https://%s:%s@%s", loginForSelenoid, passwordForSelenoid, System.getProperty("remoteUrl"));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
