package com.cydeo.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day2Homework3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/inputs");
        WebElement home = driver.findElementByClassName("nav-link");
        home.click();

        String exceptedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(exceptedTitle.equals(actualTitle)){
            System.out.println("Title verify test passed!");
        }else{
            System.out.println("Title verify test failed!");
        }
        driver.quit();
    }
}
/*
TC #4: Practice Cydeo – Class locator practice
1- Open a chrome browser
2- Go to: https://practice.cydeo.com/inputs
3- Click to “Home” link
4- Verify title is as expected:
Expected: Practice

PS: Locate “Home” link using “className” locator

 */