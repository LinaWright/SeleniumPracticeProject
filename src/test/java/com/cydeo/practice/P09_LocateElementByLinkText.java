package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P09_LocateElementByLinkText {
    public static void main(String[] args) {
        // 1- Setting up webdriver manager
        WebDriverManager.chromedriver().setup();

        //2- Create instance of WebDriver
        WebDriver driver = new ChromeDriver();

        //3- Make the page fullscreen
        driver.manage().window().maximize();

        //4- navigate to google.com
        driver.get("https://www.google.com/");

        //identify and save the About element link on the top
        WebElement aboutLink = driver.findElement(By.linkText("About"));

        //Click on the link
        aboutLink.click();

        //Close the window
        driver.quit();

    }
}
