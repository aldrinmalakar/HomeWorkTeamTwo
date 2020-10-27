package HomeWorkOne_20TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class hakimLehamel {




    WebDriver driver;
    String amazonURL = "https://www.amazon.com/";

    @BeforeMethod
    public void setUp() {
        String chromeDriverPath = "BrowserDriver/windows/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get(amazonURL);
        driver.manage().window().maximize();
        // driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(enabled = false)
    public void checkHomePageTitle() throws InterruptedException {
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Test Failed !");
    }

    @Test(enabled = false)
    public void loginWithInalidCredential() throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).click();
        driver.findElement(By.id("ap_email")).sendKeys("lehamelhakim833@gmail.com");
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("abcd1234");
        driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();

    }

    @Test(enabled = false)
    public void searchBox(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("airpods");
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        String expectedResult="\"airpods\"";
        String actualResult=driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
        Assert.assertEquals(actualResult,expectedResult,"test failed!");
    }

    @Test(enabled = false)
    public void changeLanguageButton(){
        driver.findElement(By.xpath("//span[@class='icp-nav-flag icp-nav-flag-us']")).click();
        driver.findElement(By.xpath("//*[@id=\"customer-preferences\"]/div/div/form/div[1]/div[1]/div[2]/div/label/i")).click();
        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        String expectedResult="Compra las primeras ofertas";
        String actualResult=driver.findElement(By.xpath("//*[@id=\"nav-swmslot\"]/a")).getText();
        Assert.assertEquals(actualResult,expectedResult,"test faild");
    }

    @Test(enabled = false)
    public void checkDeliveryOption(){
        driver.findElement(By.xpath("//*[@id=\"glow-ingress-line1\"]")).click();
        String expectedResult="Delivery options and delivery speeds may vary for different locations";
        String actualResult=driver.findElement(By.xpath("//*[@id=\"GLUXAddressBlock\"]/div/span")).getText();
        Assert.assertEquals(actualResult,expectedResult,"test failed");
    }

    @Test(enabled = false)
    public void checkCustomerServicesButton(){
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]")).click();
        String actualResult=  driver.findElement(By.xpath("/html/body/div[1]/div[1]/h1")).getText();
        String expectedResult="Hello. What can we help you with?";
        Assert.assertEquals(actualResult,expectedResult,"failed ");
    }

    @Test(enabled = false)
    public void checkTodaysDealsOption(){
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();
        String actualResult=  driver.findElement(By.xpath("//*[@id=\"gb-supple111126319322948\"]/div[1]/h1")).getText();
        String expectedResult="Shop all deals";
        Assert.assertEquals(actualResult,expectedResult,"failed ");
    }

    @Test(enabled = false)
    public void bestSellerOption(){
        driver.findElement(By.xpath("//a[contains(text(),'Best Sellers')]")).click();
        String expectedText = "Amazon Best Sellers";
        String actualText = driver.findElement(By.xpath("//*[@id=\"zg_banner_text_wrapper\"]")).getText();
        Assert.assertEquals(expectedText,actualText,"Failed");
    }

    @Test(enabled = false)
    public void cartBotton(){
        driver.findElement(By.id("nav-cart-count")).click();
        String expectedText = "Your Amazon Cart is empty";
        String actualText = driver.findElement(By.xpath("//*[@id=\"sc-active-cart\"]/div/div[2]/div[1]/h2")).getText();
        Assert.assertEquals(actualText,expectedText,"Failed");
    }

    @Test(enabled = false)
    public void settingButton(){
        driver.findElement(By.cssSelector("#nav-hamburger-menu > i")).click();
        String expectedText = "Help & Settings";
        String actualText = driver.findElement(By.xpath("//div[contains(text(),'help & settings')]")).getText();
        Assert.assertEquals(actualText,expectedText,"Failed");
    }

    @Test(enabled = false)
    public void giftCardButton(){
        driver.findElement(By.cssSelector("#nav-xshop > a:nth-child(3)")).click();
        String expectedText = "Gift Cards";
        String actualText = driver.findElement(By.xpath("//*[@id=\"merchandised-content\"]/div[2]/div[1]/div/h1")).getText();
        Assert.assertEquals(actualText,expectedText,"Failed");
    }

    @Test(enabled = false)
    public void addToCartButton(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("galaxy s10 case red");
        driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[2]/div/span/div/div/div/div/div[2]/h2/a/span")).click();
        driver.findElement(By.cssSelector("#add-to-cart-button")).click();
        String expectedResult="Added to Cart";
        String actualResult=driver.findElement(By.cssSelector("#huc-v2-order-row-confirm-text > h1")).getText();
        Assert.assertEquals(expectedResult,actualResult,"test failed!");
    }

    @Test(enabled = false)
    public void checkTryPrimebutton() {
        driver.findElement(By.cssSelector("#nav-link-prime > span")).click();
        String expectedText = "More benefits included with Prime";
        String actualText = driver.findElement(By.xpath("//*[@id=\"prime-bottom-benefits-list\"]/div[1]/div/h2")).getText();
        Assert.assertEquals(actualText, expectedText, "Failed");
    }

    @Test(enabled = false)
    public void checkAmazonAssistantButton() {
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[1]/ul/li[3]/a")).click();
        String expectedText = "Who we are";
        String actualText = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[1]")).getText();
        Assert.assertEquals(actualText, expectedText, "Failed");
    }

    @Test(enabled = false)
    public void checkBackToTopButton() {
        driver.findElement(By.xpath("//*[@id=\"navBackToTop\"]/div/span")).click();
        String expectedText = "Hello, Sign in";
        String actualText = driver.findElement(By.cssSelector("#nav-link-accountList > div > span")).getText();
        Assert.assertEquals(actualText, expectedText, "Failed");
    }

    @Test(enabled = false)
    public void checkSellAppsOnAmazonButton() {
        driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[3]/ul/li[2]/a")).click();
        String expectedText = "Amazon Developer Services and Technologies";
        String actualText = driver.findElement(By.xpath("//*[@id=\"a-page\"]/section[1]/div/div/h2")).getText();
        Assert.assertEquals(actualText, expectedText, "Failed");
    }

    @Test(enabled = false)
    public void checkLiveSreamsButton() {
        driver.findElement(By.className("link--87_Ra")).click();
        String expectedText = "Get Fit | Amazon Live";
        String actualText = driver.findElement(By.xpath("//*[@id=\"live-destination-header\"]/div[2]")).getText();
        Assert.assertEquals(actualText, expectedText, "Failed");
    }





}


