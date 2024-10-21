package testSuiteTodoist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.todoist.*;
import session.Session;

public class BaseTestTodoist {

    MainPageTodoist mainPageTodoist = new MainPageTodoist();
    LoginPage loginPageTodoist = new LoginPage();
    MenuSectionTodoist menuSectionTodoist = new MenuSectionTodoist();
    AddProjectSection addProjectSection = new AddProjectSection();
    ProjectSection projectSection = new ProjectSection();
    @BeforeEach
    public void openBrowser(){
        Session.getInstance().getBrowser().get("https://todoist.com/es");
    }

    @AfterEach
    public void closeBrowser(){
        Session.getInstance().closeSession();
    }
}
