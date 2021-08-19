package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PageHeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='top-section']//h1")
    private ExtendedWebElement cartCount;
    @FindBy(xpath = "//div[@class='gh-menu gh--link__divider']//div//div//div//div//a//span[contains(text(),'View all items you are watching')]")
    private ExtendedWebElement watchListLink;

    public PageHeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public PageHeaderMenu(WebDriver driver) {
        super(driver);
    }

    public WatchListPage openWatchListLinkPage() {
        watchListLink.click();
        return new WatchListPage(driver);
    }

    public int getCartCount() {
        return Integer.parseInt(cartCount.getText());
    }

}

