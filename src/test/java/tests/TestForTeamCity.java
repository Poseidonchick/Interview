package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import testBase.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestForTeamCity extends TestBase {
    @Test
    public void urlOpenTest(){
        step ("Открываем страницу", ()-> { open("https://inno.tech");});
        step ("Переходим в раздел \"Карьера\"", ()->{ $(By.linkText("Карьера")).click();});
        step ("Проверяем, что на странице присутствует надпись \"Нас уже более 5000" +
                                                                    "сотрудников с опытом" +
                                                                    " работы в передовых" +
                                                                    " российских и зарубежных" +
                                                                    " компаниях\"", ()->{
                $(".header__title--_kOgO").shouldHave(text("Нас уже более 5000 " +
                                                                    "сотрудников с опытом " +
                                                                    "работы в передовых " +
                                                                    "российских и зарубежных " +
                                                                    "копаниях"));});
    }
}
