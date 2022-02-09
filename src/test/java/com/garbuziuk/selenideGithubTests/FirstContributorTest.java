package com.garbuziuk.selenideGithubTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstContributorTest {
    @Test
    void firstContributorShouldDBeAndreySolntsev() {
        //open Selenide Repository page
        open("https://github.com/selenide/selenide");
        //move cursor to first Contributors element
        $(".Layout-sidebar").$(byText("Contributors")).closest("div")
                .$$("ul li").first().hover();
        //check: appeared popup should have text "Andrei Solntsev"
        $$(".Popover-message").find(visible).shouldHave(text("Andrei Solntsev"));

    }
}
