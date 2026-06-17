package com.appium.demo;

import com.appium.demo.base.BaseTest;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollTest extends BaseTest {

    @Override
    protected String getAppPackage() {
        return "com.saucelabs.mydemoapp.android";
    }

    @Override
    protected String getAppActivity() {
        return "com.saucelabs.mydemoapp.android.view.activities.MainActivity";
    }

    @Test
    public void verifyScroll() {

        WebElement product =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.androidUIAutomator(
                                        "new UiScrollable(new UiSelector().scrollable(true))"
                                                + ".scrollIntoView("
                                                + "new UiSelector().textContains(\"Fleece Jacket\")"
                                                + ")")));

        Assert.assertTrue(product.isDisplayed());

        System.out.println(
                "Scrolled successfully to: "
                        + product.getText());
    }
}