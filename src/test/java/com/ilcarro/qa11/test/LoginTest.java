package com.ilcarro.qa11.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        //go to login page
        if (!app.getUser().isLoginFormPresent()) {
            if (app.getUser().userLoggedIn()) {
                app.getUser().logOut();
            }
            app.getHeader().clickLoginTabOnHeader();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //fill the form
        app.getUser().logIn();
        //assert userLoggedIn
        Assert.assertTrue(app.getUser().userLoggedIn());
        //String email = app.getHeader().getEmailTextFromHeader();
        //System.out.println(email);
        //Assert.assertEquals(email,"@mail.ru");
    }
}
