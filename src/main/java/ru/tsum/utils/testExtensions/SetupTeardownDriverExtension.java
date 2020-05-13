package ru.tsum.utils.testExtensions;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.tsum.utils.AppManager;

/**
 * SetupTeardownDriverExtension
 * <p>
 * Start and stop driver before|after all tests
 *
 * @author Alexander_Suvorov
 */
public class SetupTeardownDriverExtension implements BeforeAllCallback {
    private static boolean started = false;
    public static AppManager manager;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!started) {
            started = true;
            manager = AppManager.getInstance();
            manager.getScreenshotActions().deleteAllScreenshot();
            context.getStore(ExtensionContext.Namespace.GLOBAL).put("my_tests", new CloseableOnlyOnceResource());
        }
    }

    private static class CloseableOnlyOnceResource implements ExtensionContext.Store.CloseableResource {
        @Override
        public void close() {
            //AppManager.stopInstance();
        }
    }
}
