package com.ilcarro.qa11.test;

import com.ilcarro.qa11.model.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTest extends TestBase {

    // preconditions: user should be legged out
    @BeforeMethod
    public void ensurePreconditions() {
        if (!app.getHeader().isSignUpTabPresentInHeader()) {//sign up not present
            app.getUser().logOut();
        }
        //a[contains(.,'logOut')]
        // [href='/signup']
    }

    @Test
    public void testSignUp() {
        //click on signUp button
        app.getHeader().openRegistrationFormFromHeader();
        app.getUser().isRegistrationFormOpened();
        //fill registration form
        app.getUser().fillRegistrationForm(new User()
                .setFirstName("Nastya4")
                .setSecondName("Ivanova1")
                .setEmail("null++@mail.ru")
                .setPassword("qwertyuI78"));

        app.getUser().selectPolicyCheckBox();
        //click submit button
        app.getUser().submitForm();
        //check login form displayed
        logger.info("Login form present. Actual result: " + app.getUser().isLoginFormPresent() + " expect result is true");
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        //Assert.assertTrue(isElementPresent(By.cssSelector(".Login_login__right_block__1niYm")));
    }

    @Test(dataProvider = "validUser", dataProviderClass = DataProviders.class)
    public void testSignUpFromDataProvider(String aName, String bName, String email, String password) {

        //click on signUp button
        app.getHeader().openRegistrationFormFromHeader();
        app.getUser().isRegistrationFormOpened();
        //fill registration form
        app.getUser().fillRegistrationForm(new User()
                .setFirstName(aName)
                .setSecondName(bName)
                .setEmail(email)
                .setPassword(password));

        app.getUser().selectPolicyCheckBox();
        //click submit button
        app.getUser().submitForm();
        //check login form displayed
        logger.info("Login form present. Actual result: " + app.getUser().isLoginFormPresent() + " expect result is true");
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        //Assert.assertTrue(isElementPresent(By.cssSelector(".Login_login__right_block__1niYm")));
    }
    @Test(dataProvider = "validUserFromCSV", dataProviderClass = DataProviders.class)
    public void testSignUpFromSCVFromDataProvider(User user) {

        //click on signUp button
        app.getHeader().openRegistrationFormFromHeader();
        app.getUser().isRegistrationFormOpened();
        //fill registration form
        app.getUser().fillRegistrationForm(user);

        app.getUser().selectPolicyCheckBox();
        //click submit button
        app.getUser().submitForm();
        //check login form displayed
        logger.info("Login form present. Actual result: " + app.getUser().isLoginFormPresent() + " expect result is true");
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        //Assert.assertTrue(isElementPresent(By.cssSelector(".Login_login__right_block__1niYm")));
    }

    @Test
    public void testSignUpWithoutPassword() throws InterruptedException {
        //click on signUp button
        app.getHeader().openRegistrationFormFromHeader();
        app.getUser().isRegistrationFormOpened();
        //fill registration form
        app.getUser().fillRegistrationForm(new User()
                .setFirstName("Neu1")
                .setSecondName("Neu1")
                .setEmail("niks12345@mail.ru"));

        app.getUser().selectPolicyCheckBox();
        //Thread.sleep(2000);
        //click submit button
        app.getUser().submitForm();
        //check login form displayed
        Assert.assertTrue(app.getUser().isLoginFormPresent());
        //Assert.assertTrue(isElementPresent(By.cssSelector(".Login_login__right_block__1niYm")));
    }

}
