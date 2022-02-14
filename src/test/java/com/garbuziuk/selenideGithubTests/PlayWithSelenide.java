package com.garbuziuk.selenideGithubTests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class PlayWithSelenide {

    @Test
    void setCookie() {

        //all tests
        Cookie cookie = new Cookie("consent_cookies", "true");
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);

        //cookies test
        WebDriverRunner.getWebDriver().manage().getCookieNamed("consent_cookies");

    }
}
