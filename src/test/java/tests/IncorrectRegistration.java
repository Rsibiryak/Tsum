package tests;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class IncorrectRegistration extends BaseTest {
    private String login = "Rsibiryak@rambler.ru";
    private String password = "Test";
    private String message = "Пароль должен быть не менее 8 символов длиной";

    @Test
    @Tag("NegativeTest")
    public void checkIncorrectRegistrationMessage() {
        manager.getMainPg().registration(login, password);
        assertEquals(message, manager.getMainPg().getNotificationError(), "Error message does not appear");
    }

    @AfterAll
    public void setMainPage() {
        manager.getMainPg().setMainPage();
    }
}
