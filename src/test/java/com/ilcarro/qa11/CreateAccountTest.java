package com.ilcarro.qa11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
    // preconditions: user should be legged out
    @BeforeMethod
    public void ensurePreconditions() {
        if (!isSignUpTabPresentInHeader()) {//sign up not present
            logOut();
        }
            //a[contains(.,'logOut')]
            // [href='/signup']
        }

    @Test
    public void testSignUp() {
        //click on signUp button
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        //fill registration form
        fillRegistrationForm(new User()
                .setFirstName("Nastya3")
                .setSecondName("Ivanova1")
                .setEmail("null@mail.ru")
                .setPassword("qwertyuI78"));

        click(By.cssSelector("#check_policy"));
        //click submit button
        submitForm();
        //check login form displayed
        Assert.assertTrue(isLoginFormPresent());
        //Assert.assertTrue(isElementPresent(By.cssSelector(".Login_login__right_block__1niYm")));
    }

    @Test
    public void testSignUpWithoutPassword() throws InterruptedException {
        //click on signUp button
        click(By.cssSelector("[href='/signup']"));
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        //fill registration form
        fillRegistrationForm(new User()
                .setFirstName("Neu1")
                .setSecondName("Neu1")
                .setEmail("niks12345@mail.ru"));

        click(By.cssSelector("#check_policy"));
        //Thread.sleep(2000);
        //click submit button
        submitForm();
        //check login form displayed
        Assert.assertTrue(isLoginFormPresent());
        //Assert.assertTrue(isElementPresent(By.cssSelector(".Login_login__right_block__1niYm")));
    }

    public void fillRegistrationForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

}
