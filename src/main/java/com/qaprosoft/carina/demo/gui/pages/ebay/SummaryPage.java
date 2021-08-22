package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SummaryPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='centralview']//tr[@class='msg-unread row']")
    private List<MessageItems> message;

    public SummaryPage(WebDriver driver) {
        super(driver);
        setPageURL("/mesgweb/ViewMessages/0");
    }
    public List<MessageItems> findMessage(){
        return message;
    }
}
