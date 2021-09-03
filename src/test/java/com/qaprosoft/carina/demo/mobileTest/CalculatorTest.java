package com.qaprosoft.carina.demo.mobileTest;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.NumberPad;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.OperatorPad;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.components.ResultField;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest implements IAbstractTest {

    @Test()
    public void testCountPlus() {
        NumberPad numberPad = new NumberPad(getDriver());
        pause(3);
        numberPad.tapDigitOnPad("5");
        OperatorPad operatorPad = new OperatorPad(getDriver());
        operatorPad.tapPlusButton();
        numberPad.tapDigitOnPad("7");
        operatorPad.tapEqualsButton();
        ResultField resultField = new ResultField(getDriver());
        resultField.getResultFieldDisplay();
        Assert.assertEquals(resultField.getResultFieldDisplay(), "12", "Oh, shit! Here we go again!");

    }
}
