package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P08_LocateElementByTagName {
    public static void main(String[] args) {
        // 1- Setting up webdriver manager
        WebDriverManager.chromedriver().setup();

        //2- Create instance of WebDriver
        WebDriver driver = new ChromeDriver();

        //3- Make the page fullscreen
        driver.manage().window().maximize();

        //4- navigate to
        driver.get("https://practice.cydeo.com");

        //identify and save the "Text Automation" element
        WebElement text = driver.findElement(By.tagName("h1"));

        //print out the text
        System.out.println(text.getText());

        //Close the window
        driver.quit();
    }
}
