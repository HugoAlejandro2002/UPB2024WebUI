package basic;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;
import java.util.Date;

public class EliminateProjectTest {
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
    @DisplayName("Verify create and delete project")
    public void verifyCreateAndDeleteProject() throws InterruptedException {
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        // Verification of login success
        Assertions.assertTrue(chrome.findElements(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).size() == 1,
                "ERROR! No se pudo iniciar sesión");

        // Create project
        String nameProject = "UPB" + new Date().getTime();
        chrome.findElement(By.xpath("//td[text()='Add New Project']")).click();
        chrome.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
        chrome.findElement(By.id("NewProjNameButton")).click();

        // Verification of project creation
        String expectedResult = nameProject;
        String actualResult = chrome.findElement(By.xpath("//li[last()]//td[text()='" + nameProject + "']")).getText();
        Assertions.assertEquals(expectedResult, actualResult, "ERROR! El proyecto no se creó correctamente");

        // Delete project
        chrome.findElement(By.xpath("//li[last()]//td[text()='" + nameProject + "']")).click();
        chrome.findElement(By.xpath("//div[@style=\"display: block;\"]/img")).click();
        chrome.findElement(By.xpath("//ul[contains(@style,'block;')]//a[text()='Delete']")).click();
        Thread.sleep(100);

        // Handle the alert to confirm deletion
        chrome.switchTo().alert().accept();
        Thread.sleep(1000);  // Wait for the deletion to take effect

        // Verification of project deletion
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            chrome.findElement(By.xpath("//li//td[text()='" + nameProject + "']"));
        }, "ERROR! El proyecto aún existe después de eliminarlo.");
    }
}
