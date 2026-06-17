package com.appium.demo;

import com.appium.demo.base.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseTest {

    @Override
    protected String getAppPackage() {
        return "com.google.android.calculator";
    }

    @Override
    protected String getAppActivity() {
        return "com.android.calculator2.Calculator";
    }

    @Test
    public void verifyAddition() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id(
                                "com.google.android.calculator:id/digit_2")))
                .click();

        driver.findElement(
                By.id(
                        "com.google.android.calculator:id/op_add"))
                .click();

        driver.findElement(
                By.id(
                        "com.google.android.calculator:id/digit_3"))
                .click();

        driver.findElement(
                By.id(
                        "com.google.android.calculator:id/eq"))
                .click();

        String result =
                driver.findElement(
                        By.id(
                                "com.google.android.calculator:id/result_final"))
                        .getText();

        Assert.assertEquals(result, "5");
    }
}