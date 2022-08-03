package com.test.java.scrux.pages;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.test.java.scrux.BasePage;

@Component
@ScenarioScope
public class HomePage extends BasePage {

    @FindBy(id = "search_query_top")
    private WebElement searchBox;

    @FindBy(id = "results")
    private WebElement results;

    public void searchFor(String searchTerm) {
        searchBox.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        searchBox.submit();
    }

    public void waitForPageToLoad() {
        waitForElementToBePresent(results);
    }

}
