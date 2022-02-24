package com.test.java.scrux;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.scrux.pages.WebDriverUtils;

@Component
@ScenarioScope
public class BasePage {
    
    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverUtils webDriverUtils;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    protected void waitForThenClick(WebElement element) {
        try {
            webDriverUtils.waitForElementToBePresent(element);
            element.click();
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, this);
            element.click();
        }
    }

    
}
