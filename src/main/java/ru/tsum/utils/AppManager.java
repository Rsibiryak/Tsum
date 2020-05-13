package ru.tsum.utils;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.tsum.pageObjects.MainPage;

import java.util.Properties;

/**
 * AppManager
 *
 * Common gate for app management
 *
 * @author Alexander_Suvorov
 */
public class AppManager {
    private WebDriver driver;
    private PropertyManager propertyManager;
    private Properties property;
    private static AppManager instance;
    private ScreenshotActions screenshot;
    private MainPage mainPg;
    private static Logger log;

    private AppManager() {
        propertyManager = new PropertyManager();
        property = propertyManager.getProperty();

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(property.getProperty("baseURL"));

        log = CustomLogger.getLogger();
        mainPg = new MainPage(this);
        screenshot = new ScreenshotActions(this);
    }

    public static AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
            log.info("Driver initialization");
        }
        return instance;
    }

    public static void stopInstance() {
        if (instance != null) {
            instance.driver.quit();
        }
    }

    public MainPage getMainPg() {
        return mainPg;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Properties getProperty() {
        return property;
    }

    public Logger getLogger() {
        return log;
    }

    public ScreenshotActions getScreenshotActions() {
        return screenshot;
    }
}
