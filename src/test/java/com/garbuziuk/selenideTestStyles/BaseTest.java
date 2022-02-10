package com.garbuziuk.selenideTestStyles;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {

    protected final static String REPOSITORY = "eroshenkoam/allure-example";
    protected final static String ISSUE_NAME = "Listeners NamedBy";

    @BeforeAll
    public static void beforeAll() {

        //System.setProperty("selenoid.url", "http://localhost:4444/wd/hub");
        Configuration.remote = "http://localhost:4444/wd/hub";
        browser = "chrome";
        browserVersion = "97.0";
        startMaximized=true;
        baseUrl="https://github.com";
    }
}
