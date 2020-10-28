package HomeWorkOne_20TestCases.AldrinMalakar;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class aldrinMalakar {


    WebDriver driver = null;
    String expediaURL = "https://www.expedia.com/";

    @BeforeMethod
    public void setup() {
        String browserDriverPath = "BrowserDriver/windows/chromedriver.exe";

        //Initializing Chrome Browser
        System.setProperty("webdriver.chrome.driver", browserDriverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(expediaURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //Checking for navigating to correct homepage URL
    @Test(enabled = true)
    public void checkLink() {
        System.out.println("We Are Now Testing 20 Test Cases On: " + driver.getCurrentUrl());
        System.out.println("*****************************************************************");

        String expectedLink = "https://www.expedia.com/";
        String actualLink = driver.getCurrentUrl();

        //Validate Links
        Assert.assertEquals(actualLink, expectedLink, "Test Failed, Link Does Not Match");

    }

    @Test(enabled = true)
    public void mainLogo() {
        //Clicking the main logo on the top left should redirect user to the homepage.
        WebElement element = driver.findElement(By.className("large-logo"));
        element.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Variables
        String expectedLink = "https://www.expedia.com/";
        String actualLink = driver.getCurrentUrl();
        String expectedTitle = "Expedia Travel: Vacation Homes, Hotels, Car Rentals, Flights & More";
        String actualTitle = driver.getTitle();

        //Validate Links
        Assert.assertEquals(actualLink, expectedLink, "Test Failed, Link Does Not Match");
        Assert.assertEquals(actualTitle, expectedTitle, "Title Does not match, Test Failed.");
    }

    @Test(enabled = true)
    public void dropdownMoreTravels() {
        driver.findElement(By.xpath("//div [contains(text(),'More travel')]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String expectedMenuText = "Stays";
        String actualMenuText = driver.findElement(By.linkText("Stays")).getText();
        String expectedMenuText2 = "Things to do";
        String actualMenuText2 = driver.findElement(By.linkText("Things to do")).getText();

        Assert.assertEquals(actualMenuText, expectedMenuText, "Test Failed. Menu could not be located, or did not function as expected.");
        Assert.assertEquals(actualMenuText2, expectedMenuText2, "Test Failed. Menu could not be located, or did not function as expected.");
    }

    @Test(enabled = true)
    public void searchForFlight() throws InterruptedException {
        //Clicking "Stays" Tab to search for hotels.
        driver.findElement(By.xpath("//*[@id='uitk-tabs-button-container']/li[2]")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(@aria-label,'Going to')]")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(15000);

        //d1-btn

    }

    @Test(enabled = true)
    public void registraionPage() throws InterruptedException {
        //click Sign Up to go to registration.
        //driver.findElement(By.xpath("//*[@id='gc-custom-header-nav-bar-acct-menu']/div/div/div/div/div[1]/div/div/a[2]")).click();
        driver.findElement(By.xpath("//a[contains(.,'Sign up, it’s free')]")).click();
        Thread.sleep(2000);


        String expected = "Show us your human side...";
        String actual = driver.findElement(By.xpath("//h1[contains(.,'Show us your human side')]")).getText();

        Assert.assertEquals(actual, expected, "Test Failed. Registration page could not be reached.");


    }

    @Test(enabled = true)
    public void verifyFeedbackPage() {

        driver.findElement(By.xpath("//a[contains(.,'Feedback')]")).click();
        driver.switchTo().window("Feedback");
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());

    }

    @Test(enabled = true)
    public void verifyLoginPage() {

        driver.findElement(By.xpath("//a[contains(text(),'Sign in')]/parent::div")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("submitButton")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Verifying the error message.
        String expected = "Please enter your email address.";
        String actual = driver.findElement(By.xpath("//p[@id='userEmailidError']")).getText();
        Assert.assertEquals(actual, expected, "Test Failed, element wasn't accessible.");

        /**
         * @param: email: fakeemail@gmail.com
         * @param: password: fakePassword1234
         */
        driver.findElement(By.id("signin-loginid")).sendKeys("fakeemail@gmail.com");
        driver.findElement(By.id("signin-password")).sendKeys("fakePassword1234");
        driver.findElement(By.id("submitButton")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Verifying the login page
        String expectedURL = "https://www.expedia.com/user/signin?ckoflag=0&uurl=e3id%3Dredr%26rurl%3D%2F";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Test Failed. Page redirected to wrong URL.");
    }

    @Test(enabled = true)
    public void verifyFlightTab() {
        //Clicking Flights tab should open with Roundtrip as a default choice.
        driver.findElement(By.xpath("//ul[@id='uitk-tabs-button-container']//span[contains(.,'Flights')]")).click();
        String expectedTabText = "Roundtrip";
        String actualTabText = driver.findElement(By.xpath("//span[contains(text(),'Roundtrip')]")).getText();
        Assert.assertEquals(actualTabText, expectedTabText, "Test Failed. Default TAB is not Roundtrip.");

    }

    @Test(enabled = true)
    public void checkChangeRegionFunction() {
        driver.findElement(By.xpath("//*[@id='secondaryNav']/div[2]/button/div")).click();
        driver.findElement(By.linkText("Change language")).click();
        driver.findElement(By.xpath("//label[@for='radio-language-2']")).click();
        driver.findElement(By.xpath("//button[@data-stid='apply-change-language']")).click();
        driver.findElement(By.xpath("//button[@data-stid='picker-submit']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Verify website language is changed to mandarin"
        String expected = "在新冠 (COVID-19) 疫情期间旅行";
        String actual = driver.findElement(By.cssSelector("div[class='all-t-padding-six']")).getText();
        Assert.assertEquals(actual, expected, "Test Failed: Language did not change as expected from Default English to Mandarin.");

    }

    @Test(enabled = true)
    public void checkMobileSignup() throws InterruptedException {
        /**
         * @param: PhoneNumber: 5692456985
         */
        driver.findElement(By.id("phoneNumber")).sendKeys("5692456985");
        driver.findElement(By.id("submitBtn")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectedError = "Please enter a valid phone number.";
        String actualError = driver.findElement(By.id("phoneNumber-error")).getText();

        Assert.assertEquals(actualError, expectedError, "Test Failed: Error Text Not Found As Expected.");


    }

    @Test(enabled = true)
    public void checkVirtualAgentResponse() {
        driver.findElement(By.xpath("//div[@id='cpce-vac-launch']")).click();


    }

    @Test(enabled = true)
    public void navigateToExpediaRewards() {
        driver.findElement(By.xpath("//a[contains(.,'Expedia Rewards')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expected = "Our members save an average of $35 per booking with their points. You can too.";
        String actual = driver.findElement(By.xpath(" //div[@class='heroContentContainer']//p//span")).getText();

        Assert.assertEquals(actual, expected, "Test Faile: Expected Text is different than actual.");
    }

    @Test(enabled = true)
    public void navigateToCarRental() {
        //Verify tab starts with Rental Cars as the default option.
        driver.findElement(By.cssSelector("a[href='?pwaLob=wizard-car-pwa']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement rentalCar = driver.findElement(By.xpath("//button[@aria-label='Pick-up']"));
        rentalCar.sendKeys("SBN");
        rentalCar.sendKeys(Keys.ARROW_DOWN);
        rentalCar.sendKeys(Keys.ENTER);
        rentalCar.sendKeys(Keys.TAB);
        driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String expectedLocation = "South Bend, IN (SBN-South Bend Intl.)";
        String actualLocation = driver.findElement(By.linkText("South Bend, IN (SBN-South Bend Intl.)")).getText();

        Assert.assertEquals(actualLocation, expectedLocation, "Test Failed.");

    }

    @Test(enabled = true)
    public void checkDailyDealsNavigation() {
        driver.findElement(By.id("gc-custom-header-tool-bar-shop-menu")).click();
        driver.findElement(By.cssSelector("nav[id='header-toolbar-nav'] a:nth-child(7)")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Verify that it opened on the right page.
        String expected = "Travel deals + vacation ideas";
        String actual = driver.findElement(By.xpath("//span[contains(.,'deals + vacation')]")).getText();
        Assert.assertEquals(actual, expected, "Test Failed: Landing page is different than expected.");

    }

    @Test(enabled = true)
    public void navigateToDealsAndSearchForComboDeals() throws InterruptedException {
        driver.findElement(By.id("gc-custom-header-tool-bar-shop-menu")).click();
        driver.findElement(By.cssSelector("nav[id='header-toolbar-nav'] a:nth-child(7)")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//a[contains(text(),'Package deals')]")).click();

        //Validate with new URL
        String expectedPackageURL = "https://www.expedia.com/package-deals";
        String actualPackageURL = driver.getCurrentUrl();
        Assert.assertEquals(actualPackageURL, expectedPackageURL, "Test Failed, Link did not match to expectation.");


    }

    @Test(enabled = true)
    public void navigatetoJobSearch() {
        driver.findElement(By.linkText("Jobs")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String expected = "https://lifeatexpediagroup.com/";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected, "Test Failed.");


    }

    @Test(enabled = true)
    public void serarchForJobs() throws InterruptedException {
        driver.findElement(By.linkText("Jobs")).click();
        driver.findElement(By.id("hero_keyword_search_3")).sendKeys("software engineer");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("hero_keyword_search_3")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(5000);

        String expected = "https://lifeatexpediagroup.com/jobs?keyword=software%20engineer";
        String actual = driver.getCurrentUrl();

        Assert.assertEquals(actual, expected, "Test Failed: Search result is not as expected.");

    }

    @Test(enabled = true)
    public void newFeature() throws InterruptedException {

        driver.findElement(By.xpath("//div[@id='editorial-3']//div[@class='uitk-card uitk-grid snippet imagelayout-left-fullbleed uitk-card-with-border']")).click();

        String expectedURL = "https://www.expedia.com/lp/halloween-deals/?rfrr=editorial.undefined.click";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "Test Failed: Link is not found or Promotion is over.");

        String expectedHeader = "Halloween savings";
        String actualHeader = driver.findElement(By.xpath("//h1[contains(text(),'Halloween savings')]")).getText();
        Assert.assertEquals(actualHeader, expectedHeader, "Test Failed.");

    }

    @Test(enabled = true)
    public void testCheckCovidTravelGuide() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//span[contains(text(),'Book with flexibility')]")).click();

        String expected = "https://www.expedia.com/lp/b/coronavirus-travel/flexibility-matters";
        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expected, "Test Failed. Not the correct page or element not found.");
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
