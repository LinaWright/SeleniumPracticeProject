package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_Navigations {
    public static void main(String[] args) throws InterruptedException {
        //1. set up chrome and creat WebDriver instance
        WebDriverManager.chromedriver().setup();

        //2. Creat instance of the chrome driver
        WebDriver driver = new ChromeDriver();

        //driver,get(url)
        driver.get("https://www.google.com/");

        //3. Make our page full screen
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

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

        //driver.getTitle() getting the title of the current page
        driver.get("https://www.tesla.com");
        System.out.println("Tesla page driver.getTitle() = " + driver.getTitle());

        //getCurrentUrl(); Returns string that is current URL on browser
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        //closing any current tab
        driver.close();

        //close all browser window opened by driver
        driver.quit();
    }
}
