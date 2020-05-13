package tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

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
