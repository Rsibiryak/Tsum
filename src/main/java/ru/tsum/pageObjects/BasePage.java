package ru.tsum.pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.tsum.utils.AppManager;
import ru.tsum.utils.TestData;
import java.util.Properties;

public class BasePage {
    public TestData testData;
    protected AppManager manager;
    protected Properties property;
    protected Logger log;
    private final int TIMEOUT;
    private WebDriver driver;

    private By closeNotifications = By.cssSelector(".close[type='button']");
    private By notificationFrame = By.cssSelector(".flocktory-widget");





    public BasePage(AppManager manager) {
        this.manager = manager;
        property = manager.getProperty();
        TIMEOUT = Integer.parseInt(property.getProperty("timeout"));
        testData = new TestData();
        log = manager.getLogger();
        driver = manager.getDriver();
    }

/*
    public WebElement getElement(By locator) {
        //Fast design for popupwindow. I do not like this if.
        if(isElementPresent(showNotifications)){
            getElement(showNotifications).click();
        }
            WebDriverWait wait = new WebDriverWait(manager.getDriver(), TIMEOUT);
            wait.withMessage(String.format("Element was not found\nLocator - %s", locator.toString()));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    } */

    public WebElement getElement(By locator) {
        WebElement el = null;
       // try {
            WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
            wait.withMessage(String.format("Element was not found\nLocator - %s", locator.toString()));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      //  } catch(Exception ex) {
        //    if(isElementPresent(notificationFrame)){
              /*  driver.switchTo().frame(getElement(notificationFrame));
                getElement(closeNotifications).click();
                driver.switchTo().defaultContent();
                refreshPage();
                getElement(locator); */
         //   }
         //   return el;
        //}
    }




    public Boolean isElementPresent(By locator) {
        return manager.getDriver().findElements(locator).size() != 0;
    }

    public void refreshPage() {
        manager.getDriver().navigate().refresh();
        log.info("Refresh page");
    }
}
