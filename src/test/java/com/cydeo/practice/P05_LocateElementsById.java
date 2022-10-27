package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P05_LocateElementsById {
    public static void main(String[] args) {
        // 1- Setting up webdriver manager
        WebDriverManager.chromedriver().setup();

        //2- Create instance of WebDriver
        WebDriver driver = new ChromeDriver();

        //3- Make the page fullscreen
        driver.manage().window().maximize();

        //4- navigate to google.com
        driver.get("https://www.google.com/");

        //identify"I'm feeling lucky" element and save the element
        WebElement luckText = driver.findElement(By.id("gbqfbb"));

        //find value of attribute
        String text = luckText.getAttribute("value");

        //verify if value is "I'm feeling lucky"
        if(text.equals("I'm Feeling Lucky")){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        //Close the window
        driver.quit();
    }
}
