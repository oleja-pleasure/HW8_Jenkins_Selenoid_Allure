package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RegistrationFormData {
    Faker faker = new Faker(new Locale("ru"));

    public String fn = faker.name().firstName();
    public String ln = faker.name().lastName();
    public String email = faker.cat().name()+"@gmail.com";
    public String gender = "Other";
    public String mobile = faker.number().digits(10);
    public String monthOfBirth = "March";
    public String yearOfBirth = "1994";
    public String dayOfBirth = "12";
    public String subject = "Maths";
    public String hobby = "Reading";
    public String path = "img/";
    public String file = "HW#1.jpg";
    public String addr = faker.address().city();
    public String state = "Haryana";
    public String city = "Panipat";
}
