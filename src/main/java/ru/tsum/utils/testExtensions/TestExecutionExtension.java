package ru.tsum.utils.testExtensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.tsum.utils.AppManager;

/**
 * TestExecutionExtension
 * <p>
 * Actions before and after test execution
 *
 * @author Alexander_Suvorov
 */
public class TestExecutionExtension implements AfterTestExecutionCallback, BeforeTestExecutionCallback {
    public static AppManager manager = AppManager.getInstance();

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        manager.getLogger().info(String.format("Run test: %s ", context.getDisplayName()));
    }

    /**
     * If test failed then create screenshot
     *
     * @param context
     */
    @Override
    public void afterTestExecution(ExtensionContext context) {
        Boolean testResult = context.getExecutionException().isPresent();
        String testName = context.getDisplayName();

        if (testResult) {
            manager.getScreenshotActions().takeScreenshot(testName);

        } else {
            manager.getLogger().info(String.format("Stop test: %s ", testName));
        }
    }
}
