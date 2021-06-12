package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    SelenideElement firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            number = $("#userNumber"),
            fieldDOB = $("#dateOfBirthInput"),
            monthOfBirth = $(".react-datepicker__month-select"),
            yearOfBirth = $(".react-datepicker__year-select"),
            dayOfBirth = $(".react-datepicker__month"),
            subject = $("#subjectsInput"),
            uploadFile = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city");

    public void fillForm(RegistrationFormData formData){
        open("https://demoqa.com/automation-practice-form");
        firstName.val(formData.fn);
        lastName.val(formData.ln);
        email.val(formData.email);
        $(byText(formData.gender)).click();
        number.val(formData.mobile);
        fieldDOB.click();
        monthOfBirth.selectOption(formData.monthOfBirth);
        yearOfBirth.selectOption(formData.yearOfBirth);
        dayOfBirth.$(byText(formData.dayOfBirth)).click();
        subject.val(formData.subject).pressEnter();
        $(byText(formData.hobby)).click();
        uploadFile.uploadFromClasspath(formData.path + formData.file);
        currentAddress.val(formData.addr);
        $("#submit").scrollTo();
        state.click();
        $(byText(formData.state)).click();
        city.click();
        $(byText(formData.city)).click();
        $("#submit").click();
    }

    public void checkForm(RegistrationFormData formData){
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text(formData.fn + ' ' + formData.ln));
        $x("//td[text()='Student Email']").parent().shouldHave(text(formData.email));
        $x("//td[text()='Gender']").parent().shouldHave(text(formData.gender));
        $x("//td[text()='Mobile']").parent().shouldHave(text(formData.mobile));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text(formData.dayOfBirth + ' ' + formData.monthOfBirth + ',' + formData.yearOfBirth));
        $x("//td[text()='Subjects']").parent().shouldHave(text(formData.subject));
        $x("//td[text()='Hobbies']").parent().shouldHave(text(formData.hobby));
        $x("//td[text()='Picture']").parent().shouldHave(text(formData.file));
        $x("//td[text()='Address']").parent().shouldHave(text(formData.addr));
        $x("//td[text()='State and City']").parent().shouldHave(text(formData.state + " " + formData.city));
    }
}


