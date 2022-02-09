package com.garbuziuk.allureFeatureTest;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentsTests {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int NUMBER = 68;

    @Test
    void testIssueSearchWithLambdaAndAttachmentStepsTest() {
        step("Open main page", () -> open("https://github.com"));
        step("Search repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Go to repository " + REPOSITORY , () -> $(By.linkText(REPOSITORY)).click());
        step("Go to repository " + REPOSITORY + " Issues", () -> {
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
            $(By.partialLinkText("Issues")).click();
        });
        step("Check Issue " + NUMBER + " is visible", () -> {
            $(withText("#" + NUMBER)).shouldBe(visible);
        });

    }
}
