package com.garbuziuk.filesParsingTests;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFilesTest {
    private ClassLoader cl = getClass().getClassLoader();

    @Test
    void downloadTest() throws IOException {
        open("https://github.com/junit-team/junit5/blob/main/LICENSE.md");
        File downloadedFile = $("#raw-url").download();
        try (InputStream is = new FileInputStream(downloadedFile)) {
            assertThat(new String(is.readAllBytes(), StandardCharsets.UTF_8))
                    .contains("Eclipse Public License - v 2.0");

        }
    }

    @Test
    void uploadFile() {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']").uploadFromClasspath("files/fileForUpload.png");
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(text("fileForUpload.png"));
    }
}
