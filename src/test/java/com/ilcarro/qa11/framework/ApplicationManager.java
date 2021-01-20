package com.ilcarro.qa11.framework;

import com.ilcarro.qa11.test.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    EventFiringWebDriver wd;

    UserHelper user;
    CarHelper car;
    HeaderHelper header;
    FooterHelper footer;
    String browser;

    public static class MyListener extends AbstractWebDriverEventListener {

        Logger logger = LoggerFactory.getLogger(TestBase.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            logger.info("Start search " + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            logger.info(by + "found.");
        }

        @Override
        public void onException(Throwable throwable, WebDriver driver) {
            logger.error(throwable.toString());
        }
    }

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public FooterHelper getFooter() {
        return footer;
    }

    public UserHelper getUser() {
        return user;
    }

    public CarHelper getCar() {
        return car;
    }

    public HeaderHelper getHeader() {
        return header;
    }

    public void init() {
        wd = new EventFiringWebDriver(new ChromeDriver());
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        user = new UserHelper(wd);
        car = new CarHelper(wd);
        header = new HeaderHelper(wd);
        footer = new FooterHelper(wd);

        wd.register(new MyListener());
    }

    public void stop() {
        wd.quit();
    }
}
