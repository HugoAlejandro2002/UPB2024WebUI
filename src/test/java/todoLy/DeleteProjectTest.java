package todoLy;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DeleteProjectTest {
    WebDriver chrome;

    @BeforeEach
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
        chrome = new ChromeDriver();
        chrome.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        chrome.manage().window().maximize();
        chrome.get("https://todo.ly/");
    }

    @AfterEach
    public void closeBrowser() {
        chrome.quit();
    }

    @Test
    @DisplayName("verify a project is deleted")
    public void verifyDeleteProject() throws InterruptedException{
        //Login
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        //Create a new project
        chrome.findElement(By.id("Div2")).click();
        String nameProject = "New Project Valeria";
        chrome.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        chrome.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(5000);
        //Delete the new project
        WebElement project = chrome.findElement(By.cssSelector(".LiDiv.BaseProjectLiDiv.LeftLiDiv.ProjectSelected"));
        project.findElement(By.className("ProjItemMenu")).click();
        chrome.findElement(By.id("ProjShareMenuDel")).click();
        Thread.sleep(2000);

        //Confirm the google alert
        chrome.switchTo().alert().accept();
        Thread.sleep(1000);

        //Verificate that the project is deleted
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            chrome.findElement(By.xpath("//li//td[text()='" + nameProject + "']"));
        }, "ERROR! El proyecto aún existe después de eliminarlo.");
    }

}
