package com.qaprosoft.carina.demo.ebay;

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

        home.signInButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authorization();
        Assert.assertEquals(home.getHelloText(), "Hi Artyom!", "User not authorised");

    }

    @Test()
    public void testSignOut() {

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");
        home.changeLanguageButton();
        home.changeLanguageEn();
        home.signInButton();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authorization();
        Assert.assertEquals(home.getHelloText(), "Hi Artyom!", "User not authorised");
        home.helloButton();
        home.signOutButton();
        Assert.assertEquals(home.getHelloText2(), "Hi Artyom (Sign in)", "User not authorised");


    }

    @Test()
    public void testChangeLanguage() {

        HomePage home = new HomePage(getDriver());
        home.open();

        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        home.changeLanguageButton();
        home.changeLanguageEn();

        Assert.assertEquals(home.getHelloText2(), "Hi! Sign in or register", "User not change language");
    }

    @Test()
    public void testSearchGoods() {
        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");
        home.changeLanguageButton();
        home.changeLanguageEn();
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
        home.changeLanguageButton();
        home.changeLanguageEn();
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

        home.signInButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authorization();
        Assert.assertEquals(home.getHelloText(), "Hi Artyom!", "User not authorised");

        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone";
        List<GoodsItem> goods = searchPage.searchGoodsWithSort(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");

        int randomNum = (int) (Math.random() * goods.size());
        CartPage cartPage = new CartPage(getDriver());
        int prev1 = cartPage.getTextCart();
        GoodsItem item = searchPage.getGoods().get(randomNum);
        item.getTitleLink();
        pause(5);
        //  searchPage.getSelectColorBtn();
        //  searchPage.getSelectStorageBtn();
        GoodsItem goodsItem = new GoodsItem(getDriver());
        goodsItem.cartBtn();
        int prev2 = cartPage.getTextCart();
        Assert.assertTrue(prev2 > prev1, "The item has not been added to the cart");
    }

    @Test
    public void testDealsPage() {
        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");
        home.changeLanguageButton();
        home.changeLanguageEn();
        DealsPage dealsPage = home.openDailyDealsPage();
        Assert.assertTrue(dealsPage.isPageOpened(), "Home page is not opened!");
    }
    @Test
    public void testDeleteFromCart() {

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        home.signInButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authorization();

        Assert.assertEquals(home.getHelloText(), "Hi Artyom!", "User not authorised");
        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone";
        List<GoodsItem> goods = searchPage.searchGoodsWithSort(searchQ);

        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");
        int randomNum = (int) (Math.random() * goods.size());
        CartPage cartPage = new CartPage(getDriver());
        int prev1 = cartPage.getTextCart();
        GoodsItem item = searchPage.getGoods().get(randomNum);
        item.getTitleLink();
        pause(5);
        //  searchPage.getSelectColorBtn();
        //  searchPage.getSelectStorageBtn();
        GoodsItem goodsItem = new GoodsItem(getDriver());
        goodsItem.cartBtn();
        int prev2 = cartPage.getTextCart();
        Assert.assertTrue(prev2 > prev1, "The item has not been added to the cart");
        cartPage.RemoveButton();
        pause(3);
        int prev3 = cartPage.getTextCart();
        Assert.assertTrue(prev3 < prev2, "The item has not been added to the cart");
    }

    @Test
    public void testAddToWatchList() {

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        home.signInButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authorization();
        Assert.assertEquals(home.getHelloText(), "Hi Artyom!", "User not authorised");

        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone";
        List<GoodsItem> goods = searchPage.searchGoodsWithSort(searchQ);

        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");
        int randomNum = (int) (Math.random() * goods.size());
        GoodsItem item = searchPage.getGoods().get(randomNum);
        item.getTitleLink();
        pause(5);
        GoodsItem goodsItem = new GoodsItem(getDriver());
        goodsItem.addWatchListBtn();
               pause(3);
        PageHeaderMenu pageHeaderMenu = new PageHeaderMenu(getDriver());
        WatchListPage watchListPage = pageHeaderMenu.openWatchListLinkPage();
        List<GoodsItem> goodsListFromWatchList = watchListPage.getGoodsFromWatchList();
        Assert.assertFalse(CollectionUtils.isEmpty(goodsListFromWatchList), "The item has not been added to the cart");
    }

}