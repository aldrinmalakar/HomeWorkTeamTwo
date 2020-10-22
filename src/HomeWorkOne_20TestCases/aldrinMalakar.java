package HomeWorkOne_20TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class aldrinMalakar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","BrowserDriver/windows/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.udemy.com/");
        System.out.println(driver.getTitle());
        driver.close();
    }
}
