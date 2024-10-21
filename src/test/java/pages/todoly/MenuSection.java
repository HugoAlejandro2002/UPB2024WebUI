package pages.todoly;

import controls.Button;
import org.openqa.selenium.By;

public class MenuSection {
    public Button logoutButton = new Button(By.id("ctl00_HeaderTopControl1_LinkButtonLogout"));

    public Button settingsButton = new Button(By.xpath("//a[text()='Settings']"));
}
