package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.tsum.utils.testExtensions.SetupTeardownDriverExtension;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({SetupTeardownDriverExtension.class})
public class LoginTest extends BaseTest {
    private String login = "Rsibiryak@rambler.ru";
    private String password = "Test1234";

    @Test
    @Tag("PositiveTest")
    public void checkLogin() {
        manager.getMainPg().login(login, password);
        assertEquals(login, manager.getMainPg().getNicName(), "Error during login");
    }

    @AfterAll
    public void logout() {
        manager.getMainPg().logout();
    }
}
