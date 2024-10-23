package todoLy;


import testSuite.BaseTestTodoLy;
import pages.todoly.ItemsSection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.todoly.ProjectLeftSection;
import java.util.Date;

public class CreateProjectAndItemTest extends BaseTestTodoLy {

    ProjectLeftSection projectLeftSection = new ProjectLeftSection();
    ItemsSection itemsSection = new ItemsSection();

    @Test
    public void createProjectAndAddItem() {
        String projectName = "Proyecto-" + new Date().getTime();
        String itemName = "Item-" + new Date().getTime();
        String newItemName = "ItemActualizado-" + new Date().getTime();

        mainPage.loginButton.click();
        loginSection.login("apazahuaychohugoalejandro@gmail.com", "Holasoyyo2002");

        projectLeftSection.createProject(projectName);
        Assertions.assertTrue(
                projectLeftSection.getProjectLabel(projectName).isControlDislayed(),
                "ERROR: El proyecto no se creó correctamente."
        );

        projectLeftSection.getProjectLabel(projectName).click();


        itemsSection.createItem(itemName);
        Assertions.assertTrue(
                itemsSection.getItemLabel(itemName).isControlDislayed(),
                "ERROR: El item no se creó correctamente."
        );

        itemsSection.getItemLabel(itemName).click();
        itemsSection.editItem(newItemName);

        Assertions.assertTrue(
                itemsSection.getItemLabel(newItemName).isControlDislayed(),
                "ERROR: El item no se actualizó correctamente."
        );
    }
}