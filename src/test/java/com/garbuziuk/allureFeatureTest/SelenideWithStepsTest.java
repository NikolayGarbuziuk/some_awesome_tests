package com.garbuziuk.allureFeatureTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideWithStepsTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int NUMBER = 68;

    @Test
    void testIssueSearchWithLambdaStepsTest() {
        step("Open main page", () -> open("https://github.com"));
        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Go to repository " + REPOSITORY , () -> $(By.linkText(REPOSITORY)).click());
        step("Go to repository " + REPOSITORY + " Issues", () -> $(By.partialLinkText("Issues")).click());
        step("Check Issue " + NUMBER + " is visible", () -> {
            $(withText("#" + NUMBER)).shouldBe(visible);
        });

    }

  /*  @Test
    void annotatedStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldBeIssueWithNumber(NUMBER);
    }*/
}
