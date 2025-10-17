package com.bmv.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

public class WaitHelper {
    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitPageToBeLoaded(){

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
        wait.until(w -> {
            String readyState = (String) ((ChromeDriver) driver).executeScript("return document.readyState;");
            return "complete".equals(readyState);
        });
    }

    public WebElement waitForElementToBeVisible(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        return wait.until(driver -> driver.findElement(locator));
    }

    public List<WebElement> waitForElementsToBeVisible(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        return wait.until(driver -> driver.findElements(locator));
    }
}
