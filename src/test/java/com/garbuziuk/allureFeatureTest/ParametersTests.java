package com.garbuziuk.allureFeatureTest;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

public class ParametersTests {

    @Test
    @Feature("Parameters")
    void paramTest() {
        Allure.parameter("Region","Kiev");
        Allure.parameter("Oblast","Kievskaya");

    }
}
