package com.qaprosoft.carina.demo.mobile.gui.pages.common.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class OperatorPad extends AbstractUIObject {
    @FindBy(xpath = "//android.widget.Button[@content-desc='plus']")
    private ExtendedWebElement ButtonAdditional;

    @FindBy(xpath = "//android.widget.Button[@content-desc='equals']")
    private ExtendedWebElement ButtonEquals;


    public OperatorPad(WebDriver driver) {
        super(driver);
    }

    public void tapPlusButton(){
        ButtonAdditional.click();
    }

    public void tapEqualsButton(){
        ButtonEquals.click();
    }

}
