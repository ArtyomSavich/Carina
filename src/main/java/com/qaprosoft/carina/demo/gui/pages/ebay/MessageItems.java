package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageItems extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageItems.class);
    @FindBy(xpath = "//span")

    private ExtendedWebElement messageTitle;

    public MessageItems(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String readTitleOfMessage() {
        return messageTitle.getElement().getText();
    }
}
