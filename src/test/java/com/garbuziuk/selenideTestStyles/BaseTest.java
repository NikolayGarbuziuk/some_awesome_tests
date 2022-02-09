package com.garbuziuk.selenideTestStyles;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Configuration.*;

public class BaseTest {

    protected final static String REPOSITORY = "eroshenkoam/allure-example";
    protected final static String ISSUE_NAME = "Listeners NamedBy";

    @BeforeAll
    public static void setUp() {
        baseUrl="https://github.com";
        startMaximized=true;
    }
}
