package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper extends HelperBase{

    public HeaderHelper(WebDriver wd) {
        super(wd);
    }

    public boolean isSignUpTabPresentInHeader() {
        return isElementPresent(By.cssSelector("[href='/signup']"));
    }

    public void clickLoginTabOnHeader() {
        click(By.cssSelector("[href='/login']"));
    }

    public void openRegistrationFormFromHeader() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void openAddCarFormFromHeader() {
        click(By.cssSelector("[href='/car']"));
    }

    public String getEmailTextFromHeader() {
        return getEmailTextFromHeader();
    }
}
