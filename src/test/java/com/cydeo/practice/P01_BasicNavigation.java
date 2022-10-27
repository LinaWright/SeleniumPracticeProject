package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
        //1. set up chrome and creat WebDriver instance
        WebDriverManager.chromedriver().setup();

        //2. Creat instance of the chrome driver
        WebDriver driver = new ChromeDriver();

        //driver,get(url)
        driver.get("https://www.google.com/");

        //navigate.to(url) to method is for navigating to web page
        driver.navigate().to("http://www.google.com");

        //It is using for stopping application. We are giving time to application to see steps
        Thread.sleep(3000);

        //navigate.back() to method is for navigating to back from web page
        driver.navigate().back();
        Thread.sleep(3000);

        //navigate().forward() is for navigating to forward from web page
        driver.navigate().forward();

        Thread.sleep(3000);
        //navigate().refresh() method is for refreshing the page
        driver.navigate().refresh();

    }
}
