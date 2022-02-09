package com.garbuziuk.selenideTestStyles;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open main page: [{baseUrl}]")
    public void openMainPage(){ open("/"); }

    @Step("Search: [{REPOSITORY}]")
    public void search(String repository){ $(byName("q")).setValue(repository).pressEnter(); }

    @Step("Open repository: [{REPOSITORY}]")
    public void orenRepository(String repository){$(byLinkText(repository)).click(); }

    @Step("Go to Issues")
    public void goToIssues() { $(".js-repo-nav").find(byText("Issues")).click(); }

    @Step("Check Issue by name: [{ISSUE_NAME}]")
    public void checkIssue(String issueName) { $(withText(issueName)).should(exist); }

}
