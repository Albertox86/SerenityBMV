package com.bmv.pages;

import com.bmv.stepdefinitions.Hook;
import com.bmv.elements.EquityLocators;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public class Equity extends Hook {
    private  static final Logger logger = Logger.getLogger("");


    private final WebDriver driver;
    public Equity(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSortedBy(String letter){
        driver.findElement(EquityLocators.SORT_BY.getLocatorBy(letter)).click();

    }

    public void clickIssuer(String issuer){

        WebElement element = driver.findElement(EquityLocators.ISSUER_LINK.getLocatorBy(issuer));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open(arguments[0], '_blank');", element.getDomAttribute("href"));
    }

    public Map<String,String> retrieveTableValues(){
        List<WebElement> stockTable = driver.findElements(EquityLocators.STOCKS_ROWS.getLocatorBy());
        String[] split ={};
        Map<String, String> table = new HashMap<>();
        for(WebElement element : stockTable){
            split  =  element.getText().split("\\n");
            table.put(split[0], split[2]);        }
        return table;
    }

    public boolean validateTableSortedBy(Map<String, String> table, String letter){
        return table.keySet().stream()
                .allMatch(key->key.startsWith(String.valueOf(letter)));
    }

}
