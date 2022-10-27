package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04_FullScreenMode {
    public static void main(String[] args) {
        //1. set up chrome and creat WebDriver instance
        WebDriverManager.chromedriver().setup();

        //2. Creat instance of the chrome driver
        WebDriver driver = new ChromeDriver();

        //navigate to google and print out the title
        driver.get("https://cydeo.com");

        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        //getCurrentUrl();
        //Returns string that is current URL on browser
        driver.getCurrentUrl();
    }
}
