package com.test.java.scrux.pages;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import com.test.java.scrux.BasePage;

@Component
@ScenarioScope
public class HomePage extends BasePage {

    @FindBy(className = "gLFyf gsfi")
    private WebElement searchBox;

    @FindBy(id = "search")
    private WebElement search;

    public void searchFor(String searchTerm) {
        searchBox.sendKeys(searchTerm);
    }

    public void clickSearchButton() {
        searchBox.submit();
    }

    public void waitForPageToLoad() {
        waitForElementToBePresent(search);
    }

}
