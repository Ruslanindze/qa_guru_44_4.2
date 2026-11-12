package qa.guru.tests;

import org.junit.jupiter.api.Test;
import qa.guru.infra.BaseTest;
import qa.guru.pages.GitHubMainPage;

import static qa.guru.infra.TestData.REPOSITORY;

public class CleanSelenideTest extends BaseTest {
    private final GitHubMainPage mainPage = new GitHubMainPage();

    @Test
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
