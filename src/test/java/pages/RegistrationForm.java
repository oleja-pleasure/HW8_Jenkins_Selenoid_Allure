package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationForm {
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

    public void setFirstName(String value) {
        firstName.val(value);
    }

    public void setLastName(String value) {
        lastName.val(value);
    }

    public void setEmail(String value) {
        email.val(value);
    }

    public void setNumber(String value) {
        number.val(value);
    }

    public void setDateOfBirth(String month, String year, String day) {
        fieldDOB.click();
        monthOfBirth.selectOption(month);
        yearOfBirth.selectOption((year));
        dayOfBirth.$(byText(day)).click();
    }

    public void setSubject(String value) {
        subject.val(value).pressEnter();
    }

    public void uploadFiles(String path, String value) {
        uploadFile.uploadFromClasspath(path + value);
    }

    public void setCurrentAddress(String value) {
        currentAddress.val(value);
    }

    public void setState(String value) {
        state.click();
        $(byText(value)).click();
    }

    public void setCity(String value) {
        city.click();
        $(byText(value)).click();
    }
}


