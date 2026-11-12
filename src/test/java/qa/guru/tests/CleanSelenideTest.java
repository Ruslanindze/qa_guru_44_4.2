package qa.guru.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.guru.infra.BaseTest;
import qa.guru.pages.GitHubMainPage;

import static qa.guru.infra.TestData.REPOSITORY;

public class CleanSelenideTest extends BaseTest {
    private final GitHubMainPage mainPage = new GitHubMainPage();

    @Test
    @Feature("Issue в репозитории GitHub")
    @Story("Поиск Issue")
    @Owner("anti-sdet")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск Issue репозитория - selenide")
    void shouldFindIssueByName() {
        mainPage
                .openPage()
                .clickOnSearchField()
                .filledSearchInputField(REPOSITORY)
                .submitSearchInputField()
                .openRepoFromResults(REPOSITORY)
                .openIssuesTab()
                .checkIssueTitle("#3", "Плохое исправить");
    }
}
