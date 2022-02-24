package com.test.java.scrux.steps;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class TearDown {

    @Autowired
    private WebDriver driver;

    @After
    public void tearDown() {
        driver.quit();
    }
    
}
