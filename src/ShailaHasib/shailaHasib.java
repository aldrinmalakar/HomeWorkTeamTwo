package ShailaHasib;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Author: Shaila Hasib
 * Date: October 23, 2020
 * Test Cases for Amazon home page
 */

public class shailaHasib {

    WebDriver driver;
    String targetUrl = "https://www.target.com/";
    String amazonUrl = "https://www.amazon.com/";
    //String expediaUrl ="https://www.expedia.com/";

    @BeforeMethod
    public void startUp() throws InterruptedException {
        String chromeDriverPath = "/Users/shailahasib/IdeaProjects/HomeWorkTeamTwo/BrowserDriver/mac/chromedriver";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(targetUrl);
        //driver.get(amazonUrl);
        Thread.sleep(3000);
    }

    @Test(enabled = false)
    public void homePage() throws InterruptedException {
        //driver.get(targetUrl);
        Thread.sleep(2000);
        String expected = "Target : Expect More. Pay Less.";
        String actual = driver.getTitle();
        Assert.assertEquals(expected, actual, "Failed");

    }

    @Test(enabled = false)
    public void location() throws InterruptedException {
        String targetUrl = "https://www.target.com/";
        //driver.get(targetUrl);
        driver.findElement(By.xpath("//button[@id='storeId-utilityNavBtn']")).click();
        driver.findElement(By.id("zipOrCityState")).sendKeys("11432");
        Thread.sleep(5000);
        driver.findElement(By.id("zipOrCityState")).sendKeys(Keys.ENTER);
        String expected = "7000 AUSTIN ST, FOREST HILLS, NY 11375-1022";
        String actual = driver.findElement(By.xpath("//div[contains(text(),'7000 AUSTIN ST, FOREST HILLS')]")).getText();
        Assert.assertEquals(actual, expected, "Failed");

    }

    @Test(enabled = false)
    public void cartValidation(){
        //driver.get(targetUrl);
        driver.findElement(By.xpath("//a[@id='cart']")).click();
        String expected ="Your cart is empty";
        String actual= driver.findElement(By.xpath("//h1[@class='Heading__StyledHeading-sc-1m9kw5a-0 crGulm']")).getText();
        Assert.assertEquals(actual,expected, "Failed");

    }

    @Test(enabled = false)
    public void createAccount(){
        //driver.get(targetUrl);
        driver.findElement(By.xpath("//a[@class='Link-sc-1khjl8b-0 dJwaza AccountLink-gx13jw-1 hoYfWX']")).click();
        driver.findElement(By.id("accountNav-createAccount")).click();
        driver.findElement(By.xpath("//input[@name='usernamecreateaccount']")).sendKeys("sarahabigail1990@yahoo.com");
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Sarah");
        driver.findElement(By.xpath("//input[@name='lastnamecreateaccount']")).sendKeys("Abigail");
        driver.findElement(By.xpath("//input[@name='phonecreateAccount']")).sendKeys("917-111-2222");
        driver.findElement(By.xpath("//input[@name='passwordcreateaccount']")).sendKeys("Password1");
        //driver.findElement(By.xpath("//button[@class ='sc-VigVT sc-jqCOkK iwmpYU']")).click();
    }

    @Test(enabled = false)
    public void categoriesDropDown() throws InterruptedException {
        //driver.get(targetUrl);
        driver.findElement(By.xpath("//span[contains(text(),'Categories')]")).click();
        String expected="Grocery";
        String actual = driver.findElement(By.xpath("//*[@id=\"5xt1a\"]/a/div")).getText();
        Thread.sleep(3000);
        Assert.assertEquals(actual,expected,"Failed: Drop down did not open");

    }

    @Test(enabled = false)
    public void trendingSearchesDisplay(){
        driver.findElement(By.xpath("//input[@id='search']")).click();
        String expected = "Trending searches";
        String actual=driver.findElement(By.className("//div[@data-test='typeaheadListHeading']")).getText();
        Assert.assertEquals(actual,expected,"Failed: Trending searches do not display");
    }

    @Test (enabled = false)
    public void clearanceDeals(){
        driver.findElement(By.xpath("//a[@id='secondary']")).click();
        String expected ="Clearance";
        String actual=driver.findElement(By.xpath("//*[@id=\"deals-clearance\"]/a/div")).getText();
        Assert.assertEquals(actual,expected,"Failed: Clearance not under deals dropdown");
    }

    @Test(enabled = false)
    public void signIn(){
        driver.findElement(By.xpath("//a[@class='Link-sc-1khjl8b-0 dJwaza AccountLink-gx13jw-1 hoYfWX']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Sign in')]")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("lillytsktsk@yahoo.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password1");
        driver.findElement(By.xpath("//button[@id='login']")).click();
        driver.findElement(By.className("sc-bxivhb eVjFKg")).click();
        driver.findElement(By.xpath("//button[@id='circle-skip']")).click();
        String expected ="Lilly";
        String actual =driver.findElement(By.className("styles__AccountName-sc-1kk0q5l-0 hVhJPq")).getText();
        Assert.assertEquals(actual, expected, "Failed: Username is invalid or not displayed");
    }

    @Test(enabled = false)
    public void featuredCategoriesDisplay(){
        String expected ="Featured categories";
        String actual= driver.findElement(By.xpath("//h2[contains(text(),'Featured categories')]")).getText();
        Assert.assertEquals(actual, expected, "Failed");
    }

    @Test(enabled = false)
    public void faceMaskFeatured(){
        String expected ="Face Masks";
        String actual =driver.findElement(By.xpath("//div[contains(text(),'Face Masks')]")).getText();
        Assert.assertEquals(actual,expected, "Failed");
    }

    @Test(enabled = true)
    public void helpButtonReturns(){
        driver.findElement(By.xpath("//button[@data-test='footerMenu-Help']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Returns')]")).click();
    }

    @Test
    public void searchBoxResult() {
        driver.findElement(By.xpath("//form[@class='searchInputForm']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("sunglasses");
        driver.findElement(By.xpath("//*[@id=\"headerMain\"]/div[1]/form/button[2]")).click();
        String expected = "“sunglasses”";
        String actual =driver.findElement(By.xpath("//h2[contains(text(),'sunglasses')]")).getText();
        Assert.assertEquals(actual,expected,"Failed");
    }

    @Test
    public void weeklyAdd(){
        driver.findElement(By.xpath("//div[1]/div[2]/div/div[1]/ul/li[2]")).click();
        String expected ="Weekly Ads & Catalogs";
        String actual = driver.findElement(By.className("desktop-title")).getText();
        Assert.assertEquals(actual, expected,"Failed");

    }

    @Test
    public void testRecallPage(){
        driver.findElement(By.xpath("//*[@id=\"footer\"]/div[2]/ul[1]/li[1]/a")).click();
        String expected = "Product Recalls";
        String actual = driver.getTitle();
        Assert.assertEquals(actual,expected,"Failed");
    }

    @Test
    public void addToCart() throws InterruptedException {
        driver.findElement(By.xpath("//form[@class='searchInputForm']")).click();
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("sunglasses");
        driver.findElement(By.xpath("//*[@id=\"headerMain\"]/div[1]/form/button[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[4]/div[2]/div/div[1]/div[3]/div[2]/ul/li[1]/div/div[2]/div/div/div/div[5]/div[1]/div/div/button")).click();
        Thread.sleep(3000);
        String expected = "View cart & checkout";
        String actual = driver.findElement(By.xpath("View cart & checkout")).getText();
        Assert.assertEquals(actual,expected,"Failed");

    }

    @Test
    public void ordersUnderSignIn(){
        driver.findElement(By.xpath("//a[@class='Link-sc-1khjl8b-0 dJwaza AccountLink-gx13jw-1 hoYfWX']")).click();
        driver.findElement(By.xpath("accountNav-orders")).click();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

