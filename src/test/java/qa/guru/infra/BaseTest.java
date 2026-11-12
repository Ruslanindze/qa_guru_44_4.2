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

        // Узнать размер экрана и установить
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Configuration.browserSize = screenSize.width + "x" + screenSize.height;

        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
