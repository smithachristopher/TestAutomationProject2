package Tests;
import Pages.LandingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.security.provider.VerificationProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FilterTest extends BaseClass {


    @Test(priority = 1)
    public void sortPricesByDescendingOrder() {

        LandingPage landingPage = new LandingPage(this.driver);

        WebDriverWait wait = new WebDriverWait(driver, 60);
        driver.findElementByXPath("//*[@data-qa-selector=\"filter-year\"]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-qa-selector=\"select\"]")));
        driver.findElementByXPath("//*[@name=\"yearRange.min\"]").click();

        landingPage.filterYearRange(this.driver);
        landingPage.sortPriceDescending(this.driver);

        // Collect all prices in a list and sort them
        List priceList = landingPage.getPriceList(this.driver);
        List sortedPrices = landingPage.sortdescending(priceList);

        //verfi if original pricelist and sorted pricelist are equal
        Assert.assertEquals(sortedPrices, priceList);
        System.out.println("prices sorted in descending order");
    }
}
