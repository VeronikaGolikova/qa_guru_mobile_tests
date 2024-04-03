package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;

@Feature("Mobile tests")
@Story("Wikipedia app tests")
@Owner("golikova.veronika")
public class SearchTests extends TestBase {

    @Test
    @DisplayName("Отображение списка статей по названию \"Appium\"")
    void successfulSearchAppiumTest() {
        step("Ввести в поле \"Appium\"", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Проверить, что список не пустой", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Отображение ошибки \"An error occurred\" при открытии статьи")
    void successfulSearchSeleniteTest() {
        step("Ввести в поле \"Selenite\"", () -> {
            $(accessibilityId("Search Wikipedia")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Selenite");
        });
        step("Кликнуть по первому значению в результате поиска", () -> {
            $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click();
        });
        step("Проверить текст ошибки", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_text"))
                        .shouldHave(Condition.text("An error occurred")));
    }
}