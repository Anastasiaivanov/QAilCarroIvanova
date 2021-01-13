package com.ilcarro.qa11;

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

    public void openTopCitiesNewYorkFromFooter(){
        click(By.xpath("//a[contains(text(),'New York')]"));
    }

    public void openFacebookFromFooter(){
        click(By.cssSelector(".facebook"));
    }
}
