package com.ilcarro.qa11.test;

import com.ilcarro.qa11.framework.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

    @BeforeMethod
    public void startTest(Method m, Object[] p){
        logger.info("Start test "+ m.getName()+" with data: "+ Arrays.asList(p));
    }

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();
    }

    @AfterMethod
    public void stopTest(Method m){
        logger.info("Stop test "+ m.getName());
        logger.info("==============================");
    }

}
