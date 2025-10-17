package com.bmv.pages;
import com.bmv.elements.EquityLocators;
import com.bmv.url.EquityURL;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class SerenityEquity extends PageObject {
    private EquityURL equityURL;

    @Step("Clicks sort by")
    public void clickSortedBy(String letter){
        find(EquityLocators.SORT_BY.getLocatorBy(letter)).then().click();
    }

    @Step("Clicks issuer")
    public void clickIssuer(String issuer){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.open(arguments[0], '_blank');", find(EquityLocators.ISSUER_LINK.getLocatorBy(issuer)).getDomAttribute("href"));
    }

    @Step("Open equity")
    public void goEquity(){
        equityURL.open();
    }

    @Step("Retrieve values on table")
    public Map<String,String>  retrieveValues(){
        List<WebElement> stockTable = getDriver().findElements(EquityLocators.STOCKS_ROWS.getLocatorBy());
        String[] split ={};
        Map<String, String> table = new HashMap<>();
        for(WebElement element : stockTable){
            split  =  element.getText().split("\\n");
            table.put(split[0], split[2]);        }
        return table;
    }

    @Step("Validate values on table")
    public boolean validateTableSortedBy(Map<String, String> table, String letter){
        return table.keySet().stream()
                .allMatch(key->key.startsWith(String.valueOf(letter)));
    }
}
