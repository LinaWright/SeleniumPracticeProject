package com.cydeo.test.day17_pom_syncronization;

import com.cydeo.pages.DynamicallyLoadedPage7;
import com.cydeo.test.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicallyLoadedTest {
    @Test
    public void dynamically_loaded_test7(){
        //        TC#4 : Dynamically Loaded Page Elements 7
//    1. Go to https://practice.cydeo.com/dynamic_loading/7
        Driver.getDriver().get("Go to https://practice.cydeo.com/dynamic_loading/7");

        DynamicallyLoadedPage7 dynamicallyLoadedPage7 = new DynamicallyLoadedPage7();
//    2. Wait until title is “Dynamic title”

//    3. Assert: Message “Done” is displayed.
        Assert.assertEquals(dynamicallyLoadedPage7.doneMsg.getText(),"Done!");

//    4. Assert: Image is displayed.
        Assert.assertTrue(dynamicallyLoadedPage7.image.isDisplayed());
//    Note: Follow POM
    }
}
