package testSuiteTodoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class CreateProjectTest extends BaseTestTodoist{
    @Test
    public void createProjectSuccessfully() throws InterruptedException {
        String name = "ProjectName"+new Date().getTime();
        mainPageTodoist.loginButton.click();
        loginPageTodoist.login("apazahuaychohugoalejandro@gmail.com", "Holasoyyo2002");
        menuSectionTodoist.addProjectButton.click();
        menuSectionTodoist.confirmAddProjectButton.click();
        addProjectSection.projectName.clearSetText(name);
        addProjectSection.addProjectButton.click();
        Assertions.assertEquals(name,projectSection.projectLabel.getText(),"ERROR the project was not created");
    }
}

