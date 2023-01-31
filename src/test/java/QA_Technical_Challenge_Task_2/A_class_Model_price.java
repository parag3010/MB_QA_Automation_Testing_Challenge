package QA_Technical_Challenge_Task_2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class A_class_Model_price extends Base {


    @BeforeMethod
    public void test_setup() {
        //open browser
        WebDriverManager.chromedriver().setup(); //set up chromedrivers
        driver = new ChromeDriver(); //driver instance created to access methods of WebDriver for chrome browser
        //WebDriver driver = new FirefoxDriver(); //For Firefox
        driver.manage().window().maximize(); //maximize window
        driver.get("https://www.mercedes-benz.co.uk"); //go to the link

    }


    @Test
    public void TestCase1() throws Exception {


        JavascriptExecutor jser = (JavascriptExecutor) driver; //create an Interface through which driver can execute JavaScript.
        Thread.sleep(2000);

        //Accept cookies
        //store the return as element  provided by jser after executing javascript
        WebElement agree_button = (WebElement) jser.executeScript("return document.querySelector(\"body > cmm-cookie-banner\").shadowRoot.querySelector(\"div > div > div.cmm-cookie-banner__content > cmm-buttons-wrapper > div > div > button.wb-button.wb-button--primary.wb-button--small.wb-button--accept-all\")");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit wait
        jser.executeScript("arguments[0].click();", agree_button); //Perform click action on returned webelement

        //mouse hover to hatchbacks -- Alternative method to access shadow dom element
        SearchContext shadow = driver.findElement(By.cssSelector("dh-io-vmos[class='webcomponent aem-GridColumn aem-GridColumn--default--12']")).getShadowRoot(); //get shadow root
        WebElement hb = shadow.findElement(By.cssSelector(" div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(1) > section:nth-child(2) > button:nth-child(5) > span:nth-child(1)"));
        Actions action = new Actions(driver);
        action.moveToElement(hb).perform();
        hb.click();

        WebElement A_class = (WebElement) jser.executeScript("return document.querySelector(\"body > div.root.responsivegrid > div > div.responsivegrid.aem-GridColumn.aem-GridColumn--default--12 > div > dh-io-vmos\").shadowRoot.querySelector(\"div.dh-io-vmos_3dj27.dh-io-vmos_1_SKc.wb-new-colors > div > div > div > div > div > div:nth-child(4) > section > div > div > div:nth-child(1) > div > a\")");
        jser.executeScript("arguments[0].click();", A_class);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement build_car = (WebElement) jser.executeScript("return document.querySelector(\"body > div.root.responsivegrid > div > div.responsivegrid.aem-GridColumn.aem-GridColumn--default--12 > div > owc-stage\").shadowRoot.querySelector(\"div > div.owc-stage__content-wrapper > div > div.owc-stage__cta-wrapper.wb-grid-row > div > div > a.owc-stage-cta-buttons__button.wb-button.wb-button--medium.wb-button--theme-dark.wb-button--large.wb-button--secondary.owc-stage-cta-buttons__button--secondary\")");
        jser.executeScript("arguments[0].click();", build_car);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //wait for loading the page
        SearchContext page = driver.findElement(By.cssSelector("owcc-car-configurator[class='webcomponent aem-GridColumn aem-GridColumn--default--12']")).getShadowRoot();
        Thread.sleep(1000);
        WebElement load = page.findElement(By.cssSelector(".wb-360-viewer__overlay"));
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(load));


        scroll("0,800");
        SearchContext shadow2 = driver.findElement(By.cssSelector("owcc-car-configurator[class='webcomponent aem-GridColumn aem-GridColumn--default--12']")).getShadowRoot();
        Thread.sleep(1000);
        shadow2.findElement(By.cssSelector(".wb-multi-select-control__button")).click();


        WebElement filter = (WebElement) jser.executeScript("return document.querySelector(\"body > div.root.responsivegrid > div > div.responsivegrid.aem-GridColumn.aem-GridColumn--default--12 > div > owcc-car-configurator\").shadowRoot.querySelector(\"#cc-app-container-main > div.cc-app-container__main-frame.cc-grid-container > div.cc-grid-container.ng-star-inserted > div > div:nth-child(2) > cc-motorization > cc-motorization-filters > cc-motorization-filters-form > form > div > div.cc-motorization-filters-form__primary > div.cc-motorization-filters-form__primary-filters.ng-star-inserted > cc-motorization-filters-primary-filters > div > fieldset > wb-multi-select-control > button\")");
        //jser.executeScript("arguments[0].click();",filter);


        WebElement diesel = (WebElement) jser.executeScript("return document.querySelector(\"body > div.root.responsivegrid > div > div.responsivegrid.aem-GridColumn.aem-GridColumn--default--12 > div > owcc-car-configurator\").shadowRoot.querySelector(\"#cc-app-container-main > div.cc-app-container__main-frame.cc-grid-container > div.cc-grid-container.ng-star-inserted > div > div:nth-child(2) > cc-motorization > cc-motorization-filters > cc-motorization-filters-form > form > div > div.cc-motorization-filters-form__primary > div.cc-motorization-filters-form__primary-filters.ng-star-inserted > cc-motorization-filters-primary-filters > div > fieldset > wb-multi-select-control > div > div > wb-checkbox-control:nth-child(1) > label > input\")");
        jser.executeScript("arguments[0].click();",diesel);
        jser.executeScript("arguments[0].click();",filter);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);



/*      //compare prices: Was not working as expected
        Thread.sleep(1000);
        SearchContext shadow2 = driver.findElement(By.cssSelector("owcc-car-configurator[class='webcomponent aem-GridColumn aem-GridColumn--default--12']")).getShadowRoot();
        Thread.sleep(1000);
        List<WebElement> elements = (List<WebElement>) shadow2.findElement(By.cssSelector(" div:nth-child(3) > cc-app-container:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > cc-motorization:nth-child(2) > cc-motorization-comparison:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > wb-card:nth-child(1) > div:nth-child(1) > cc-motorization-header:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > span:nth-child(1)"));
        //List<WebElement> prices = (List<WebElement>) jser.executeScript("return document.querySelector(\"body > div.root.responsivegrid > div > div.responsivegrid.aem-GridColumn.aem-GridColumn--default--12 > div > owcc-car-configurator\").shadowRoot.querySelector(\"#cc-app-container-main > div.cc-app-container__main-frame.cc-grid-container > div.cc-grid-container.ng-star-inserted > div > div:nth-child(2) > cc-motorization > cc-motorization-comparison > div > div\")");


*/

    }

    @AfterMethod
    public void test_teardown() throws Exception {

        //Take Screenshot
        SearchContext shadow = driver.findElement(By.cssSelector("owcc-car-configurator[class='webcomponent aem-GridColumn aem-GridColumn--default--12']")).getShadowRoot();
        WebElement e = shadow.findElement(By.cssSelector(".cc-motorization-comparison-wrapper"));
        File file = e.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("C:\\Parag\\Testing\\ss.png"));

        //pricetxt(); Not working as expected

    }


}

