package com.cydeo.test.day6_StaleElement_TestNG;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {
//BeforeClass will be running before all test method
    @BeforeClass
    public void setup(){
        System.out.println("Before class is running");
    }

//AfterClass will be running after all test method
    @AfterClass
    public void tearDown(){
        System.out.println("After class is running");
    }

//BeforeMethod will be running before each test method
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before Method is running");
    }

//AfterMethod will be running after each test method
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After Method is running");
    }

    @Test (priority = 2)
    public void test1(){
        System.out.println("Test1 is running");
        String actual = "apple";
        String except = "apple";

        Assert.assertEquals(actual, except, "Test did not pass!" ); //Message is optional it'll appear if it's failed
    }

    @Test (priority = 1, dependsOnMethods = "test1" )
    public void test2(){
        System.out.println("Test2 is running");
        Assert.assertEquals("orange","orange","test2 did not pass");
    }
}
