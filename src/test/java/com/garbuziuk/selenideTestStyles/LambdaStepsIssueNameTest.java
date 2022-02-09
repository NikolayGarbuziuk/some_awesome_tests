package com.garbuziuk.selenideTestStyles;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaStepsIssueNameTest extends BaseTest{

    @Test
    public void issueNameTest(){
        step("Open main page: " + baseUrl, () -> { open("/"); });
        step("Search: " + REPOSITORY, () -> { $(byName("q")).setValue(REPOSITORY).pressEnter(); });
        step("Open repository: " + REPOSITORY, () -> { $(byLinkText(REPOSITORY)).click(); });
        step("Go to Issues: ", () -> { $(".js-repo-nav").find(byText("Issues")).click(); });
        step("Check Issue by name: " + ISSUE_NAME, () -> { $(withText(ISSUE_NAME)).should(exist); });
    }

}
