package pages.todoly;

import controls.Button;
import controls.TextBox;
import controls.Label;
import org.openqa.selenium.By;

public class ItemsSection {
    public TextBox newItemTextBox = new TextBox(By.id("NewItemContentInput"));
    public Button addItemButton = new Button(By.id("NewItemAddButton"));

    public TextBox editItemTextBox = new TextBox(By.id("ItemEditTextbox"));
    public Button saveItemButton = new Button(By.id("ItemEditSubmit"));

    public Label getItemLabel(String itemName) {
        return new Label(By.xpath("//div[@class='ItemContentDiv' and text()='" + itemName + "']"));
    }

    public void createItem(String itemName) {
        newItemTextBox.setText(itemName);
        addItemButton.click();
    }

    public void editItem(String newItemName) {
        editItemTextBox.clearSetText(newItemName);
        saveItemButton.click();
    }
}
