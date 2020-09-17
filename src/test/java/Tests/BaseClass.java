package Tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.Reporter;

import java.io.File;

public class BaseClass {

    public RemoteWebDriver driver;


    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP PC\\Documents\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.autohero.com/de/search/");
        driver.manage().window().maximize();
}

    @AfterTest
    public void teardown(){

        try{
            driver.quit();
            System.out.println("driver quit");
        }
        catch(Exception e)
        {

        }
    }
}
