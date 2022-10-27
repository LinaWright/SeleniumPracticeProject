package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2Homework1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://google.com");
        WebElement gmail = driver.findElement(By.className("gb_d"));
        gmail.click();

        String exceptedGmailTile = "Gmail";
        String actualGmailTitle = driver.getTitle();

        if(actualGmailTitle.contains(exceptedGmailTile)){
            System.out.println("Gmail title test passed");
        }else{
            System.out.println("Gmail title test failed");
        }
        Thread.sleep(5000);
        driver.navigate().back();
        String exceptedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();
        Thread.sleep(5000);
        if(exceptedGoogleTitle.equals(actualGoogleTitle)){
            System.out.println("Google title test passed");
        }else{
            System.out.println("Google title test failed");
        }

        driver.quit();
    }
}
    /*
    TC #3: Back and forth navigation
    1- Open a chrome browser
    2- Go to: https://google.com
    3- Click to Gmail from top right.
    4- Verify title contains:
      Expected: Gmail
    5- Go back to Google by using the .back();
    6- Verify title equals:
      Expected: Google
     */