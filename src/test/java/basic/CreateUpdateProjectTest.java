package basic;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CreateUpdateProjectTest {
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
    @DisplayName("Update project test successfully")
    public void verifyCreateUpdateProjectTest() throws InterruptedException {
        // Login
        chrome.findElement(By.xpath("//img[@src=\"/Images/design/pagelogin.png\"]")).click();
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxEmail")).sendKeys("selenium123@123.com");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_TextBoxPassword")).sendKeys("12345");
        chrome.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();

        // Click on "Add New Project"
        chrome.findElement(By.xpath("//div[@onclick=\"javascript:ShowAddNewProject();\"]")).click();

        // Send project name
        String projectName = "Test Project";
        chrome.findElement(By.id("NewProjNameInput")).sendKeys(projectName);

        // Click "Add" button
        chrome.findElement(By.id("NewProjNameButton")).click();

        // Verify project is created
        List<WebElement> projectElements = chrome.findElements(By.xpath("//li[contains(@class, 'BaseProjectLi') and .//td[@class='ProjItemContent' and text()='" + projectName + "']]"));
        Assertions.assertTrue(projectElements.size() > 0, "Project not found");

        // Click on created project
        projectElements.get(0).click();

        // Click on dropdown icon to edit
        projectElements.get(0).findElement(By.xpath(".//img[@src='/Images/dropdown.png']")).click();

        // Click on Edit option
        chrome.findElement(By.xpath("//ul[@id='projectContextMenu']//li[@class='edit']")).click();

        // Update project name
        String updatedProjectName = "Updated Test Project";
        WebElement editTextbox = chrome.findElement(By.id("ItemEditTextbox"));
        editTextbox.clear();
        editTextbox.sendKeys(updatedProjectName);

        // Save updated project
        chrome.findElement(By.xpath("//img[@id='ItemEditSubmit' and @src='/Images/save.png']")).click();

        // Verify updated project exists
        List<WebElement> updatedProjectElements = chrome.findElements(By.xpath("//li[contains(@class, 'BaseProjectLi') and .//td[@class='ProjItemContent' and text()='" + updatedProjectName + "']]"));
        Assertions.assertTrue(updatedProjectElements.size() > 0, "Updated project not found");
    }
}
