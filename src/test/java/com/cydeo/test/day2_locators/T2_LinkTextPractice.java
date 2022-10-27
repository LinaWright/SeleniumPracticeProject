package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTextPractice {
    public static void main(String[] args) {
        //TC #2: Back and forth navigation
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        //3- Click to A/B Testing from top of the list.
        WebElement ABLinkText = driver.findElement(By.linkText("A/B Testing")); //Always storing element in WebElement
        ABLinkText.click();

        //4- Verify title is:
        //  Expected: No A/B Test
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("No A/B Test Title verification passed!");
        }else{
            System.out.println("No A/B Test Title verification failed!");
        }

        //5- Go back to home page by using the .back();
        driver.navigate().back();

        //6- Verify title equals: Expected: Practice
        expectedTitle = "Practice"; //reassign
        actualTitle = driver.getTitle(); //reassign
        if(expectedTitle.equals(actualTitle)){
            System.out.println("Practice Title verification passed!");
        }else{
            System.out.println("Practice Title verification failed!");
        }

        driver.quit();
    }
}


