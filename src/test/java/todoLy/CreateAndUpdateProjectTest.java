package todoLy;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CreateAndUpdateProjectTest {
    WebDriver chrome;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.manage().window().maximize();
        chrome.get("https://todo.ly/");
    }

    @AfterEach
    public void closeBrowser(){
        chrome.quit();
    }

    @Test
    @DisplayName("Verify create project is successfully")
    public void verifyCreateAndUpdateProject() throws  InterruptedException {
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        chrome.findElement(By.id("Div2")).click();
        chrome.findElement(By.id("NewProjNameInput")).sendKeys("New Project Valeria");
        chrome.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(5000);
        WebElement elementCreated = chrome.findElement(By.cssSelector(".LiDiv.BaseProjectLiDiv.LeftLiDiv.ProjectSelected"));
        Assertions.assertTrue(elementCreated.getText().contains("New Project Valeria"),
                "ERROR! No se pudo crear el proyecto");

        elementCreated.findElement(By.className("ProjItemMenu")).click();
        chrome.findElement(By.className("edit")).click();
        chrome.findElement(By.id("ItemEditTextbox")).clear();
        chrome.findElement(By.id("ItemEditTextbox")).sendKeys("Updated Project Valeria");
        chrome.findElement(By.id("ItemEditSubmit")).click();
        Thread.sleep(5000);
        Assertions.assertTrue(elementCreated.getText().contains("Updated Project Valeria"));
    }

}
