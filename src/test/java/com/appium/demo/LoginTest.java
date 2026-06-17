package com.appium.demo;

import com.appium.demo.base.BaseTest;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Override
    protected String getAppPackage() {
        return "com.saucelabs.mydemoapp.android";
    }

    @Override
    protected String getAppActivity() {
        return "com.saucelabs.mydemoapp.android.view.activities.MainActivity";
    }

    @Test
    public void verifyLogin() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/menuIV\")")))
                .click();

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().text(\"Log In\")")))
                .click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/nameET\")")))
                .sendKeys("admin");

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/passwordET\")")))
                .sendKeys("admin");

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        AppiumBy.androidUIAutomator(
                                "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/loginBtn\")")))
                .click();

        WebElement productTitle =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.androidUIAutomator(
                                        "new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/productTV\")")));

        Assert.assertTrue(productTitle.isDisplayed());
    }
}