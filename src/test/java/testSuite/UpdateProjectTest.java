package testSuite;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.todoly.ProjectLeftSection;

import java.util.Date;

public class UpdateProjectTest extends  BaseTestTodoLy{
    ProjectLeftSection projectLeftSection = new ProjectLeftSection();
    @Test
    public void verifyUpdateProject(){
        String name = "UPB"+new Date().getTime();
        mainPage.loginButton.click();
        loginSection.login("selenium123@123.com","12345");
        projectLeftSection.createProject(name);

        projectLeftSection.getProjectLabel(name).click();
        projectLeftSection.menuIcon.click();
        projectLeftSection.subMenuOptions.editButton.click();
        String newName = "TEST"+new Date().getTime();
        projectLeftSection.nameProjectEditTxtBox.clearSetText(newName);
        projectLeftSection.saveIcon.click();

        Assertions.assertEquals(newName,projectLeftSection.getProjectLabel(newName).getText(),
               "ERROR! the project was not updated" );

    }


}
