package com.ilcarro.qa11;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
                .setFirstName("Nastya3")
                .setSecondName("Ivanova1")
                .setEmail("null@mail.ru")
                .setPassword("qwertyuI78"));

        app.getUser().selectPolicyCheckBox();
        //click submit button
        app.getUser().submitForm();
        //check login form displayed
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
