package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.tsum.utils.testExtensions.SetupTeardownDriverExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith({SetupTeardownDriverExtension.class})
public class RegistrationTest extends BaseTest {
    private String login;
    private String password;
    private String message = "Успешная регистрация";

    @BeforeAll
    public void getCredentials() {
        login = manager.getMainPg().testData.getRandomEmail();
        password = manager.getMainPg().testData.getRandomPassword();
    }

    @Test
    @Tag("PositiveTest")
    public void checkRegistration() {
        manager.getMainPg().registration(login, password);
        assertEquals(message, manager.getMainPg().getNotificationMessage(), "Error during new user registration");
    }

    @AfterAll
    public void logout() {
        //There is small error on the site(I described it). Workaround - refresh page.
        manager.getMainPg().refreshPage();
        manager.getMainPg().logout();
    }
}
