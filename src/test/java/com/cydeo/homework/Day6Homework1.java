package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day6Homework1 {
    //    TC: Etsy checkbox and radio button
//      1. Go to https://www.etsy.com
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.etsy.com ");

//      2. Search for “wooden spoon”
        WebElement searchBox = driver.findElement(By.xpath("//input[@name = 'search_query']"));
        searchBox.sendKeys("wooden spoon");
        searchBox.sendKeys(Keys.ENTER);

//      3. Click on filters
        WebElement filterBtn = driver.findElement(By.xpath("//span[.='All Filters']"));
        filterBtn.click();

//      4. Select free shipping, on sale
        WebElement freeShipping = driver.findElement(By.xpath("//input[@name = 'free_shipping']/following-sibling::label"));
        freeShipping.click();

        WebElement onSale = driver.findElement(By.xpath("//input[@name = 'is_discounted']/following-sibling::label"));
        onSale.click();

//      5. Select under $25 Click on apply filters
        WebElement under25 = driver.findElement(By.xpath("//input[@value = '_25']/following-sibling::label"));
        under25.click();

        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"search-filters-overlay\"]/div/div/div[2]/button[2]"));////button[@type = 'submit'])[4]"
        submitBtn.click();
        Thread.sleep(3000);
//      6. Print count of results
        WebElement results = driver.findElement(By.xpath("//span[@class = 'wt-display-inline-flex-sm']/span"));
        System.out.println(results.getText());
        driver.quit();
    }
}
