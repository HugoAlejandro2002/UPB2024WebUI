package todoLy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.todoly.MenuSection;
import pages.todoly.SettingsSection;
import testSuite.BaseTestTodoLy;

public class UpdateFullName extends BaseTestTodoLy {

    MenuSection menuSection = new MenuSection();
    SettingsSection settingsSection = new SettingsSection();

    @Test
    public void verifyUpdateFullName() throws InterruptedException {
        mainPage.loginButton.click();
        loginSection.login("apazahuaychohugoalejandro@gmail.com","Holasoyyo2002");
        String name = "Hugo Test 1234";
        menuSection.settingsButton.click();
        settingsSection.fullNameTextbox.clearSetText(name);
        settingsSection.okButton.click();
        Thread.sleep(10000);
        menuSection.settingsButton.click();
        Thread.sleep(5000);
        String actualResult = settingsSection.fullNameTextbox.getValue();
        Assertions.assertEquals(name,actualResult,
                "ERROR the Full Name was not updated");
    }
}

