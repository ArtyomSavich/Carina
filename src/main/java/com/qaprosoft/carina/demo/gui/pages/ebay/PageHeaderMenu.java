package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PageHeaderMenu extends AbstractUIObject {

    @FindBy(xpath = "//div[@class='top-section']//h1")
    private ExtendedWebElement cartCount;

    public int getCartCount() {
        return Integer.parseInt(cartCount.getText());
    }

    public PageHeaderMenu(WebDriver driver) {
        super(driver);
    }


}

