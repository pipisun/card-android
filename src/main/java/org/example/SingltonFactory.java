package org.example;

import io.appium.java_client.AppiumDriver;

public class SingltonFactory {

    private static SingltonFactory instance = new SingltonFactory();
    private static AppiumDriver driver;

    private SingltonFactory() {
    }

    // Get the only object available
    public static SingltonFactory getInstance() {
        return instance;
    }

    // Get the only object available
    public void setDriver(AppiumDriver driver1) {
        driver = driver1;
    }

    public AppiumDriver getAppiumDriver() {
        return driver;
    }
}
