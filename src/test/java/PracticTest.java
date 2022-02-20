import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class PracticTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void selenideSearch (){
        open("https://github.com/");
        //Переходим в wiki проекта Selenide
        $("[data-test-selector=nav-search-input]").setValue("Selenide").pressEnter();
        $x("//div[@class='f4 text-normal']//a[@href='/selenide/selenide']").click();
        $("#wiki-tab").click();
        //Проверка наличия Soft assertions на странице
        $("#wiki-body ul").shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        //Проверяем,что есть код для JUnit5
        $("#wiki-body").shouldHave(text("JUnit5 extension"))
                .shouldHave(text("Using JUnit5 extend test class:"));



    }

}
