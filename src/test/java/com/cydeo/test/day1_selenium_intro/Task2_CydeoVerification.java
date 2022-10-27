package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2_CydeoVerification {
    public static void main(String[] args) {
        // 1- Setting up webdriver manager
        WebDriverManager.chromedriver().setup();

        //2- Create instance of WebDriver
        WebDriver driver = new ChromeDriver();

        //3- Make the page fullscreen
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        String currentURL = driver.getCurrentUrl(); // it comes from selenium
        String expectedURL = "cydeo"; // it comes from requirement

        if(currentURL.contains(expectedURL)){
            System.out.println("URL verification is passed");
        }else{
            System.out.println("URL verification is failed");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Title verification passed");
        }else{
            System.out.println("Title verification failed");
        }

        driver.quit();
    }
    /*
    TC #1: Cydeo practice tool verifications
1. Open Chrome browser
2. Go to https://practice.cydeo.com
            3. Verify URL contains
    Expected: cydeo
4. Verify title:
    Expected: Practice

     */
}
