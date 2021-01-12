package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationBarTest extends TestBase{
    @Test
    public void testSearch(){
        click(By.cssSelector("a[href='/search']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("div[class='main-search__sidebar']")));
    }

    public void letTheCatWork(){
        click(By.cssSelector("a[href='/car']"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".let-carwork-style_let_car__location__30BIh")));
    }

    public void signUp(){
        click(By.cssSelector("a[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector(".signup__right_block")));
    }

    public void logIn(){
        click(By.cssSelector("a[href='/login']"));
        Assert.assertTrue(isLoginFormPresent());
    }
}
