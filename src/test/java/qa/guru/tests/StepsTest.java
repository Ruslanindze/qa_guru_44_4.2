package qa.guru.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qa.guru.steps.UiSteps;

public class StepsTest {
    UiSteps uiSteps = new UiSteps();

    @Test
    @Feature("Issue в репозитории GitHub")
    @Story("Поиск Issue")
    @Owner("anti-sdet")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Поиск Issue репозитория - ui steps")
    void shouldFindIssueByName() {

        uiSteps.openMainPage();
        uiSteps.searchRepository();
        uiSteps.openRepoThroughLink();

        uiSteps.searchIssueAndCheckTittle("#1", "Создание тестов на поиск Issue");
    }
}
