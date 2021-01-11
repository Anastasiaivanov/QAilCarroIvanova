package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    // preconditions: user should be legged out
    //click on signUp button
    //fill registration form
    //click submit button
    //check login form displayed
    @BeforeMethod
    public void ensurePreconditions(){
        if(!isElementPresent(By.cssSelector("[href='/signup']"))){
            wd.findElement(By.xpath("a[contains(.,'logOut')]")).click();
            //sign up not present->click on logout form
            //a[contains(.,'logOut')]
            // [href='/signup']
        }
    }
    @Test
    public void testSignUp(){
        wd.findElement(By.cssSelector("[href='/signup']")).click();

        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));

        wd.findElement(By.cssSelector("#first_name")).click();
        wd.findElement(By.cssSelector("#first_name")).clear();
        wd.findElement(By.cssSelector("#first_name")).sendKeys("Nastya");

        wd.findElement(By.cssSelector("#second_name")).click();
        wd.findElement(By.cssSelector("#second_name")).clear();
        wd.findElement(By.cssSelector("#second_name")).sendKeys("Ivanova");

        wd.findElement(By.cssSelector("#email")).click();
        wd.findElement(By.cssSelector("#email")).clear();
        wd.findElement(By.cssSelector("#email")).sendKeys("ni@mail.ru");

        wd.findElement(By.cssSelector("#password")).click();
        wd.findElement(By.cssSelector("#password")).clear();
        wd.findElement(By.cssSelector("#password")).sendKeys("12345678NI");

        wd.findElement(By.cssSelector("#check_policy")).click();

    }
}
