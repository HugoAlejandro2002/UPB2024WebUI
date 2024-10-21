package testSuite;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todoly.LoginSection;
import pages.todoly.MainPage;
import pages.todoly.MenuSection;
import pages.todoly.SettingsSection;
import session.Session;

public class BaseTestTodoLy {

    protected MainPage mainPage = new MainPage();
    protected LoginSection loginSection = new LoginSection();
    protected MenuSection menuSection = new MenuSection();
    protected SettingsSection settingsSection = new SettingsSection();

    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get("https://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }


}
