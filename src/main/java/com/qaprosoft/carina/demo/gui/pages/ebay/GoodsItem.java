package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoodsItem extends AbstractUIObject {

    @FindBy(xpath = ".//h3[@class='s-item__title']")
    public ExtendedWebElement titleLink;
    @FindBy(xpath = ".//span[@class='s-item__price']")
    private ExtendedWebElement goodsPrice;
    @FindBy(xpath = "//a[@class='gh-eb-li-a gh-rvi-menu watchlist-menu']")
    private ExtendedWebElement openWatchListMenu;
    @FindBy(xpath = "//div[@id='watchWrapperId']")
    private ExtendedWebElement watchListBtn;
    @FindBy(xpath = "//a[@id='isCartBtn_btn']")
    private ExtendedWebElement cartBtn;

    public GoodsItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public GoodsItem(WebDriver driver) {
        super(driver);
    }

    public void getTitleLink() {
        this.titleLink.click();
        pause(5);
    }

    public void cartBtn() {
        this.cartBtn.click();
        pause(3);
    }

    public String readTitle() {
        return titleLink.getElement().getText();
    }

    public Double getGoodsPrice() {
        String[] array = this.goodsPrice.getText().replaceAll
                ("\\$", "").replaceAll("to", "").split(" ");
        return Double.parseDouble(array[0]);
    }

    public void addWatchListBtn() {
        watchListBtn.click();
        openWatchListMenu.click();
        pause(3);
    }
}
