package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.RegistrationFormData;
import pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static helpers.Attach.getSessionId;

public class TestWithPageObject {

    @BeforeAll
    static void setUpConfig() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";

    }

    @Test
    void selenideSearchTest() {

        RegistrationFormPage registrationFormPage = new RegistrationFormPage();
        RegistrationFormData registrationFormData = new RegistrationFormData();
        registrationFormPage.fillForm(registrationFormData);
        registrationFormPage.checkForm(registrationFormData);

    }

    @AfterAll
    static void closeBrowser() {
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        closeWebDriver();
        Attach.addVideo(sessionId);
    }
}
