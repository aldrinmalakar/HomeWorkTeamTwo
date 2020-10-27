package HomeWorkOne_20TestCases;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Author: Ferhat Allaoua
 * Date: October 27, 2020
 * Test Cases for Target home page
 */
public class ferhatAllaoua {

    WebDriver driver;
    String targetUrl ="https://www.target.com/";
    @BeforeMethod
    public void setUp(){
        String chromeDriverPath = "BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    @Test
    public void checkHomePageTitle() throws InterruptedException {
        //driver.get(targetUrl);
        String expectedTitle = "Target : Expect More. Pay Less.";
        String actualTitle = driver.getTitle();
        // Validate Title
        Assert.assertEquals(actualTitle, expectedTitle, "Test Fail: Title does not match");
        Thread.sleep(5000);


    }
    @Test
    public void searchBox() throws InterruptedException {
        // Open Browser and Navigate to Target Url
        //driver.get(targetUrl);
        // Enter "Face Mask" in searchBox WebEdit Field
        driver.findElement(By.cssSelector("#search")).sendKeys("face mask");
        // for wait only
        Thread.sleep(3000);
        // Click on search Button
        driver.findElement(By.xpath("//*[@id=\"headerMain\"]/div[1]/form/button[2]")).click();
        // Validate
        String expectedText = "\"face mask\"";
        String actualText = driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[5]/div[2]/div/div[2]/div[3]/div[1]/div[1]/div[1]/h2")).getText();
        Assert.assertEquals(actualText,expectedText,"Test Fail: Search keyword does not match");


    }

    @AfterMethod
    public void tearDown(){
        // driver.close();
        driver.quit();
    }



}
