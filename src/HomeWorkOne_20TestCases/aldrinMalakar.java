package HomeWorkOne_20TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class aldrinMalakar {


    WebDriver driver = null;
    String tdBankURL = "https://www.td.com/us/en/personal-banking/online-banking/";

    @BeforeMethod
    public void setup() {
        String browserDriverPath = "BrowserDriver/windows/chromedriver.exe";

        //Initializing Chrome Browser
        System.setProperty("webdriver.chrome.driver", browserDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test(enabled = false)
    public void checkLink() throws InterruptedException {

        driver.get(tdBankURL);
        System.out.println("We Are Now Testing: " + driver.getCurrentUrl());

        String expectedLink = "https://www.td.com/us/en/personal-banking/online-banking/";
        String actualLink = driver.getCurrentUrl();


        //Validate Links
        Assert.assertEquals(actualLink, expectedLink, "Test Failed, Link Does Not Match");
        Thread.sleep(5000);

    }

    @Test(enabled = false)
    /**
     Opening browser and play the enrolment video.
     */
    public void playEnrollVideo() {
        driver.get(tdBankURL);
        driver.findElement(By.cssSelector("#product1_item0 > div > div.td-product-conatiner-height > div.td-product-image > div > div > a > img")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(enabled = true)
    public void searchBox() {
        driver.get(tdBankURL);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/header[1]/div[3]/div/div[2]/div/ul/li[3]/a/span[1]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/header[1]/div[3]/div/div[3]/div/header-search-input/form/input[1]")).sendKeys("What are other possible benefits of having an IRA?");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/header[1]/div[3]/div/div[3]/div/header-search-input/form/input[1]")).sendKeys(Keys.ENTER);
        //Validate
        String expectedText = "What are other possible benefits of having an IRA?";
        String actualText = driver.findElement(By.xpath("//*[@id=\"main\"]/search/div[1]/div/div/h1/strong")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Failed, Searched Keyword Does Not Match.");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
