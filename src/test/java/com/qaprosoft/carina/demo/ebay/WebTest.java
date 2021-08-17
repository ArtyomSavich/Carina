package com.qaprosoft.carina.demo.ebay;

import com.qaprosoft.carina.demo.gui.pages.NewsPage;
import com.qaprosoft.carina.demo.gui.pages.ebay.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.collections.CollectionUtils;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebTest implements IAbstractTest {

    @Test()
    public void testLogin() {

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        home.getSignInButton().click();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.getEmailOrUserField().type("artyom_savich@mail.ru");
        loginPage.getContinueButton().click();
        loginPage.getPassField().type("ViPEr9zVf'7");
        loginPage.getSignButton().click();
        Assert.assertEquals(home.getHelloText(), "Hi Artyom!", "User not authorised");

    }

    @Test()
    public void testSignOut() {

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");
        home.getChangeLanguageButton().hover();
        home.getChangeLanguageEn().click();
        home.getSignInButton().click();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.getEmailOrUserField().type("artyom_savich@mail.ru");
        loginPage.getContinueButton().click();
        loginPage.getPassField().type("ViPEr9zVf'7");
        loginPage.getSignButton().click();
        Assert.assertEquals(home.getHelloText(), "Hi Artyom!", "User not authorised");
        home.getHelloButton().click();
        home.getSignOutButton().click();
        Assert.assertEquals(home.getHelloText2(), "Hi Artyom (Sign in)", "User not authorised");


    }

    @Test()
    public void testChangeLanguage() {

        HomePage home = new HomePage(getDriver());
        home.open();

        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        home.getChangeLanguageButton().hover();
        home.getChangeLanguageEn().click();

        Assert.assertEquals(home.getHelloText2(), "Hi! Sign in or register", "User not change language");
    }

    @Test()
    public void testSearchGoods() {
        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");
        home.getChangeLanguageButton().hover();
        home.getChangeLanguageEn().click();
        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone";
        List<GoodsItem> goods = searchPage.searchGoods(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");
        for (GoodsItem ni : goods) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(ni.readTitle(), searchQ), "Found invalid goods");
        }

    }

    @Test
    public void testSortMethod() {
        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");
        home.getChangeLanguageButton().hover();
        home.getChangeLanguageEn().click();
        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone";
        List<GoodsItem> goods = searchPage.searchGoodsWithSort(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");
        List<Double> priceList = new ArrayList<>();
        List<Double> priceListClone = new ArrayList<>();
        for (GoodsItem item : goods) {
            priceList.add(item.getGoodsPrice());
            priceListClone.add(item.getGoodsPrice());
        }
        Collections.sort(priceList);
        Assert.assertEquals(priceListClone, priceList, "Sorted incorrectly!");

    }

    @Test
    public void testAddToCart() {
        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");
        home.getChangeLanguageButton().hover();
        home.getChangeLanguageEn().click();
        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone";
        List<GoodsItem> goods = searchPage.searchGoodsWithSort(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");
        int randomNum = (int) (Math.random() * goods.size());
        GoodsItem item = searchPage.getGoods().get(randomNum);
        item.getTitleLink().click();
        //  searchPage.getSelectColorBtn();
        //  searchPage.getSelectStorageBtn();
        GoodsItem goodsItem = new GoodsItem(getDriver());
        goodsItem.getCartBtnClone().click();
        CartPage cartPage = new CartPage(getDriver());
        Assert.assertEquals(cartPage.getTextCart(), "Shopping cart (1 item)", "Error");
    }

    @Test
    public void testDealsPage() {
        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");
        home.getChangeLanguageButton().hover();
        home.getChangeLanguageEn().click();
        DealsPage dealsPage = home.getOpenDailyDeals();
        Assert.assertTrue(dealsPage.isPageOpened(), "Home page is not opened!");
    }
}