package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.tsum.utils.testExtensions.SetupTeardownDriverExtension;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({SetupTeardownDriverExtension.class})
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
