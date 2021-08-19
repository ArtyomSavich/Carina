package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.velocity.runtime.directive.Parse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {
    //h1[@class= 'main-title']

    @FindBy(xpath = "//a[@href='https://cart.payments.ebay.com/sc/view']")
    private ExtendedWebElement textCart;

    public int getTextCart() {
        int total = 0;
        try {
            total = Integer.parseInt(textCart.getText().equals("") ? "0": textCart.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }return total;
    }
    @FindBy(xpath = "//span[contains(text(),'Remove')]/ancestor::button")
    private ExtendedWebElement removeButton;

    public void RemoveButton() {
        removeButton.click();
    }

    //button[@class='faux-link']//span[contains(text(),'Remove')]



    public CartPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://cart.payments.ebay.com/");
    }


}
