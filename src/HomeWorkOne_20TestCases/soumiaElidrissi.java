package HomeWorkOne_20TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Author: Soumia Elidrissi
 * Date: October 27, 2020
 * Test Cases for Amazon
 */

import java.util.concurrent.TimeUnit;

public class soumiaElidrissi {
    WebDriver driver;
    String amazonUrl = "https://www.amazon.com/";

    String expectedText;
    String actualText;

    @BeforeMethod
    public void setUp() {

        String chromeDriverPath = "BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.get(amazonUrl);
    }


    @Test
    public void homePage() {
        expectedText = "https://www.amazon.com/";
        actualText = driver.getCurrentUrl();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void homePage1() {
        expectedText = "https://www.amaazon.com/";
        actualText = driver.getCurrentUrl();
        Assert.assertEquals(actualText, expectedText, "Test Fail. Url does not match");
    }

    @Test
    public void checkHomePageTitle() throws InterruptedException {
        expectedText = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void checkHomePageTitle1() throws InterruptedException {
        expectedText = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more'";
        actualText = driver.getTitle();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Title does not match");
    }
    @Test
    public void newReleasesPageNavigation() throws InterruptedException {
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(6)")).click();
        expectedText = "Amazon Hot New Releases";
        actualText = driver.findElement(By.id("zg_banner_text_wrapper")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void checkDropDownMenu() throws InterruptedException {
        driver.findElement(By.cssSelector("#nav-hamburger-menu > i")).click();
        driver.findElement(By.cssSelector("#hmenu-content > ul.hmenu.hmenu-visible > li:nth-child(2) > a")).click();
        driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[2]/li[3]/a")).click();
        expectedText = "Prime Video";
        actualText = driver.findElement(By.cssSelector("#a-page > div.DVWebNode-retail-nav-wrapper.DVWebNode.av-native-stick > div > a")).getText();
        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void searchBox() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("drill");
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        expectedText = "\"drill\"";
        actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");

    }
    @Test
    public void holidayDealsPageNavigation() throws InterruptedException {
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(2)")).click();
        expectedText = "Holiday Dash Shop epic deals daily";
        actualText = driver.findElement(By.xpath("//*[@id=\"contentGrid_369910\"]/div/div/div/div/div/img")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void checkoutItem() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("selenium");
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/h2/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"mbc-buybutton-addtocart-1-announce\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"hlb-ptc-btn-native\"]")).click();
        expectedText = "Sign-In";
        actualText = driver.findElement(By.xpath("//*[@id=\"authportal-main-section\"]/div[2]/div/div[1]/form/div/div/div/h1")).getText();
        Assert.assertEquals(actualText,expectedText);

    }

    @Test
    public void createAmazonAccount() throws InterruptedException {
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("createAccountSubmit")).click();
        driver.findElement(By.cssSelector("#ap_customer_name")).sendKeys("Paul Johnson");
        driver.findElement(By.cssSelector("#ap_email")).sendKeys("paul.johnson@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("pass1234");
        driver.findElement(By.xpath("//*[@id=\"ap_password_check\"]")).sendKeys("pass1234");

    }

    @Test
    public void loginWithValidCredential() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).click();
        driver.findElement(By.id("ap_email")).sendKeys("paul.johnson@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("pass1234");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
    }


        @AfterMethod
        public void tearDown () {
            driver.quit();
        }

    }

