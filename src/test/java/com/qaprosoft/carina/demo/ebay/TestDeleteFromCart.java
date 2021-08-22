package com.qaprosoft.carina.demo.ebay;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.ebay.*;
import org.apache.commons.collections.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestDeleteFromCart implements IAbstractTest {
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
        GoodsItem goodsItem = new GoodsItem(getDriver());
        goodsItem.cartBtn();
        int prev2 = cartPage.getTextCart();
        Assert.assertTrue(prev2 > prev1, "The item has not been added to the cart");
        cartPage.RemoveButton();
        pause(3);
        int prev3 = cartPage.getTextCart();
        Assert.assertTrue(prev3 < prev2, "The item has not been added to the cart");
        getDriver().close();
    }
}
