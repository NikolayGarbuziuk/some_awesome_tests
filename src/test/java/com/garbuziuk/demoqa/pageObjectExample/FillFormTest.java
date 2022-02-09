package com.garbuziuk.demoqa.pageObjectExample;

import com.garbuziuk.demoqa.pageObjectExample.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;

public class FillFormTest {

    @BeforeAll
    public static void setUp() {
        baseUrl="https://demoqa.com";
        //startMaximized=true;
    }

    @Test
    void fillFormTest(){

//Arrange
         Faker faker = new Faker();

         String firstName = faker.name().firstName();
         String lastName = faker.name().lastName();
         String email = faker.internet().safeEmailAddress();
         String userNumber = faker.phoneNumber().subscriberNumber(10);
         String address = faker.address().fullAddress();

        RegistrationPage registrationPage = new RegistrationPage();
//Act
        registrationPage.openPage()
            .setFirstName(firstName)
            .setLastName(lastName)
            .setEmail(email)
            .selectGender("Male")
            .setMobileNumber(userNumber)
            .setDateOfBirht("1991", "February", 22)
            .setSubject("Maths")
            .setHobby("Sports")
            .uploadPic("src\\test\\resources\\fileForUpload.jpg")
            .setAddress(address)
            .selectState("Uttar Pradesh")
            .selectCity("Merrut")
            .submit();
//Assert
        registrationPage.modalTitle.shouldHave(text("Thanks for submitting the form"));
        registrationPage.modalTable.shouldHave(text(firstName + " " +lastName))
            .shouldHave(text(email))
            .shouldHave(text("Male"))
            .shouldHave(text(userNumber))
            .shouldHave(text("22 February,1991"))
            .shouldHave(text("Maths"))
            .shouldHave(text("Sports"))
            .shouldHave(text("fileForUpload.jpg"))
            .shouldHave(text(address))
            .shouldHave(text("Uttar Pradesh Merrut"));
    }

}
