package com.garbuziuk.allureFeatureTest;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LabelsTests {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static int NUMBER = 68;

    @Test
    @Feature("Issue")
    @Story("Create issue for authorized user")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("nikolay.garbuziuk")
    @Link(value = "GitHub", url= "https://github.com")
    void firstTest() {
        Assertions.assertTrue(8>1);
    }
    @Test
    @Feature("Issue")
    @Story("Create issue for authorized user")
    @Story("Story2")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("nikolay.garbuziuk")
    @Link(value = "GitHub", url= "https://github.com")
    void secondTest() {
        Assertions.assertTrue(8<1);
    }
}
