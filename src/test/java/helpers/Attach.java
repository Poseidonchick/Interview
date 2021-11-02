package helpers;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.TakesScreenshot;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {
    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenShotAs(String attachName){
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource (){
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "Browser console log", type ="text/plain")
    public static String attachAsText(String attachName, String message){
        System.out.println("[Attachment] " + attachName + ": "+ message + "\n");
        return message;
    }

    public static void browserConsoleLogs(){
        attachAsText(
                "Browser console logs", String.join("\n", Selenide.getWebDriverLogs(BROWSER)));
    }
}
