package com.garbuziuk.diffSelectors;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @Test
    void DragAndDropTest(){
        // Вариант 1
        // Открыть страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Перенести обьект А на место обьекта Б
        actions().moveToElement($("#column-a")).clickAndHold().
                moveByOffset(150, 0).release().perform();
        // Проверить, что обьект Б встал на место А и обьект А встал на место Б
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
    void DragAndDropTest2(){
        // Вариант 2
        // Открыть страницу
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Перенести обьект А на место обьекта Б
        actions().moveToElement($("#column-a")).clickAndHold().
                moveToElement($("#column-b")).release().perform();
        // Проверить, что обьект Б встал на место А и обьект А встал на место Б
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void DragAndDropTest3() {

        // Открыть страницу и проверить заголовок
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#content").shouldHave(text("Drag and Drop"));

        // Проверить, что прямоугольники действительно находятся на своих местах
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));

        // Перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo($("#column-b"));

        // Проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
