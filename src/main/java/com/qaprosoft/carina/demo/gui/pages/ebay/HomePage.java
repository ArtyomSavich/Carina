package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
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

    @FindBy(xpath = "//li[@class='gh-t gh-divider-l']//a[contains(text(),'Daily Deals')]")
    private ExtendedWebElement openDailyDeals;

    @FindBy(xpath = "//li[@id = 'gh-eb-Geo']//a[@role = 'button']")
    private ExtendedWebElement changeLanguageButton;

    @FindBy(xpath = "//li[@id = 'gh-eb-Geo']//a[@id = 'gh-eb-Geo-a-en']")
    private ExtendedWebElement changeLanguageEn;

    @FindBy(xpath = "//li[@id = 'gh-eb-Geo']//div//a[@id='gh-eb-Geo-a-default']")
    private ExtendedWebElement changeLanguageRus;

    @FindBy(xpath = "//div[@id='gh-top']")
    private PageHeaderMenu headerMenu;

    public void signOutButton() {
        this.signOutButton.click();
    }
    public void helloButton() {
        this.helloButton.click();
    }
    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }
    public PageHeaderMenu headerMenu() {
        return headerMenu;
    }
    public void changeLanguageButton() {
        this.changeLanguageButton.hover();
    }
    public void signInButton(){this.signInButton.click();}
    public String getText() {
        return helloText2.getText();
    }
    public String getHelloText() {
        return helloText.getText();
    }
    public void changeLanguageEn() {this.changeLanguageEn.click();}
    public ExtendedWebElement changeLanguageRus() {
        return changeLanguageRus;
    }
    public DealsPage openDailyDealsPage() {
        openDailyDeals.click();
        return new DealsPage(driver);
    }
}
