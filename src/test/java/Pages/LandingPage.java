package Pages;

import Tests.BaseClass;
import com.gargoylesoftware.htmlunit.html.ElementFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LandingPage {

    public RemoteWebDriver driver;

    public LandingPageElements elements;

    public class LandingPageElements {

        @FindBy(xpath = "//*[data-qa-selector=\"filter-year\"]")
        public WebElement filterYear;

        @FindBy(xpath = "//*[data-qa-selector=\"yearRange.min\"]")
        public WebElement yearRange;

        @FindBy(xpath = "//*[name=\"sort\"]")
        public WebElement sort;

        @FindBy(xpath = "//*[@data-qa-selector=\"price\"")
        public WebElement price;

    }

    public List<String> getPriceList(RemoteWebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-qa-selector=\"price\"]")));
        List<WebElement> price = driver.findElements(By.xpath("//*[@data-qa-selector=\"price\"]"));
        List<String> prices = new ArrayList<String>();
        for (WebElement e : price)
        {
            prices.add(e.getText());
        }
        List<String> priceList = new ArrayList<String>(prices);
        System.out.println(priceList);
        return prices;
    }


  public List<String> sortdescending(List sortedPrices){

      Collections.sort(sortedPrices, Collections.reverseOrder());
      System.out.println(sortedPrices);

      return sortedPrices;
  }

    public void filterYearRange(RemoteWebDriver driver){
        Select yearRange = new Select(driver.findElementByXPath("//*[@name=\"yearRange.min\"]"));
        //yearRange.selectByVisibleText("2015");
        yearRange.selectByValue("6");
    }

    public void sortPriceDescending(RemoteWebDriver driver){
        Select sort = new Select(driver.findElementByXPath("//*[@name=\"sort\"]"));
        sort.selectByVisibleText("Höchster Preis");
    }

    public void sortPriceAscending(RemoteWebDriver driver){
        Select sort = new Select(driver.findElementByXPath("//*[@name=\"sort\"]"));
        sort.selectByVisibleText("Niedrigster Preis");
    }
    public LandingPage(WebDriver driver) {
        this.elements =new LandingPageElements();
    }
}


