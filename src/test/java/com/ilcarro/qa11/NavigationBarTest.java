package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBarTest extends TestBase{
    @Test
    public void testSearch(){
        wd.findElement(By.cssSelector("a[href='/search']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("div[class='main-search__sidebar']")));
    }

    public void letTheCatWork(){
        wd.findElement(By.cssSelector("a[href='/car']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".let-carwork-style_let_car__location__30BIh")));
    }

    public void signUp(){
        wd.findElement(By.cssSelector("a[href='/signup']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".signup__right_block")));
    }

    public void logIn(){
        wd.findElement(By.cssSelector("a[href='/login']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector(".Login_login__right_block__1niYm")));
    }
}
