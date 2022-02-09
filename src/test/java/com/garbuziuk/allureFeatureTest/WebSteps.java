package com.garbuziuk.allureFeatureTest;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {
    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }
    @Step("Search repository {repository}")
    public  void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }
    @Step("Go to repository {repository}")
    public void openRepositoryPage(String repository) {
        $(By.linkText(repository)).click();
    }
    @Step("Go to repository {repository} Issues")
    public void openIssuesTab() {
        $(By.partialLinkText("Issues")).click();
    }
    @Step("Check Issue {number} is visible")
    public void shouldBeIssueWithNumber(int number) {
        $(withText("#" + number)).shouldBe(visible);
    }
}
