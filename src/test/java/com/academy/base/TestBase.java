package com.academy.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.academy.configuration.DriverBase.*;

public class TestBase {
    @BeforeMethod
    public void setUp() {
        initDriverObject();
    }

    @AfterMethod
    public void closeBrowser() {
        closeDrivers();
    }
}