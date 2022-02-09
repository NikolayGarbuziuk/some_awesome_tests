package com.garbuziuk.selenideTestStyles;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AnnotationStepsIssueNameTest extends BaseTest{

    WebSteps steps = new WebSteps();

    @Test
    public void issueNameInRepository(){
        steps.openMainPage();
        steps.search(REPOSITORY);
        steps.orenRepository(REPOSITORY);
        steps.goToIssues();
        steps.checkIssue(ISSUE_NAME);

    }

}
