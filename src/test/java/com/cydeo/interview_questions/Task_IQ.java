package com.cydeo.interview_questions;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_IQ extends TestBase {
//    Task IQ :
        @Test
    public void moneyGamingText(){
            //1. Navigate to: https://moneygaming.qa.gameaccount.com/
            driver.get("https://moneygaming.qa.gameaccount.com/");

            //2. Click the JOIN NOW button to open the registration page
            WebElement joinNowBtn = driver.findElement(By.xpath("//a[@href = '/sign-up.shtml']"));
            joinNowBtn.click();

            ////        3. Select a title value from the dropdown
            Select titleDropdown = new Select(driver.findElement(new By.ById("title")));
            titleDropdown.selectByValue("Mrs");

            ////        4. Enter your first name and surname in the form
            WebElement firstNameBox = driver.findElement(By.xpath("//input[@id = 'forename']"));
            firstNameBox.sendKeys("James");

            WebElement surNameBox = driver.findElement(By.xpath("//input[@name = 'map(lastName)']"));
            surNameBox.sendKeys("Bond");

            ////        5. Check the tickbox with text "I accept the Terms and Conditions and certify that I am over the age of 18.
            WebElement tickBox = driver.findElement(By.xpath("//div[@id = 'termsCheckbox']"));
            Assert.assertEquals(tickBox.getText(),"I accept the Terms and Conditions and certify that I am over the age of 18.");

            ////            6. Submit the form by clicking the JOIN NOW button
            WebElement submitBtn = driver.findElement(By.xpath("//input[@id = 'form']"));
            submitBtn.click();

            ////        7. Validate that a validation message with text "This field is required" appears under the date of birth box
            WebElement dobField = driver.findElement(By.xpath("//label[@for = 'dob']"));
            Assert.assertEquals(dobField.getText(),"This field is required");

        }


}
