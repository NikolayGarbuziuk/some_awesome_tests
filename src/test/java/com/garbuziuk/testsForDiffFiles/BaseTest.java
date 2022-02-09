package com.garbuziuk.testsForDiffFiles;

import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.InputStream;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.startMaximized;

public class BaseTest {

    protected static final String PATH_TO_DWD = "downloads";
    protected static File downloadedFile;
    protected static InputStream fps;

    @BeforeAll
    public static void setUp() {
        baseUrl = "https://github.com/NikolayGarbuziuk/testFiles";
        startMaximized = true;
    }

}
