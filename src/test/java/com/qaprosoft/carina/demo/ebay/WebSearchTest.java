package com.qaprosoft.carina.demo.ebay;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.ebay.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WebSearchTest implements IAbstractTest {

    @Test
    public void testAddToCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        homePage.signInButton();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authorization();
        Assert.assertEquals(homePage.getHelloText(), "Hi Artyom!", "User not authorised");



        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone";
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
        getDriver().close();
    }
    @Test
    public void testSortMethod() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

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
        getDriver().close();
    }
    @Test
    public void testMessagesSearch() {

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.signInButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.authorization();
        Assert.assertEquals(homePage.getHelloText(), "Hi Artyom!", "User not authorised");

        SummaryPage summaryPage = homePage.headerMenu().openMessageLinkPage();
        List<MessageItems> message = summaryPage.findMessage();
        Assert.assertFalse(CollectionUtils.isEmpty(message), "Message Box is empty");
        for (MessageItems m : message) {
            System.out.println(m.readTitleOfMessage());
        }
        getDriver().close();

    }

    @Test()
    public void testSearchGoods() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SearchPage searchPage = new SearchPage(getDriver());
        final String searchQ = "iphone";
        List<GoodsItem> goods = searchPage.searchGoods(searchQ);
        Assert.assertFalse(CollectionUtils.isEmpty(goods), "No goods found");
        for (GoodsItem ni : goods) {
            Assert.assertTrue(StringUtils.containsIgnoreCase(ni.readTitle(), searchQ), "Found invalid goods");
        }
        getDriver().close();
    }
}
