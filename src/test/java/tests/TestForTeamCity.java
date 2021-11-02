package tests;

import org.junit.jupiter.api.Test;
import testBase.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestForTeamCity extends TestBase {
    @Test
    public void urlOpenTest(){
        step ("Открываем страницу", ()->{
            open("https://yandex.ru");
        });
        step ("Вводим в поиск \"Котик\"", ()->{
            $("#text").val("Котик").pressEnter();
        });
        step ("Проверяем, что найдено более миллиона результатов", ()->{
            $(".serp-adv__found").shouldHave(text("млн результатов"));
        });
    }
}
