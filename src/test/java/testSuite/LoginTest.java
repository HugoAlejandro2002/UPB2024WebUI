package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTestTodoLy{
    @Test
    public void verifyLoginSuccessfully(){
        mainPage.loginButton.click();
        loginSection.emailTxtBox.setText("selenium123@123.com");
        loginSection.pwdTxtBox.setText("12345");
        loginSection.loginButton.click();
        Assertions.assertTrue(menuSection.logoutButton.isControlDislayed(),
                "ERROR! the login was failed");
    }
}
