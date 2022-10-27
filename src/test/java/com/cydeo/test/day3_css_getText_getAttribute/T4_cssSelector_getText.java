package com.cydeo.test.day3_css_getText_getAttribute;

import com.cydeo.test.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) {
//        TC #4: NextBaseCRM, locators, getText(), getAttribute() practice
//        1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

//        2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

//        3- Verify “Reset password” button text is as expected:
//        Expected: Reset password
        WebElement resetPasswordBtn = driver.findElement(By.cssSelector("button.login-btn"));
        //Same as WebElement resetPasswordBtn = driver.findElement(By.cssSelector("button[class='login-btn']"));
        //Same as WebElement resetPasswordBtn = driver.findElement(By.cssSelector("button[value = 'Reset password']"));
        //Same as WebElement resetPasswordBtn = driver.findElement(By.cssSelector("button[value = 'Reset password']"));

        String expected = "Reset password";
        String actual = resetPasswordBtn.getAttribute("value");
        //Same as String actual = resetPasswordBtn.getText(); <-- better
        if(expected.equals(actual)){
            System.out.println("Reset password button text test passed!");
        }else{
            System.out.println("Reset password button text test failed!");
        }

        driver.quit();

//        PS: Inspect and decide which locator you should be using to locate web
//        elements.
//                PS2: Pay attention to where to get the text of this button from
    }

}
