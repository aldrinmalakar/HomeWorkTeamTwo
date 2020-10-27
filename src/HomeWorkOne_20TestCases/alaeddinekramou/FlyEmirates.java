package HomeWorkOne_20TestCases.alaeddinekramou;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FlyEmirates {

    public String url = "https://www.emirates.com/us/english/";
    public String expected;
    public String actual;
    public WebDriver fd;

    @BeforeTest
    public void launchbrowser() {
        System.setProperty("webdriver.chrome.driver", "BrowserDriver/windows/chromedriver.exe");
        fd = new ChromeDriver();
        fd.get(url);
    }

    @BeforeMethod
    public void verifytitle() throws InterruptedException {
        expected = "Emirates flights – Book a flight, browse our flight offers and explore the Emirates Experience";
        Thread.sleep(5000);
        actual = fd.getTitle();
        Assert.assertEquals(actual, expected);
        System.out.println(actual);
        Thread.sleep(5000);
    }

    @Test
    public void departure() throws InterruptedException {
//        fd.findElement(By.xpath("//body/form[@id='aspnetForm']/div[2]/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/eol-airport-select[1]/div[1]/i[1]")).click();
        fd.findElement(By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]")).click();
//        fd.findElement(By.xpath("//body/form[@id='aspnetForm']/div[2]/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/eol-airport-select[1]/div[2]/div[1]/section[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/div[5]")).click();
        expected = "Boston,";
        actual = fd.findElement(By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/ol[1]/li[1]/div[1]/div[1]/p[1]/span[1]")).getText();
        Assert.assertEquals(actual, expected);
        System.out.println(actual);
//        Thread.sleep(5000);

    }


    @Test
    public void Arrival() throws InterruptedException {
        fd.findElement(By.name("Arrival Airport")).sendKeys("Algeria");
        Thread.sleep(5000);
        fd.findElement(By.xpath("//*[@id=\"panel0\"]/div/div/div/div[2]/section/div[4]/div[1]/div[4]/a/span")).click();
        expected = "";
        actual = fd.findElement(By.name("Arrival Airport")).getText();
        Assert.assertEquals(actual, expected);
        System.out.println(actual);
        Thread.sleep(5000);
    }

    @Test
    public void Date() throws InterruptedException {
        //select departing and arrival Date
        fd.findElement(By.xpath("//*[@id=\"panel0\"]/div/div/div/div[2]/section/div[4]/div[1]/div[3]/eol-datefield/eol-calendar/div/div/div[3]/table/tbody/tr[2]/td[3]/a")).click();
        fd.findElement(By.xpath("//*[@id=\"panel0\"]/div/div/div/div[2]/section/div[4]/div[1]/div[3]/eol-datefield/eol-calendar/div/div/div[2]/table/tbody/tr[5]/td[7]/a")).click();
        Thread.sleep(5000);
    }

    @Test
    public void passengers() throws InterruptedException {
        fd.findElement(By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).isDisplayed();
        fd.findElement(By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[2]/section[1]/div[1]/button[1]")).isDisplayed();
        Thread.sleep(5000);
        expected = "";
        actual = fd.findElement(By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).getText();
        Assert.assertEquals(actual, expected);
        System.out.println(actual);
        Thread.sleep(5000);
    }

    @Test
    public void economyClass() throws InterruptedException {
        fd.findElement(By.id("search-flight-class")).isDisplayed();
        Thread.sleep(5000);
        fd.findElement(By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[4]/div[2]/div[2]/div[1]/div[1]/div[2]/section[1]/a[1]/p[1]")).isDisplayed();
        expected = "";
        actual = fd.findElement(By.xpath("//body/main[@id='maincontent']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/section[1]/div[4]/div[2]/div[2]/div[1]/div[1]/div[2]/section[1]/a[1]")).getText();
        Assert.assertEquals(actual, expected);
        System.out.println(actual);
        Thread.sleep(5000);
    }

    @Test
    public void searchFlight() throws InterruptedException {
        fd.findElement(By.xpath("//*[@id='panel0']/div/div/div/div[2]/section/div[4]/div[2]/div[3]/form/button")).submit();
        Thread.sleep(5000);
        expected = "Book a flight";
        actual = fd.findElement(By.id("ctl00_c_pH_heading1")).getText();
        Assert.assertEquals(actual, expected);
        System.out.println(actual);

    }


    @AfterTest
    public void close() {
        fd.quit();
    }
}
