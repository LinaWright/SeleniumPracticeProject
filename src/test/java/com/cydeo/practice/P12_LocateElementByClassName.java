package com.cydeo.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class P12_LocateElementByClassName {
    public static void main(String[] args) {
        // 1- Setting up webdriver manager
        WebDriverManager.chromedriver().setup();

        //2- Create instance of WebDriver
        WebDriver driver = new ChromeDriver();

        //3- Make the page fullscreen
        driver.manage().window().maximize();

        //4- navigate to google.com
        driver.get("https://www.google.com/");

        //identify and save the "Helpful tips to fact check information online"Element
        WebElement helpfulText = driver.findElement(By.className("NKcBbd"));

        //Verify the "Helpful tips to fact check information online" text appear correctly
        if(helpfulText.getText().equals("Helpful tips to fact check information online")){
            System.out.println("Text appears correctly");
        }else{
            System.out.println("Text does not appear correctly");
        }

        //Close the window
        driver.quit();
    }
}
