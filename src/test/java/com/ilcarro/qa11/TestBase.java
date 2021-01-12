package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver wd;

    @BeforeSuite
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.get("https://ilcarro-dev-v1.firebaseapp.com/");
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public boolean isFindCarFromPresent1() { //возвращ ошибка что не найден, если 0: false-ошибка
        return wd.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")).size() > 0;
    }

    public boolean isFindCarFromPresent2(By by) { //возвращ ошибка что именно этого элемента нет на стр: такого элемента нет
        try {
            wd.findElements(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        wd.quit();
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitForm() {
        click(By.cssSelector("[type='submit']"));
    }

    public boolean isLoginFormPresent() {
        return isElementPresent(By.cssSelector(".Login_login__right_block__1niYm"));
    }

    public boolean isSignUpTabPresentInHeader() {
        return isElementPresent(By.cssSelector("[href='/signup']"));
    }

    public void logOut() {
        click(By.xpath("//a[contains(.,'logOut')]"));
    }

    public void clickLoginTabOnHeader() {
        click(By.cssSelector("[href='/login']"));
    }

    protected boolean userLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(.,'logOut')]"));
    }
}
