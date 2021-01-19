package com.ilcarro.qa11.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBarTest extends TestBase {
    @Test
    public void testSearch(){
        app.getUser().click(By.cssSelector("a[href='/search']"));
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector("div[class='main-search__sidebar']")));
    }

    public void letTheCatWork(){
        app.getUser().click(By.cssSelector("a[href='/car']"));
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector(".let-carwork-style_let_car__location__30BIh")));
    }

    public void signUp(){
        app.getUser().click(By.cssSelector("a[href='/signup']"));
        Assert.assertTrue(app.getUser().isElementPresent(By.cssSelector(".signup__right_block")));
    }

    public void logIn(){
        app.getUser().click(By.cssSelector("a[href='/login']"));
        Assert.assertTrue(app.getUser().isLoginFormPresent());
    }
}
