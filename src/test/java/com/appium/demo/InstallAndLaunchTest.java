package com.appium.demo;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URI;
import java.time.Duration;

public class InstallAndLaunchTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception {

        String apkPath =
                System.getProperty("user.dir")
                        + "/apps/TheApp.apk";

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");

        // Use the value from adb devices
        options.setDeviceName("Android");
        options.setUdid("emulator-5554");

        options.setApp(apkPath);

        options.setAutoGrantPermissions(true);
        options.setNewCommandTimeout(Duration.ofSeconds(300));

        driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723").toURL(),
                options);

        Thread.sleep(5000);
    }

    @Test
    public void verifyAppInstalledAndLaunched() {

        Assert.assertNotNull(
                driver.getSessionId(),
                "Session was not created");

        String currentPackage =
                driver.getCurrentPackage();

        String currentActivity =
                driver.currentActivity();

        System.out.println(
                "Current Package: "
                        + currentPackage);
        System.out.println(
                "Current Activity: "
                        + currentActivity);

        Assert.assertNotNull(
                currentPackage,
                "Application did not launch");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}