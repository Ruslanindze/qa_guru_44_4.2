package qa.guru.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.guru.infra.BaseTest;
import qa.guru.pages.GitHubMainPage;

import static qa.guru.infra.TestData.REPOSITORY;

public class LambdaStepsTest extends BaseTest {
    private final GitHubMainPage mainPage = new GitHubMainPage();

    @Test
    @Feature("Issue в репозитории GitHub")
    @Story("Поиск Issue")
    @Owner("anti-sdet")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск Issue репозитория - lambda steps")
    void shouldFindIssueByName() {

        Allure.step("Открываем главную страницу GitHub", () -> mainPage.openPage());

        Allure.step("Поиск репозитория " + REPOSITORY, () -> {
            mainPage
                    .clickOnSearchField()
                    .filledSearchInputField(REPOSITORY)
                    .submitSearchInputField();
        });

        Allure.step("Открываем репозиторий через ссылку", () -> mainPage.openRepoFromResults(REPOSITORY));

        Allure.step("Поиск Issue и проверка заголовка", () -> {
            mainPage
                    .openIssuesTab()
                    .checkIssueTitle("#2", "Allure с step-лямбдами");
        });
    }
}
