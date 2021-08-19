package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchListPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='m-item']")
    private List<GoodsItem> goodsFromWatchList;

    public List<GoodsItem> getGoodsFromWatchList() {
        return goodsFromWatchList;
    }

    @FindBy(xpath = "//*[@id='vi-atl-lnk]/a")
    private ExtendedWebElement watchListBtn;

    public void AddWatchListBtn(){
        watchListBtn.click();
    }

    public WatchListPage(WebDriver driver) {
        super(driver);
        setPageURL("/mye/myebay/watchlist");
    }
}
