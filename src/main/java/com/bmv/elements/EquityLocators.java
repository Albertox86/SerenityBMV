package com.bmv.elements;

import org.openqa.selenium.By;

public enum EquityLocators {

    SORT_BY("//*[@id=\"alphCapital\"]/li/a[text()=\"%s\"]"),
    STOCKS_ROWS("//*[@id=\"tableMercados\"]/tbody/tr"),
    ISSUER_LINK("//*[@id=\"tableMercados\"]/tbody/tr/td[@class='sorting_1']/a[text()=\"%s\"]");

    private final String locator;

    EquityLocators(String locator){
        this.locator = locator;
    }

    public By getLocatorBy(Object ... args){
        String s = this.locator;
        if(args != null){
           s  = String.format(this.locator, args);
        }
        return By.xpath(s);
    }

    public String getStringLocator(Object ... args){
        String s = this.locator;
        if(args != null){
            s  = String.format(this.locator, args);
        }
        return s;
    }

}
