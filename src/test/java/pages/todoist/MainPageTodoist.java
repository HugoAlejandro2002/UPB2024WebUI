package pages.todoist;

import controls.Button;
import org.openqa.selenium.By;

public class MainPageTodoist {
    public Button loginButton = new Button(By.xpath("//a[@href='https://app.todoist.com/auth/login']"));
}
