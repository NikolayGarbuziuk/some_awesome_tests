package com.garbuziuk.selenideTestStyles;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;

public class PureSelenideIssueNameTest extends BaseTest{

    @Test
    public void issueNameTest() {
        open("/");
        $(byName("q")).setValue(REPOSITORY).pressEnter();
        $(byLinkText(REPOSITORY)).click();
        $(".js-repo-nav").find(byText("Issues")).click();
        $(withText(ISSUE_NAME)).should(exist);
    }

}
