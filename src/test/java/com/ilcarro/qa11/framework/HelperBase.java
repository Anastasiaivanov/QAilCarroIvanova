package com.ilcarro.qa11.framework;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public boolean isFindCarFromPresent2(By by) { //возвращ ошибка что именно этого элемента нет на стр: такого элемента нет
        try {
            wd.findElements(by);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitForm() {
        click(By.cssSelector("[type='submit']"));
    }

    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void jumpToFooter() {
        wd.findElement(By.cssSelector("body")).sendKeys(Keys.END);
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp, screenshot);
        }catch (IOException e){
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }
}
