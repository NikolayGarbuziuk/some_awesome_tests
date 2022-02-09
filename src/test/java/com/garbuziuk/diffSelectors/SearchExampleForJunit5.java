package com.garbuziuk.diffSelectors;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class SearchExampleForJunit5 {
    @Test
    void findExample(){
        //Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //Перейдите в раздел Wiki проекта
        $(byText("Wiki")).click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("[id=wiki-body]").shouldHave(text("Soft assertions"));
        //Открыть страницу "Soft assertions"
        $(byText("Soft assertions")).click();
        //Проверьте что внутри есть пример кода для JUnit5
        $("[id=wiki-body]").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
