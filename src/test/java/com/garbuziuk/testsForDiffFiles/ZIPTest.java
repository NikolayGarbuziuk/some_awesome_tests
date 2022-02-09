package com.garbuziuk.testsForDiffFiles;

import guru.qa.nikolay.garbuziuk.lesson7.Utils.Utils;
import net.lingala.zip4j.ZipFile;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class ZIPTest extends BaseTest {

    @Test
    public void checkZIPValues() throws IOException {

        //Arrange: download file
        open("/");
        $(byText("zippedTestFiles.zip")).click();
        downloadedFile = $("#raw-url").download();
        String password = "1234";

        //Act: get files from file
        new ZipFile(downloadedFile, password.toCharArray()).extractAll(PATH_TO_DWD);
        Set<String> filesFromZip = Utils.listFilesUsingJavaIO(PATH_TO_DWD);

        //Assert: check files
        assertThat(filesFromZip).contains("xlsxTestFile.xlsx");
        assertThat(filesFromZip).contains("docxTestFile.docx");
        assertThat(filesFromZip).contains("pdfTestFile.pdf");

    }

}
