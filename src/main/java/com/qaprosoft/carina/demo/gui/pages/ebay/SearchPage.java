package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='_nkw']")
    private ExtendedWebElement searchGoodsField;
    @FindBy(xpath = "//input[@value='Search']")
    private ExtendedWebElement searchButton;
    @FindBy(xpath = "//*[@class='s-item__wrapper clearfix']")
    private List<GoodsItem> goods;
    @FindBy(xpath = "//span[@class='fake-menu-button srp-controls__control']")
    private ExtendedWebElement filterButton;
    @FindBy(xpath = "//span[@class='fake-menu-button srp-controls__control']//li[4]/a")
    private ExtendedWebElement priceFilterButton;
    @FindBy(xpath = "//button[@class='fake-menu-button__button expand-btn expand-btn--small']//*[contains(text(),'Delivery Options')]")
    private ExtendedWebElement deliveryButton;
    @FindBy(xpath = "//*[@class='fake-menu-button srp-controls__control srp-controls__control--flyout menu-1']//span//li[2]")
    private ExtendedWebElement freeDeliveryButton;
    @FindBy(xpath = "//*[@id='msku-sel-1']")
    private ExtendedWebElement colorBtn;
    @FindBy(xpath = "//*[@name='Colour']//option[2]")
    private ExtendedWebElement selectColorBtn;
    @FindBy(xpath = "//*[@name='Storage']")
    private ExtendedWebElement storageBtn;
    @FindBy(xpath = "//*[@name='Storage']//option[2]")
    private ExtendedWebElement selectStorageBtn;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<GoodsItem> getGoods() {
        return goods;
    }

    public ExtendedWebElement getColorBtn() {
        return colorBtn;
    }

    public List<GoodsItem> searchGoods(String q) {
        searchGoodsField.type(q);
        searchButton.click();
        return goods;
    }

    public ExtendedWebElement getStorageBtn() {
        return storageBtn;
    }

    public List<GoodsItem> searchGoodsWithSort(String q) {
        searchGoodsField.type(q);
        pause(3);
        searchButton.click();
        filterButton.click();
        priceFilterButton.click();
        deliveryButton.click();
        freeDeliveryButton.click();
        pause(3);
        return goods;
    }

    public void getSelectColorBtn() {
        if ("Color".equals(getColorBtn().getElement().getText())) {
            selectColorBtn.click();
            colorBtn.click();
        } else {
            System.out.println("no color choice");
        }

    }

    public void getSelectStorageBtn() {
        if ("Storage".equals(getStorageBtn().getElement().getText())) {
            selectStorageBtn.click();
            storageBtn.click();
        } else {
            System.out.println("no storage choice");
        }

    }

}
