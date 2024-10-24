package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.todoly.ProjectLeftSection;

import java.util.Date;

public class CreateProjectTest extends BaseTestTodoLy{

    ProjectLeftSection projectLeftSection = new ProjectLeftSection();
    @Test
    public void createProject(){
        String name = "UPB"+new Date().getTime();
        mainPage.loginButton.click();
        loginSection.login("selenium123@123.com","12345");
        projectLeftSection.addNewProjectButton.click();
        projectLeftSection.nameProjectTxtBox.setText(name);
        projectLeftSection.addButton.click();
        Assertions.assertEquals(name,projectLeftSection.getProjectLabel(name).getText(),
                "ERROR the project was not created");

    }
}

