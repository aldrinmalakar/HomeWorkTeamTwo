package HomeWorkOne_20TestCases.AldrinMalakar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        driver.get(expediaURL);

    }

    //Checking for navigating to correct homepage URL
    @Test(enabled = true)
    public void checkLink(){
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
        Assert.assertEquals(actualTitle,expectedTitle,"Title Does not match, Test Failed.");
    }

    @Test(enabled = true)
    public void dropdownMoreTravels() {
        driver.findElement(By.xpath("//div [contains(text(),'More travel')]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String expectedMenuText = "Stays";
        String actualMenuText = driver.findElement(By.linkText("Stays")).getText();
        String expectedMenuText2 = "Things to do";
        String actualMenuText2 = driver.findElement(By.linkText("Things to do")).getText();

        Assert.assertEquals(actualMenuText,expectedMenuText,"Test Failed. Menu could not be located, or did not function as expected.");
        Assert.assertEquals(actualMenuText2,expectedMenuText2,"Test Failed. Menu could not be located, or did not function as expected.");
    }

    @Test(enabled = true)
    public void searchForFlight() throws InterruptedException {
        //Clicking "Stays" Tab to search for hotels.
        driver.findElement(By.xpath("//*[@id='uitk-tabs-button-container']/li[2]")).click();

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[contains(@aria-label,'Going to')]")).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(15000);

        //d1-btn

    }

    @Test(enabled = true)
    public void registraionPage() {
        driver.findElement(By.xpath("//div[contains(text(),'Sign in')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Sign up, it’s free')]")).click();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        String expected = "Show us your human side...";
        String actual = driver.findElement(By.xpath("//h1[contains(.,'Show us your human side')]")).getText();

        Assert.assertEquals(actual,expected,"Test Failed. Registration page could not be reached.");



    }

    @Test(enabled = false)
    public void verifyBlankRegistrationPage() {

    }

    @Test(enabled = false)
    public void verifyRequiredFields() {

    }

    @Test(enabled = false)
    public void verifyFlightSearchBeginswithOneWayTrip() {

    }

    @Test(enabled = false)
    public void checkChangeRegionFunction() {

    }

    @Test(enabled = false)
    public void checkMobileSignup() {

    }

    @Test(enabled = false)
    public void checkVirtualAgentResponse() {

    }

    @Test(enabled = false)
    public void checkSupportPageNavigationfromHomepage() {

    }

    @Test(enabled = false)
    public void checkRentalCarFunction() {

    }

    @Test(enabled = false)
    public void checkDailyDealsNavigation() {

    }

    @Test(enabled = false)
    public void navigateToDealsAndSearchForComboDeals() {

    }

    @Test(enabled = false)
    public void navigatetoJobSearch() {

    }

    @Test(enabled = false)
    public void serarchForJobs() {

    }

    @Test(enabled = false)
    public void checkIdeasForYourNextTrip() {

    }

    @Test(enabled = false)
    public void checkNearbyVacationRentals() {

    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

}
