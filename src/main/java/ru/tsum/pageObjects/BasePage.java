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

    public BasePage(AppManager manager) {
        this.manager = manager;
        property = manager.getProperty();
        TIMEOUT = Integer.parseInt(property.getProperty("timeout"));
        testData = new TestData();
        log = manager.getLogger();
        driver = manager.getDriver();
    }

    public WebElement getElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.withMessage(String.format("Element was not found\nLocator - %s", locator.toString()));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public Boolean isElementPresent(By locator) {
        return manager.getDriver().findElements(locator).size() != 0;
    }

    public void refreshPage() {
        manager.getDriver().navigate().refresh();
        log.info("Refresh page");
    }
}
