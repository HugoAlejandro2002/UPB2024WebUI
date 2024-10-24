package testSuiteTodoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTestTodoist{
    @Test
    public void verifyLogin(){
        mainPageTodoist.loginButton.click();
        loginPageTodoist.emailTextBox.setText("apazahuaychohugoalejandro@gmail.com");
        loginPageTodoist.passwordTextBox.setText("Holasoyyo2002");
        loginPageTodoist.loginButton.click();
        Assertions.assertTrue(menuSectionTodoist.profileButton.isControlDislayed(), "Error: lofin failed");
    }
}

