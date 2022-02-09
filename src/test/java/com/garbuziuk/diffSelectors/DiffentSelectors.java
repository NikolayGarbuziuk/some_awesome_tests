package com.garbuziuk.diffSelectors;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DiffentSelectors {
    @Test
    void SearchSelectors(){
        open("https://github.com/selenide/selenide");
        //Вариант 1
        $("div h1").should(exist);
    }
    @Test
    void SearchAnySelectors(){
        open("https://github.com/selenide/selenide");
        //Вариант 2
        $("h1").$("div").shouldNot(exist);
    }
}
