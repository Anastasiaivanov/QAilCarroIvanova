package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        //go to login page
        if (!isLoginFormPresent()) {
            if (userLoggedIn()) {
                logOut();
            }
            clickLoginTabOnHeader();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //fill the form
        fillLoginForm(new User()
                .setEmail("ni@mail.ru").setPassword("12345678NI"));
        //submit login
        submitForm();
        //assert userLoggedIn
        Assert.assertTrue(userLoggedIn());
        String email = wd.findElement(By.cssSelector("[href='/account']")).getText();
        System.out.println(email);
        Assert.assertEquals(email,"ni@mail.ru");
    }

    public void fillLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }
}
