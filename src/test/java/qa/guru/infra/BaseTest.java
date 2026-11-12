package qa.guru.infra;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;

import java.awt.*;
import java.util.TimeZone;

public abstract class BaseTest {
    @BeforeAll
    static void setup() {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));

        // Для CI/CD требуется headless режим
        boolean isCi = "true".equals(System.getenv("GITHUB_ACTIONS")) || System.getProperty("ci") != null;
        Configuration.headless = isCi;

        if (!isCi) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Configuration.browserSize = screenSize.width + "x" + screenSize.height;
        } else {
            Configuration.browserSize = "1920x1080";
        }

        Configuration.pageLoadStrategy = "eager";

        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
