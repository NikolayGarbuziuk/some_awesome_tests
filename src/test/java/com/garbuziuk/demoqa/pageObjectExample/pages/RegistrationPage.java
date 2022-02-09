package com.garbuziuk.demoqa.pageObjectExample.pages;


import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    public SelenideElement modalTitle = $("#example-modal-sizes-title-lg");
    public SelenideElement modalTable = $(".table");

    public RegistrationPage openPage(){ open("/automation-practice-form"); return this; }

    public RegistrationPage setFirstName(String firstName){ $("#firstName").setValue(firstName); return this; }

    public RegistrationPage setLastName(String lastName){ $("#lastName").setValue(lastName); return this; }

    public RegistrationPage setEmail(String email){ $("#userEmail").setValue(email); return this; }

    public RegistrationPage selectGender(String gender){$(byText(gender)).click(); return this; } // Options: "Male" "Female" "Other"

    public RegistrationPage setMobileNumber(String number){$("#userNumber").setValue(number); return this;}

    public RegistrationPage setDateOfBirht(String year, String month, int day) { //e.g. 1991, "February", 22
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }
    public RegistrationPage setSubject(String subject){ $("#subjectsInput").setValue(subject).pressEnter(); // e.g. "Maths"
    return  this; }

    public RegistrationPage setHobby(String hobby){ $(byText(hobby)).click(); return  this; } // e.g.

    public RegistrationPage uploadPic(String filePath){
        $("#uploadPicture").uploadFile(new File(filePath)); return this; }

    public RegistrationPage setAddress(String address){ $("#currentAddress").setValue(address); return this;}

    public RegistrationPage selectState(String state){$("#react-select-3-input").setValue(state).pressEnter(); // e.g. "Uttar Pradesh"
    return this;}

    public RegistrationPage selectCity(String city){$("#react-select-4-input").setValue(city).pressEnter(); //e.g. "Merrut" depends on selected State
    return this;}

    public RegistrationPage submit(){ $("#submit").click(); return this;}

}
