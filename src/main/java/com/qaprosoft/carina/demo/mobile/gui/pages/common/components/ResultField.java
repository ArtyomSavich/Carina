package com.qaprosoft.carina.demo.mobile.gui.pages.common.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ResultField extends AbstractUIObject {
    @FindBy(id = "com.google.android.calculator:id/result_final")
    private ExtendedWebElement result;

    public ResultField(WebDriver driver) {
        super(driver);
    }

    public String getResultFieldDisplay(){
        return result.getText();
    }
}
