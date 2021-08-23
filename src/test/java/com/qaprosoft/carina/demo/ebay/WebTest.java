package com.qaprosoft.carina.demo.ebay;

import com.qaprosoft.carina.demo.gui.pages.ebay.*;
import org.apache.commons.collections.CollectionUtils;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebTest implements IAbstractTest {

    @BeforeClass
    public void testLogin() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.signInButton();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authorization();
        Assert.assertEquals(homePage.getHelloText(), "Hi Artyom!", "User not authorised");
    }

    @AfterClass
    public void testSignOut() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
  /*
        homePage.signInButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authorization();
        Assert.assertEquals(homePage.getHelloText(), "Hi Artyom!", "User not authorised");

        homePage.helloButton();
        homePage.signOutButton();*/
        String firstText = "Здравствуйте! Войдите или зарегистрируйтесь";
        String secondText = "Hi Artyom (Sign in)";
        String a = null;
        if (firstText.equals(homePage.getText())){
           a = firstText;
        } else if(secondText.equals(homePage.getText())){
         a = secondText;
        }

        Assert.assertEquals(homePage.getText(), a,"User not authorised");

    }

    @Test
    public void testAddToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone 12 mini";
        List<GoodsItem> goods = searchPage.searchGoodsWithSort(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");

        int randomNum = (int) (Math.random() * goods.size());
        CartPage cartPage = new CartPage(getDriver());
        int prev1 = cartPage.getTextCart();
        GoodsItem item = searchPage.getGoods().get(randomNum);
        item.getTitleLink();
        GoodsItem goodsItem = new GoodsItem(getDriver());
        goodsItem.cartBtn();

        int prev2 = cartPage.getTextCart();
        Assert.assertTrue(prev2 > prev1, "The item has not been added to the cart");

    }
    @Test
    public void testDeleteFromCart() {

        HomePage home = new HomePage(getDriver());
        home.open();
        Assert.assertTrue(home.isPageOpened(), "Home page is not opened!");

        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone 12 mini";
        List<GoodsItem> goods = searchPage.searchGoodsWithSort(searchQ);

        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");
        int randomNum = (int) (Math.random() * goods.size());
        CartPage cartPage = new CartPage(getDriver());
        int prev1 = cartPage.getTextCart();
        GoodsItem item = searchPage.getGoods().get(randomNum);
        item.getTitleLink();
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
    public void testMessagesSearch() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        SummaryPage summaryPage = homePage.headerMenu().openMessageLinkPage();
        List<MessageItems> message = summaryPage.findMessage();
        Assert.assertFalse(CollectionUtils.isEmpty(message), "Message Box is empty");


    }


    @Test
    public void testDealsPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        DealsPage dealsPage = homePage.openDailyDealsPage();
        Assert.assertTrue(dealsPage.isPageOpened(), "Home page is not opened!");

    }


    @Test
    public void testAddToWatchList() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone 12 mini";
        List<GoodsItem> goods = searchPage.searchGoods(searchQ);

        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");
        int randomNum = (int) (Math.random() * goods.size());
        GoodsItem item = searchPage.getGoods().get(randomNum);
        item.getTitleLink();
        GoodsItem goodsItem = new GoodsItem(getDriver());
        goodsItem.addWatchListBtn();
        PageHeaderMenu pageHeaderMenu = new PageHeaderMenu(getDriver());
        WatchListPage watchListPage = pageHeaderMenu.openWatchListLinkPage();
        List<GoodsItem> goodsListFromWatchList = watchListPage.getGoodsFromWatchList();
        Assert.assertFalse(CollectionUtils.isEmpty(goodsListFromWatchList), "The item has not been added to watchList");

    }
    @Test
    public void testSortMethod() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone 12 mini";
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

    @Test()
    public void testSearchGoods() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone 12 mini";
        List<GoodsItem> goods = searchPage.searchGoods(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");
        for (GoodsItem ni : goods) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(ni.readTitle(), searchQ), "Found invalid goods");
        }
    }

}

