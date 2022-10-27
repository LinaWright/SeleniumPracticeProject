package com.cydeo.homework;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task_GasMileage extends TestBase {

    //    Task #: Gas Mileage Calculator Automation Test
    @Test
    public void gasMileage() {
//        1. Add a new class GasMileageCalculatorTest
//        2. Go to https://www.calculator.net
        driver.get("https://www.calculator.net");

//        3. Search for “gas mileage” using search box
        WebElement searchBox = driver.findElement(By.id("calcSearchTerm"));
        searchBox.sendKeys("gas mileage" + Keys.ENTER);

//        4. Click on the “Gas Mileage Calculator” link
        WebElement gasMileageCalculator = driver.findElement(By.linkText("Gas Mileage Calculator"));
        gasMileageCalculator.click();

//        5. On Next page verify:
//            a. Title equals: “Gas Mileage Calculator”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Gas Mileage Calculator";
        Assert.assertEquals(actualTitle, expectedTitle);

//            b. “Gas Mileage Calculator” label is displayed
        WebElement calculatorLabel = driver.findElement(By.xpath("//*[@id=\"content\"]/h1"));
        calculatorLabel.isDisplayed();

//        6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdometer = driver.findElement(By.id("uscodreading"));
        currentOdometer.clear();
        currentOdometer.sendKeys("7925");

//        7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometer = driver.findElement(By.id("uspodreading"));
        previousOdometer.clear();
        previousOdometer.sendKeys("7550");

//        8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAdded = driver.findElement(By.id("usgasputin"));
        gasAdded.clear();
        gasAdded.sendKeys("16");

//        9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = driver.findElement(By.id("usgasprice"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

//        10. Click on Calculate button
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

//        11. Verify mpg value is as expected:
//            Expected value: “23.44 mpg”
        WebElement mileage = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/font/b"));
        String actualValue = mileage.getText();
        String expectedValue= "23.44 mpg";
        Assert.assertEquals(actualValue, expectedValue);
    }


}
