package testBase;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    static void setUp(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = "1024x768";
        Configuration.headless = true;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        Configuration.browser = "chrome";
//        System.setProperty("web.chrome.driver", "src/test/resources/chromedriver");
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "94.0");
    }

    @AfterEach
    public void tearDown(){
        Attach.screenShotAs("After test screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        step ("Закрываем браузер", ()->{
            closeWebDriver();
        });
    }
}
