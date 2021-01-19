package com.ilcarro.qa11.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    UserHelper user;
    CarHelper car;
    HeaderHelper header;
    FooterHelper footer;
    String browser;


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
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
        user = new UserHelper(wd);
        car = new CarHelper(wd);
        header = new HeaderHelper(wd);
        footer = new FooterHelper(wd);
    }

    public void stop() {
        wd.quit();
    }
}
