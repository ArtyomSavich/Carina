package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DealsPage extends AbstractPage {

    @FindBy(xpath = " Daily Deals")
    private ExtendedWebElement removeButton;

    public DealsPage(WebDriver driver) {
        super(driver);
        setPageURL("/globaldeals");
    }
}
