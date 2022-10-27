package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day6Homework2 {

//    TC #6: StaleElementReferenceException Task
public static void main(String[] args) {
//    1. Open a Chrome browser
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

//    2. Go to: https://practice.cydeo.com/abtest
    driver.get("https://practice.cydeo.com/abtest");

//    3. Locate “CYDEO” link, verify it is displayed.
    WebElement CYDEO = driver.findElement(By.xpath("//a[@ href=\"https://cydeo.com/\"]"));
    CYDEO.isDisplayed();

//    4. Refresh the page.
    driver.navigate().refresh();

//    5. Verify it is displayed, again.

    try {
        WebElement CydeoLinkDisplayed = driver.findElement(By.xpath("//a[@target ='_blank']"));
        CYDEO.isDisplayed();

    } catch(StaleElementReferenceException e){

        System.out.println("Stale Element Reference Exception is thrown!");

    }


    driver.close();
}
}
