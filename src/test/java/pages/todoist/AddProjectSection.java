package pages.todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class AddProjectSection {
    public TextBox projectName = new TextBox(By.xpath("//input[@name='name' and @type='text']"));
    public Button addProjectButton = new Button(By.xpath("//button[@type='submit']"));
}
