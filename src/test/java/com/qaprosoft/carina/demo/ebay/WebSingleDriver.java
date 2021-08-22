package com.qaprosoft.carina.demo.ebay;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class WebSingleDriver implements IAbstractTest {
    HomePage homePage = null;

    @BeforeSuite
    public void startDriver() {
        homePage = new HomePage(getDriver());
    }

    @Test
    public void testOpenPage() {
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        getDriver().close();
    }

}
