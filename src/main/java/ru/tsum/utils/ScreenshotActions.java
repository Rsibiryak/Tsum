package ru.tsum.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * ScreenshotActions
 * <p>
 * Work with screenshot
 *
 * @author Alexander_Suvorov
 */
public class ScreenshotActions {
    private AppManager manager;
    private String path;

    public ScreenshotActions(AppManager manager) {
        this.manager = manager;
        path = System.getProperty("user.dir") + manager.getProperty().getProperty("screenshotPath");
    }

    /**
     * Create and save a screenshot in the folder
     *
     * @param screenName
     */
    public void takeScreenshot(String screenName) {
        try {
            File file = ((TakesScreenshot) manager.getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(String.format("%s%s.png", path, screenName)));
        } catch (IOException ex) {
            manager.getLogger().error(String.format("Can not create screenshot \n%s", ex.getMessage()));
        }
    }

    /**
     * Delete all files from screenshot folder
     */
    public void deleteAllScreenshot() {
        File directory = new File(path);
        manager.getLogger().debug("Deleting all files from: " + directory.getAbsolutePath());

        File[] files = directory.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.getName().endsWith(".png") && !file.delete()) {
                    manager.getLogger().debug("Can not delete file: " + file);
                }
            }
        }
    }
}
