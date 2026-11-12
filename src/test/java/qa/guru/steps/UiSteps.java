package qa.guru.steps;

import io.qameta.allure.Step;
import qa.guru.pages.GitHubMainPage;

import static qa.guru.infra.TestData.REPOSITORY;

public class UiSteps {
    private final GitHubMainPage mainPage = new GitHubMainPage();

    @Step("Открываем главную страницу GitHub")
    public GitHubMainPage openMainPage() {
        return mainPage.openPage();
    }

    @Step("Поиск репозитория " + REPOSITORY)
    public GitHubMainPage searchRepository() {
        return mainPage
                .clickOnSearchField()
                .filledSearchInputField(REPOSITORY)
                .submitSearchInputField();
    }

    @Step("Открываем репозиторий через ссылку")
    public GitHubMainPage openRepoThroughLink() {
        return mainPage.openRepoFromResults(REPOSITORY);
    }

    @Step("Поиск Issue и проверка заголовка")
    public GitHubMainPage searchIssueAndCheckTittle(String number, String title) {
        return mainPage
                .openIssuesTab()
                .checkIssueTitle(number, title);
    }
}
