package com.telran.automation.tests.tests;

import com.telran.automation.tests.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

     static ApplicationManager app = new ApplicationManager (System.getProperty("browser", BrowserType.CHROME));   // браузер по умолчанию, если не указать иное в виртуальной машине

    @BeforeSuite
    public void setUp() {
        app.start();

    }

    @AfterSuite
    public void tearDown() throws InterruptedException {
        app.stop();

    }


}
