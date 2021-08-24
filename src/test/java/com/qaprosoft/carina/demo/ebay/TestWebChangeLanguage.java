package com.qaprosoft.carina.demo.ebay;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.ebay.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWebChangeLanguage implements IAbstractTest {

    @Test()
    public void testChangeLanguage() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.changeLanguageToEn();

        Assert.assertEquals(homePage.getText(), "Hi! Sign in or register", "User not change language");

    }
}
