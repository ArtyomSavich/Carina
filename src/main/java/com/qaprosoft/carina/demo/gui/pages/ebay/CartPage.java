package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {




    @FindBy(xpath = "")
    private ExtendedWebElement removeButton;


    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://cart.payments.ebay.com/");
    }



    public void clickOnRemoveButtonLink() {
        removeButton.click();
    }

}
