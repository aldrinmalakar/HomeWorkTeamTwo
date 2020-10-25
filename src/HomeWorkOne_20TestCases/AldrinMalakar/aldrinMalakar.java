package HomeWorkOne_20TestCases.AldrinMalakar;

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
    String expediaURL = "https://www.expedia.com/";

    @BeforeMethod (alwaysRun = true)
    public void setup() {
        String browserDriverPath = "BrowserDriver/windows/chromedriver.exe";

        //Initializing Chrome Browser
        System.setProperty("webdriver.chrome.driver", browserDriverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    //Checking for navigating to correct homepage URL
    @Test(enabled = true)
    public void checkLink() throws InterruptedException {

        driver.get(expediaURL);
        System.out.println("We Are Now Testing: " + driver.getCurrentUrl());

        String expectedLink = "https://www.expedia.com/";
        String actualLink = driver.getCurrentUrl();

        //Validate Links
        Assert.assertEquals(actualLink, expectedLink, "Test Failed, Link Does Not Match");
        Thread.sleep(5000);

    }

    @Test(enabled = false)
    public void mainLogo(){

    }
    @Test(enabled = false)
    public void dropdownMoreTravels(){

    }
    @Test(enabled = false)
    public void searchForHotel(){

    }
    @Test(enabled = false)
    public void searchForFlight(){

    }
    @Test(enabled = false)
    public void registraionPage(){

    }
    @Test(enabled = false)
    public void verifyBlankRegistrationPage(){

    }
    @Test(enabled = false)
    public void verifyRequiredFields(){

    }
    @Test(enabled = false)
    public void verifyFlightSearchBeginswithOneWayTrip(){

    }
    @Test(enabled = false)
    public void checkChangeRegionFunction(){

    }
    @Test(enabled = false)
    public void checkMobileSignup(){

    }
    @Test(enabled = false)
    public void checkVirtualAgentResponse(){

    }

    @Test(enabled = false)
    public void checkSupportPageNavigationfromHomepage(){

    }
    @Test(enabled = false)
    public void checkRentalCarFunction(){

    }
    @Test(enabled = false)
    public void checkDailyDealsNavigation(){

    }
    @Test(enabled = false)
    public void navigateToDealsAndSearchForComboDeals(){

    }
    @Test(enabled = false)
    public void navigatetoJobSearch(){

    }
    @Test(enabled = false)
    public void serarchForJobs(){

    }
    @Test(enabled = false)
    public void checkIdeasForYourNextTrip(){

    }
    @Test(enabled = false)
    public void checkNearbyVacationRentals(){

    }


    @AfterMethod (alwaysRun = true)
    public void tearDown() {
        driver.close();
    }

}
