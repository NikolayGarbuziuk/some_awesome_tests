package com.garbuziuk.selenideGithubTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepoTest {
    @Test
    void shouldFindSelenideRepositoryInGithub() {
        open("https://github.com/");    // открыть страницу github.com
        $("[data-test-selector=\"nav-search-input\"]").setValue("Selenide").pressEnter();   // ввести в поле поиска Selenide и нажать Enter
        $$("ul.repo-list li").first().$("a").click();  // нажать на link первого результата поиска
        $("h1").shouldHave(text("selenide / selenide"));  // в заголовке есть selenide/selenide


    }
}
