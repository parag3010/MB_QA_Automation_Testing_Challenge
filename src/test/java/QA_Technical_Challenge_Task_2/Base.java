package QA_Technical_Challenge_Task_2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.FileWriter;
import java.util.List;


public class Base {
    public static WebDriver driver;


    protected void scroll(String script )throws Exception {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(" + script +")");
    }

    protected void pricetxt() throws Exception{
        //Find and store the highest and lowest price
        //SearchContext shadow = driver.findElement(By.cssSelector("owcc-car-configurator[class='webcomponent aem-GridColumn aem-GridColumn--default--12']")).getShadowRoot();
        //String lowestprice = shadow.findElement(By.cssSelector(" div:nth-child(3) > cc-app-container:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > cc-motorization:nth-child(2) > cc-motorization-comparison:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > wb-card:nth-child(1) > div:nth-child(1) > cc-motorization-header:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > span:nth-child(1)")).getText();
        //String highestprice = shadow.findElement(By.cssSelector(" div:nth-child(3) > cc-app-container:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > cc-motorization:nth-child(2) > cc-motorization-comparison:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > wb-card:nth-child(1) > div:nth-child(1) > cc-motorization-header:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1)")).getText();


        SearchContext shadow = driver.findElement(By.cssSelector("owcc-car-configurator[class='webcomponent aem-GridColumn aem-GridColumn--default--12']")).getShadowRoot();
        //String cssSelectorForHost1 = "owcc-car-configurator[class='webcomponent aem-GridColumn aem-GridColumn--default--12']";
        List<WebElement> price_list = (List<WebElement>) shadow.findElement(By.cssSelector(".cc-motorization-comparison-wrapper"));

        String all_prices;
        int prices;
        //HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
        for(int i=0;i<price_list.size();i++) {
            all_prices = price_list.get(i).getText();//Iterate and fetch product price
            prices = Integer.parseInt(all_prices.replaceAll("[^0-9]", ""));//Replace anything wil space other than numbers
            FileWriter pricestxt = new FileWriter("C:\\Parag\\Testing\\prices.txt");
            pricestxt.write(prices);
            pricestxt.close();

        }


   }
    public static int getMax(int[] inputArray){
        int maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    // Method for getting the minimum value
    public static int getMin(int[] inputArray){
        int minValue = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
            }
        }
        return minValue;
    }



}
