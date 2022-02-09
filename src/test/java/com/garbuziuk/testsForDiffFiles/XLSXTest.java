package com.garbuziuk.testsForDiffFiles;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class XLSXTest extends BaseTest {

    @Test
    public void checkXLSXValues() throws IOException {

        //Arrange: download file
        open("/");
        $(byText("xlsxTestFile.xlsx")).click();
        downloadedFile = $("#raw-url").download();

        //Act: get text from file
        fps = new FileInputStream(downloadedFile);
        XSSFWorkbook xlsx = new XSSFWorkbook(fps);
        String textInXLSX = xlsx.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();

        //Assert: check text
        assertThat(textInXLSX).isEqualTo("TestValue1_1");

    }
}
