package com.ilcarro.qa11.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterHelper extends HelperBase{

    public FooterHelper(WebDriver wd) {
        super(wd);
    }
    public void openSearchFromFooter(){
        click(By.cssSelector("[href='/search']"));
    }

    public void openLetTheCarWorkFromFooter(){
        click(By.cssSelector("[href='/car']"));
    }

    public void openTermsOfUseFromFooter(){
        click(By.cssSelector("[href='/terms']"));
    }

    public void openTopCityFromFooter(By locator){
        click(locator);
    }

    public void openSocialMediaFromFooter(By locator){
        click(locator);
    }
}
