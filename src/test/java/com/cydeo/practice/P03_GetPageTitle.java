package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03_GetPageTitle {
    public static void main(String[] args) {
        //1. set up chrome and creat WebDriver instance
        WebDriverManager.chromedriver().setup();

        //2. Creat instance of the chrome driver
        WebDriver driver = new ChromeDriver();

        //navigate to google and print out the title
        driver.get("https://cydeo.com");

        String title = driver.getTitle();
        System.out.println("Title pf the page: " + title);

        if(title.equals("Cydeo")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
        driver.quit();
    }
}
