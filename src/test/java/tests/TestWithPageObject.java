package tests;

import pages.RegistrationFormData;
import pages.RegistrationFormPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestWithPageObject {

    @BeforeAll
    static void setUpConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
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
        closeWebDriver();
    }
}
