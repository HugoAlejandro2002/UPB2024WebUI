package pages.todoly;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class SettingsSection {
    public TextBox fullNameTextbox = new TextBox(By.xpath("//input[@id='FullNameInput']"));

    public Button okButton = new Button(By.xpath("//button[span[text()='Ok']]"));
}