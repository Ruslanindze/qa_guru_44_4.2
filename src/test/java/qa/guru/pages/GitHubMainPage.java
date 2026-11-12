package qa.guru.pages;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

@Getter
public class GitHubMainPage {

    private final SelenideElement searchField = $("div[class^='searchSlot'] button");
    private final SelenideElement searchInputField = $("input[aria-label*='Search']");
    private final SelenideElement issuesTab = $("[data-tab-item='issues']");

    public GitHubMainPage openPage() {
        open("https://github.com");
        return this;
    }

    public GitHubMainPage clickOnSearchField() {
        searchField.click();
        return this;
    }

    public GitHubMainPage filledSearchInputField(String value) {
        searchInputField.setValue(value);
        return this;
    }

    public GitHubMainPage submitSearchInputField() {
        searchInputField.pressEnter();
        return this;
    }

    public GitHubMainPage openRepoFromResults(String repository) {
        $(linkText(repository)).click();
        return this;
    }

    public GitHubMainPage openIssuesTab() {
        issuesTab.click();
        return this;
    }

    public GitHubMainPage checkIssueTitle(String number, String title) {
        $(withText(number)).closest("li").shouldHave(text(title));
        return this;
    }
}
