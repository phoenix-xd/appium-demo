
package com.appium.demo.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URI;
import java.time.Duration;

public abstract class BaseTest {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    protected abstract String getAppPackage();

    protected abstract String getAppActivity();

    @BeforeClass
    public void setup() throws Exception {

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        options.setDeviceName("Android");
        options.setUdid("emulator-5554");

        options.setAppPackage(getAppPackage());
        options.setAppActivity(getAppActivity());

        options.setNoReset(true);
        options.setNewCommandTimeout(
                Duration.ofSeconds(300));

        driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723").toURL(),
                options);

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(5));

        driver.activateApp(getAppPackage());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}