package com.qaprosoft.carina.demo.mobile.gui.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

    @DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CalculatorPageBase.class)
    public class CalculatorPage extends CalculatorPageBase {

        public CalculatorPage(WebDriver driver) {
            super(driver);
        }

    }

