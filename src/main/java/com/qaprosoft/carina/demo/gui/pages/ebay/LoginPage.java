package com.qaprosoft.carina.demo.gui.pages.ebay;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='userid']")
    private ExtendedWebElement emailOrUserField;

    @FindBy(xpath = "//input[@name='pass']")
    private ExtendedWebElement passField;

    @FindBy(xpath = "//button[@name='signin-continue-btn']")
    private ExtendedWebElement continueButton;

    @FindBy(xpath = "//button[@name='sgnBt']")
    private ExtendedWebElement signButton;

    public ExtendedWebElement getContinueButton() {
        return continueButton;
    }

    @FindBy(xpath = "//a[contains(text(),'register')]")
    private ExtendedWebElement registerButton;

    @FindBy(xpath = "//input[@name='firstname']")
    private ExtendedWebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastname']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//input[@name='Email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private ExtendedWebElement passwordField;

    @FindBy(xpath = "//button[@name='EMAIL_REG_FORM_SUBMIT']")
    private ExtendedWebElement createAccountButton;


     public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getPassField() {
        return passField;
    }

    public ExtendedWebElement getSignButton() {
        return signButton;
    }

    public ExtendedWebElement getEmailOrUserField() {
        return emailOrUserField;
    }

    public ExtendedWebElement getRegisterButton() {
        return registerButton;
    }

    public ExtendedWebElement getFirstNameField() {
        return firstNameField;
    }

    public ExtendedWebElement getLastNameField() {
        return lastNameField;
    }

    public ExtendedWebElement getEmailField() {
        return emailField;
    }

    public ExtendedWebElement getPasswordField() {
        return passwordField;
    }

    public ExtendedWebElement getCreateAccountButton() {
        return createAccountButton;
    }

}
