package com.cydeo.test.day9_alert_iframe;

import com.cydeo.base.TestBase;
import org.testng.annotations.Test;

public class NestedIframe extends TestBase {
    @Test
    public void iFrameTest () throws InterruptedException {
        driver.get("https://practice.cydeo.com/nested_frames");
Thread.sleep(3000);
        driver.switchTo().frame("frame-left");;
        Thread.sleep(3000);

        driver.switchTo().parentFrame();
        Thread.sleep(3000);

        driver.switchTo().frame(2);
        Thread.sleep(3000);
    }
}
