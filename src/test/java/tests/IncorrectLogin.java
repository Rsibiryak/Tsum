package tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import ru.tsum.utils.testExtensions.SetupTeardownDriverExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({SetupTeardownDriverExtension.class})
@RunWith(SerenityRunner.class)
public class IncorrectLogin extends BaseTest {
    private String login = "Rsibiryak@rambler.ru";
    private String password = "Test123";
    private String message = "Неверный логин или пароль";

    @Test
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
