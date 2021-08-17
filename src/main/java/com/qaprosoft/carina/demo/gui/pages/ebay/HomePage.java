package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//span[@class='gh-ug-guest']")
    private ExtendedWebElement signInButton;

    @FindBy(xpath = "//a[contains(text(),'Sign out')]")
    private ExtendedWebElement signOutButton;

    @FindBy(xpath = "//button[@class='gh-ua gh-control']")
    private ExtendedWebElement helloText;

    @FindBy(xpath = "//span[@id='gh-ug']")
    private ExtendedWebElement helloText2;

    @FindBy(xpath = "//button[@class='gh-ua gh-control']")
    private ExtendedWebElement helloButton;

    public ExtendedWebElement getHelloButton() {
        return helloButton;
    }

    @FindBy(xpath = "//li[@class='gh-t gh-divider-l']//a[contains(text(),'Daily Deals')]")
    private ExtendedWebElement openDailyDeals;

    @FindBy(xpath = "//li[@id = 'gh-eb-Geo']//a[@role = 'button']")
    private ExtendedWebElement changeLanguageButton;

    @FindBy(xpath = "//li[@id = 'gh-eb-Geo']//a[@id = 'gh-eb-Geo-a-en']")
    private ExtendedWebElement changeLanguageEn;

    @FindBy(xpath = "//li[@id = 'gh-eb-Geo']//div//a[@id='gh-eb-Geo-a-default']")
    private ExtendedWebElement changeLanguageRus;

    public ExtendedWebElement getSignOutButton() {
        return signOutButton;
    }

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }
    public ExtendedWebElement getChangeLanguageButton() {
        return changeLanguageButton;
    }
    public ExtendedWebElement getSignInButton(){
        return this.signInButton;
    }
    public String getHelloText2() {
        return helloText2.getText();
    }
    public String getHelloText() {
        return helloText.getText();
    }
    public ExtendedWebElement getChangeLanguageEn() {
        return changeLanguageEn;
    }
    public ExtendedWebElement getChangeLanguageRus() {
        return changeLanguageRus;
    }
    public DealsPage getOpenDailyDeals() {
        openDailyDeals.click();
        return new DealsPage(driver);
    }
}
