package tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncorrectLogin extends BaseTest {
    private String login = "Rsibiryak@rambler.ru";
    private String password = "Test123";
    private String message = "Неверный логин или пароль";

    @Test()
    @Tag("NegativeTest")
    public void checkLogin() {
        manager.getMainPg().login(login, password);
        assertEquals(message, manager.getMainPg().getNotificationError(), "Error message does not appear");
    }

    @AfterAll
    public void logout() {
        manager.getMainPg().setMainPage();
    }
}
