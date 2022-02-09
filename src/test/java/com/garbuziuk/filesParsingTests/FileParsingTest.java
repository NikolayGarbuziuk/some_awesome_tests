package com.garbuziuk.filesParsingTests;

import com.codeborne.pdftest.PDF;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class FileParsingTest {

    private ClassLoader cl = getClass().getClassLoader();

    @Test
    void parsePdfTest() throws IOException {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File pdfDownload = $(byText("PDF download")).download();
        PDF parsed = new PDF(pdfDownload);
        assertThat(parsed.author).contains("Marc Philip");
    }

    @Test
    void parseCsvFile() throws IOException, CsvException {
        try (InputStream stream = cl.getResourceAsStream("files/csvFileExample.csv")) {
            CSVReader reader = new CSVReader(new InputStreamReader(stream));
            List<String[]> list = reader.readAll();
            assertThat(list)
                    .hasSize(3)
                    .contains(
                            new String[] {"Author", "Book"},
                            new String[] {"Alexander Block", "Apteka"},
                            new String[] {"Esenin", "Bereza"}
                    );
        }
    }

    @Test
    void zipTest() throws IOException {
        try (InputStream stream = cl.getResourceAsStream("files/zipExample.zip");
            ZipInputStream zis = new ZipInputStream(stream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                assertThat(zipEntry.getName()).isEqualTo("fileInZip.bmp");
            }
        }

    }
}
