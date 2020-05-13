package ru.tsum.pageObjects;

import org.openqa.selenium.By;
import ru.tsum.utils.AppManager;

/**
 * MainPage
 *
 * Actions with main page.
 *
 * @author Alexander_Suvorov
 */
public class MainPage extends BasePage {
    private By personalAccount = By.cssSelector("[class = 'header__link ng-star-inserted']");
    private By auth = By.cssSelector("p.auth-layout__control-button:first-child");
    private By registration = By.cssSelector("p.auth-layout__control-button:last-child");
    private By email = By.cssSelector(".input-wrapper [formcontrolname='email']");
    private By password = By.cssSelector("[formcontrolname='password']");
    private By loginButton = By.cssSelector(".button-wrapper button[type='submit']");
    private By logout = By.cssSelector(".personal__nav li:last-child a");
    private By notification = By.cssSelector("[class='notice info'] span");
    private By notificationError = By.cssSelector("[class='notice error'] span");

    public MainPage(AppManager manager) {
        super(manager);
    }

    public MainPage login(String login, String password) {
        getElement(personalAccount).click();
        getElement(auth).click();
        fillCredentialsAndClick(login, password);
        log.info("Login");
        return this;
    }

    public MainPage registration(String login, String password) {
        getElement(personalAccount).click();
        getElement(registration).click();
        fillCredentialsAndClick(login, password);
        log.info("Registration");
        return this;
    }

    private void fillCredentialsAndClick(String login, String pass) {
        getElement(email).sendKeys(login);
        log.info(String.format("Set login %s", login));
        getElement(password).sendKeys(pass);
        log.info(String.format("Set password %s", pass));
        getElement(loginButton).click();
    }

    public MainPage logout() {
        getElement(personalAccount).click();
        getElement(logout).click();
        log.info("Logout");
        return this;
    }

    public String getNicName() {
        return getOuterTextAttribute(personalAccount);
    }

    public String getNotificationMessage() {
        return getOuterTextAttribute(notification);
    }

    public String getNotificationError() {
        return getOuterTextAttribute(notificationError);
    }

    private String getOuterTextAttribute(By locator) {
        return getElement(locator).getAttribute("outerText");
    }

    public MainPage setMainPage() {
        manager.getDriver().get(property.getProperty("baseURL"));
        log.info("Set main page");
        return this;
    }
}
