package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Guru_Upload_Test {
    @Test
    public void upload_file_test() throws InterruptedException {

//            TC : Guru99 Upload Test
//
//    1. Go to  “https://demo.guru99.com/test/upload”
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99.upload.url"));

//    2. Upload file into Choose File
        WebElement chooseFile = Driver.getDriver().findElement(By.id("uploadfile_0"));
        String path = "C:\\Users\\linal\\Downloads\\some-file.txt";
        //We do not click on choose file element, because it'll open our browser window which is coming from our machine and selenium will nor handle it, that is why after we locate the choose file element we just use sendkeys method ro send path
        chooseFile.sendKeys(path);

//    3. Click terms of service check box
        WebElement termsOfService = Driver.getDriver().findElement(By.id("terms"));
        termsOfService.click();

//    4. Click Submit File button
        WebElement submitBtn = Driver.getDriver().findElement(By.id("submitbutton"));
        submitBtn.click();

//    5. Verify expected message appeared. Expected: “1 file
//    has been successfully uploaded.”
        WebElement resultMessage = Driver.getDriver().findElement(By.id("res"));
        String actualResult = resultMessage.getText();
        String exceptedResult = "1 file\nhas been successfully uploaded.";
        Thread.sleep(5000);
        Assert.assertEquals(actualResult,exceptedResult);

        Driver.closeDriver();

    }
}
