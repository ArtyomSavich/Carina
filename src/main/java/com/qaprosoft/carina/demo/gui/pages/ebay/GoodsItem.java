package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoodsItem extends AbstractUIObject {


    @FindBy(xpath=".//h3[@class='s-item__title']")
    public ExtendedWebElement titleLink;

    @FindBy(xpath = ".//span[@class='s-item__price']")
    private ExtendedWebElement goodsPrice;

    //*[@class='srp-carousel-list__item-link']//div[contains(text(), 'Over $300.00')

    public GoodsItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


    public String readTitle() {
        return titleLink.getElement().getText();
    }

    public Double getGoodsPrice() {
        String[] array = this.goodsPrice.getText().replaceAll
                ("\\$", "").replaceAll("to", "").split(" ");
        return Double.parseDouble(array[0]);
    }

}
