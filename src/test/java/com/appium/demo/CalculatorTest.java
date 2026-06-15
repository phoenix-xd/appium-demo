package com.appium.demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URI;
import java.time.Duration;

public class CalculatorTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android");
        options.setUdid("emulator-5554");

        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        options.setNoReset(true);
        options.setNewCommandTimeout(Duration.ofSeconds(300));

        driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723").toURL(),
                options);
    }

    @Test
    public void verifyAddition() {

        driver.findElement(
                By.id("com.google.android.calculator:id/digit_2"))
                .click();

        driver.findElement(
                By.id("com.google.android.calculator:id/op_add"))
                .click();

        driver.findElement(
                By.id("com.google.android.calculator:id/digit_3"))
                .click();

        driver.findElement(
                By.id("com.google.android.calculator:id/eq"))
                .click();

        String result = driver.findElement(
                By.id("com.google.android.calculator:id/result_final"))
                .getText();

        Assert.assertEquals(result, "5");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}