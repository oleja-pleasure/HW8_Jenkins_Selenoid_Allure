package tests;

import com.github.javafaker.Faker;
import pages.RegistrationForm;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestWithPageObject {

    @BeforeAll
    static void setUpConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void selenideSearchTest() {

        Faker faker = new Faker(new Locale("ru"));

        String fn = faker.name().firstName();
        String ln = faker.name().lastName();
        String email = faker.cat().name()+"@gmail.com";
        String gender = "Other";
        String mobile = faker.number().digits(10);
        String monthOfBirth = "March";
        String yearOfBirth = "1994";
        String dayOfBirth = "12";
        String subject = "Maths";
        String hobby = "Reading";
        String path = "img/";
        String file = "HW#1.jpg";
        String addr = faker.address().city();
        String state = "Haryana";
        String city = "Panipat";

        RegistrationForm registrationForm = new RegistrationForm();

        registrationForm.setFirstName(fn);
        registrationForm.setLastName(ln);
        registrationForm.setEmail(email);
        $(byText(gender)).click();
        registrationForm.setNumber(mobile);
        registrationForm.setDateOfBirth(monthOfBirth, yearOfBirth, dayOfBirth);
        registrationForm.setSubject(subject);
        $(byText(hobby)).click();
        registrationForm.uploadFiles(path, file);
        registrationForm.setCurrentAddress(addr);
        $("#submit").scrollTo();
        registrationForm.setState(state);
        registrationForm.setCity(city);
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(fn + ' ' + ln));
        $x("//td[text()='Student Email']").parent().shouldHave(text(email));
        $x("//td[text()='Gender']").parent().shouldHave(text(gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(dayOfBirth + ' ' + monthOfBirth + ',' + yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(subject));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(hobby));
        $x("//td[text()='Picture']").parent().shouldHave(text(file));
        $x("//td[text()='Address']").parent().shouldHave(text(addr));
        $x("//td[text()='State and City']").parent().shouldHave(text(state + " " + city));
    }

    @AfterAll
    static void closeBrowser() {
        closeWebDriver();
    }
}
