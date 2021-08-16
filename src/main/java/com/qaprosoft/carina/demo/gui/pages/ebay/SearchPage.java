package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.w3c.dom.ls.LSOutput;

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
    //*[@id="nid-p7i-2"]/button/span/span
    @FindBy(xpath = "//button[@class='fake-menu-button__button expand-btn expand-btn--small']//*[contains(text(),'Delivery Options')]")
    private ExtendedWebElement deliveryButton;

    @FindBy(xpath = "//*[@class='fake-menu-button srp-controls__control srp-controls__control--flyout menu-1']//span//li[2]")
    private ExtendedWebElement freeDeliveryButton;

    public SearchPage(WebDriver driver) {super(driver);}

    public List<GoodsItem> searchGoods (String q){
        searchGoodsField.type(q);
        searchButton.click();
        return goods;
    }

    public List<GoodsItem> searchGoodsWithSort (String q){
        searchGoodsField.type(q);
        searchButton.click();
        filterButton.click();
        priceFilterButton.click();
        deliveryButton.click();
        freeDeliveryButton.click();
        pause(3);
        return goods;
    }

}
