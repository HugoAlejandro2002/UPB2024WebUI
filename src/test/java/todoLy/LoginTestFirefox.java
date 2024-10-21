package todoLy;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;
public class LoginTestFirefox {
    WebDriver firefox;
    @BeforeEach
    public void openBrowser() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/firefox/geckodriver.exe");
        firefox = new FirefoxDriver();
        firefox.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        firefox.manage().window().maximize();
        firefox.get("https://todo.ly/");
    }
    @AfterEach
    public void closeBrowser() {
        firefox.quit();
    }
    @Test
    @DisplayName("Verify login test is successfully in Firefox")
    public void verifyLoginTest() throws InterruptedException {
        firefox.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        firefox.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        firefox.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        firefox.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        // verification
        Assertions.assertTrue(firefox.findElements(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).size() == 1,
                "ERROR! No se pudo iniciar sesión");
    }
}