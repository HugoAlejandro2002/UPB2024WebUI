package pages.todoist;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class LoginPage {
    public TextBox emailTextBox = new TextBox(By.id("element-0"));
    public TextBox passwordTextBox = new TextBox(By.id("element-2"));
    public Button loginButton = new Button(By.xpath("//button[@data-gtm-id='start-email-login']"));

    public void login(String email, String password){
        this.emailTextBox.setText(email);
        this.passwordTextBox.setText(password);
        this.loginButton.click();
    }
}
