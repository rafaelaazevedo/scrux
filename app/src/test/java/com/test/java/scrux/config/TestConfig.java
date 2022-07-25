package com.test.java.scrux.config;

import io.cucumber.spring.ScenarioScope;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.test.java.scrux" })
public class TestConfig {

    @Value("${remote.driver}")
    private boolean useRemoteDriver;

    @Value("${user.remote.driver.url}")
    private String remoteUrl;

    @Value("${user.remote.driver.capabilities}")
    private Capabilities remoteCapabilities;

    @Bean
    @ScenarioScope
    public WebDriver webDriver() throws MalformedURLException {
        WebDriver driver = null;

        if (useRemoteDriver) {
            driver = new RemoteWebDriver(new URL(remoteUrl), remoteCapabilities);
        } else {
            URL resource = getClass().getResource("/drivers/chromedriver");
            String path = resource.getPath();

            System.setProperty("webdriver.chrome.driver", path);
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
