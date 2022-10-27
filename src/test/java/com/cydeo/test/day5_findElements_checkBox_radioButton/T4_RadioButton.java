package com.cydeo.test.day5_findElements_checkBox_radioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T4_RadioButton {
    public static void main(String[] args) {
//        TC #2: Radiobutton handling
//        1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

//        3. Click to “Hockey” radio button
        WebElement HockeyRadioButton = driver.findElement(By.xpath("//input[@id = 'hockey']"));
        HockeyRadioButton.click();

//        4. Verify “Hockey” radio button is selected after clicking.
        System.out.println("HockeyRadioButton.isSelected() = " + HockeyRadioButton.isSelected());

//        5.locate Green Button
        WebElement GreenButton = driver.findElement(By.xpath("//input[@id = 'green']"));

//        6.Verify if it is Enabled
        System.out.println("GreenButton.isEnabled() = " + GreenButton.isEnabled());

//        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

        driver.quit();
    }
}
