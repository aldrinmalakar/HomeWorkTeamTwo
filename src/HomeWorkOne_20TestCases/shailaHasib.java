package HomeWorkOne_20TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class shailaHasib {

    WebDriver driver;
    String amazonUrl = "https://www.amazon.com/";

    @BeforeMethod
    public void startUp(){
        String chromeDriverPath = "/Users/shailahasib/Desktop/chromedriver";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void createAmazonAccount() throws InterruptedException {
        driver.get(amazonUrl);
        Thread.sleep(3000);
        //find and click sign in
        driver.findElement(By.id("nav-link-accountList")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("createAccountSubmit")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#ap_customer_name")).sendKeys("Sarah Abigail");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#ap_email")).sendKeys("sarahabigail1990@yahoo.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("password123");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]")).sendKeys("password123");
        Thread.sleep(10000);
    }

    @Test(enabled = false)
    public void bestSellersPageNavigation() throws InterruptedException {
        driver.get(amazonUrl);
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(4)")).click();
        String expectedText = "Amazon Best Sellers";
        String actualText = driver.findElement(By.id("zg_banner_text_wrapper")).getText();
        Assert.assertEquals(expectedText,actualText,"Failed: Text \"Best Seller\" not found");
        Thread.sleep(5000);
    }

    @Test(enabled = true)
    public void updateLocationZipCode(){
        driver.get(amazonUrl);
        driver.findElement(By.id("nav-packard-glow-loc-icon")).click();
        driver.findElement(By.id("GLUXZipUpdateInput")).sendKeys("11102");
        driver.findElement(By.cssSelector("#GLUXZipUpdate > span > input")).click();
        String expectedText = driver.findElement(By.xpath("//span[@id='glow-ingress-line2']")).getText();
        String actualText = "Astoria 11102";
        Assert.assertEquals(expectedText, actualText,"Failed");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
