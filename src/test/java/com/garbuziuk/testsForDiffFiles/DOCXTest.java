package com.garbuziuk.testsForDiffFiles;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class DOCXTest extends BaseTest {

    @Test
    public void checkDOCXValues() throws IOException {

        //Arrange: download file
        open("/");
        $(byText("docxTestFile.docx")).click();
        downloadedFile = $("#raw-url").download();

        //Act: get text from file
        fps = new FileInputStream(downloadedFile);
        XWPFDocument docx = new XWPFDocument(fps);
        String paragraphText = docx.getDocument().toString();

        //Assert: check text
        assertThat(paragraphText).contains("TestString");

    }

}
