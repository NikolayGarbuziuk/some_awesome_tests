package com.garbuziuk.testsForDiffFiles;

import com.codeborne.pdftest.PDF;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class PDFTest extends BaseTest {

    @Test
    public void checkPDFValues() throws IOException {

        //Arrange: download file
        open("/");
        $(byText("pdfTestFile.pdf")).click();
        downloadedFile = $("#raw-url").download();

        //Act: get text from file
        PDF pdf = new PDF(downloadedFile);
        String pdfText = pdf.text;

        //Assert: check text
        assertThat(pdfText).contains("TestString");

    }

}
