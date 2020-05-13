package tests;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.tsum.utils.AppManager;
import ru.tsum.utils.testExtensions.SetupTeardownDriverExtension;
import ru.tsum.utils.testExtensions.TestExecutionExtension;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({TestExecutionExtension.class})
@ExtendWith({SetupTeardownDriverExtension.class})
public class BaseTest {
    public static AppManager manager = AppManager.getInstance();
    public static Logger log = manager.getLogger();
}
