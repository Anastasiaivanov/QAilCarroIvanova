package com.ilcarro.qa11.framework;

import com.google.common.io.Files;
import org.openqa.selenium.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }

    public String getAllLinksFromHomePage() {
        List<WebElement> allLinks = wd.findElements(By.tagName("a"));
        String url = "";
        System.out.println("There are " + allLinks.size() + " links on the page");
        Iterator<WebElement> iterator = allLinks.iterator();
        while (iterator.hasNext()) {
            url = iterator.next().getText();
            System.out.println(url);
        }
        return url;
    }

    public void checkBrokenLinksOnHomePage() {
        List<WebElement> allLinks = wd.findElements(By.tagName("a"));
        for (int i = 0; i < allLinks.size(); i++) {
            WebElement element = allLinks.get(i);
            String url = element.getAttribute("href");
            verifyLinks(url);
        }
    }

    public void verifyLinks(String link) {
        try {
            URL url = new URL(link);
            HttpsURLConnection httpsUrlConnect = (HttpsURLConnection) url.openConnection();
            httpsUrlConnect.setConnectTimeout(5000);
            httpsUrlConnect.connect();
            if (httpsUrlConnect.getResponseCode() >= 400) {
                System.out.println(link + " - " + httpsUrlConnect.getResponseMessage() + " is a broken link");
            } else {
                System.out.println(link + " - " + httpsUrlConnect.getResponseMessage());
            }

        } catch (Exception e) {
            System.out.println(link + " - " + e.getMessage() + " is a broken link");
        }
    }
}
