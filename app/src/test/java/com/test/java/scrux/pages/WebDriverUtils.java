package com.test.java.scrux.pages;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ScenarioScope
public class WebDriverUtils {

    private static final int WAIT_IN_SECONDS = 10;

    @Autowired
    private WebDriver driver;

    public void waitForElementToBePresent(WebElement element) {
        new WebDriverWait(driver, WAIT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }
    
}
