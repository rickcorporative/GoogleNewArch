package com.demo.pages;

import com.codeborne.selenide.SelenideElement;
import com.demo.core.base.PageTools;
import com.demo.utils.SelenideTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchPage extends PageTools {
    private static GoogleSearchPage instance;
    private final By searchBox = By.xpath("//textarea[name='q']");
    private final By searchButton = By.xpath("//input[name='btnK']");
    private final By searchResultsTitles = By.cssSelector("div#search h3");

    public static GoogleSearchPage getInstance(){
        if(instance == null){
            instance = new GoogleSearchPage();
        }
        return instance;
    }

    @Step("Opening Google page...")
    public void openGoogle() {
        SelenideTools.openUrl("https://www.google.com");
    }

    @Step("Entering query...")
    public void enterSearchQuery(String query) {
        getSelenideElement(searchBox).setValue(query);
    }

    @Step("Clicking the search button...")
    public void clickSearch() { getSelenideElement(searchButton).click(); }

    @Step("Getting data from the search")
    public List<SelenideElement> getSearchResultsTitles() {
        return getSelenideElements(searchResultsTitles);
    }

    @Step("Checking if the results is visible")
    public void checkIfVisible(){
        shouldBe(visible,By.id("#search"));
    }
}
