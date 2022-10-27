package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T3_CheckBoxes {
    public static void main(String[] args) {
//        Practice: Checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//        1. Go to http://practice.cydeo.com/checkboxes
        driver.get("http://practice.cydeo.com/checkboxes");

//        2. Confirm checkbox #1 is NOT selected by default
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@id = 'box1']"));
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());

//        if(!checkBox1.isSelected()){
//            System.out.println("CheckBox 1 verification is " + checkBox1.isSelected());
//        }else{
//            System.out.println("CheckBox 1 verification is " + checkBox1.isSelected());
//        }

//        3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id = 'box2']"));
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

//        4. Click checkbox #1 to select it.
        checkBox1.click();

//        5. Click checkbox #2 to deselect it.
        checkBox2.click();

//        6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkBox1.isSelected() = " + checkBox1.isSelected());

//        7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkBox2.isSelected() = " + checkBox2.isSelected());

        driver.quit();
    }
}
