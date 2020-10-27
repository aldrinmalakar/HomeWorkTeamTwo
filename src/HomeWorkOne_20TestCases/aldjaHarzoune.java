package HomeWorkOne_20TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class aldjaHarzoune {



    public class HomePage {



        WebDriver driver;
        String targetUrl = "https://www.target.com/";

        public void setUp() {
            String chromeDriverPath = "BrowserDriver/windows/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().deleteAllCookies();
            driver.get(targetUrl);
        }


        @Test(enabled = false)
        public void checkHomePageTitle() throws InterruptedException {
            //driver.get(targetUrl);
            String expectedTitle = "target.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
            String actualTitle = driver.getTitle();
            // Validate Title
            Assert.assertEquals(actualTitle, expectedTitle, "Test Fail: Title does not match");
            Thread.sleep(5000);
        }

        @Test(enabled = false)
        public void searchBox1() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "face mask" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("face mask");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"face mask\"";
            String actualText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }


        @Test(enabled = false)
        public void searchBox2() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "Hand Sanitizer" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Hand Sanitizer");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"Hand Sanitizer\"";
            String actualText = driver.findElement(By.cssSelector("#search > span > div > span > h1 > div > div.sg-col-14-of-20.sg-col-26-of-32.sg-col-18-of-24.sg-col.sg-col-22-of-28.s-breadcrumb.sg-col-10-of-16.sg-col-30-of-36.sg-col-6-of-12 > div > div > span.a-color-state.a-text-bold")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");

        }

        @Test(enabled = false)
        public void searchBox3() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "hand soap" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("hand soap");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"hand soap\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox4() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "rolex" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("rolex");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"rolex\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox5() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "Hand Sanitizer" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 12 pro max");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"iphone 12 pro max\"";
            String actualText = driver.findElement(By.xpath("//span[text()='\"iphone 12 pro max\"']")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox6() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "gloves" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("gloves");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"gloves\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }


        @Test(enabled = false)
        public void searchBox7() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "Running Shoe" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Running Shoe");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"Running Shoe\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox8() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "hand bags" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("hand bags");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"hand bags\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox9() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "wallet" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wallet");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"wallet\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox10() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "sunglasses" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sunglasses");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"sunglasses\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }


        @Test(enabled = false)
        public void searchBox11() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "boxes plastic" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("boxes plastic");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"boxes plastic\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox12() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "hand cream" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("hand cream");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"hand cream\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox13() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "motocross helmet" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("motocross helmet");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"motocross helmet\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox14() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "jacket" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("jacket");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"jacket\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }


        @Test(enabled = false)
        public void searchBox15() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "pillow" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pillow");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"pillow\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox16() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "bed sheet" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bed sheet");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"bed sheet\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox17() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "socks" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("socks");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"socks\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }

        @Test(enabled = false)
        public void searchBox18() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // Enter "shampoo" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("shampoo");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(5000);
            // Validate
            String expectedText = "\"shampoo\"";
            String actualText = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[3]")).getText();
            Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }
        @Test(enabled = false)
        public void loginWithValidCredential() throws InterruptedException {
            // Open Browser and Navigate to target Url
            //driver.get(targetUrl);
            // click on hello sign in
            driver.findElement(By.xpath("//span[text()='Hello, Sign in']")).click();
            // Enter Email Address/ Phone Number
            driver.findElement(By.id("ap_email")).sendKeys("mh.shahib@gmail.com");
            // Click on Continue Button
            driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
            Thread.sleep(3000);
            // Enter Password
            driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("Test123456");
            // Click submit/signIn button
            driver.findElement(By.xpath("//*[@id=\"signInSubmit\"]")).click();
            Thread.sleep(3000);
        }

        @Test(enabled = true)
        public void searchToys() throws InterruptedException {
            // Open Browser and Navigate totarget Url
            //driver.get(targetUrl);
            // Enter "Hand Sanitizer" in searchBox WebEdit Field
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("toys");
            // for wait only
            Thread.sleep(3000);
            // Click on search Button
            driver.findElement(By.cssSelector("#nav-search-submit-text > input")).click();
            Thread.sleep(3000);
            //String actualText= driver.findElement(By.xpath("//span[contains(text(),'Drawing Tablet')]")).getText();
            //String actualText= driver.findElement(By.xpath("//span[contains(text(),'Drawing Tablet')]")).getAttribute("dir");
            driver.findElement(By.xpath("//span[contains(text(),'Drawing Tablet')]")).click();
            //
            driver.findElement(By.xpath("//*[@id=\"a-autoid-13-announce\"]/div/div[2]")).click();
            //
            driver.findElement(By.xpath("//*[@id=\"a-autoid-0-announce\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"quantity_2\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"hlb-ptc-btn-native\"]")).click();


            // Validate
            //String expectedText = "\"toys\"";
            //String actualText = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
            //Assert.assertEquals(actualText, expectedText, "Test Fail: Search keyword does not match");
        }


        @AfterMethod
        public void tearDown() {
            //driver.close();
            driver.quit();
        }


    }


}
