package com.ilcarro.qa11.framework;

import com.ilcarro.qa11.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void logOut() {
        click(By.xpath("//a[contains(.,'logOut')]"));
    }

    public boolean userLoggedIn() {
        return isElementPresent(By.xpath("//a[contains(.,'logOut')]"));
    }
    public boolean isLoginFormPresent() {
        return isElementPresent(By.cssSelector(".Login_login__right_block__1niYm"));
    }

    public void fillLoginForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void logIn() {
        click(By.cssSelector("[href='/login']"));
        fillLoginForm(new User()
                .setEmail("nil@mail.ru").setPassword("12345678NI"));
        submitForm();
    }

    public void fillRegistrationForm(User user) {
        type(By.name("first_name"), user.getFirstName());
        type(By.name("second_name"), user.getSecondName());
        fillLoginForm(user);
    }

    public void isRegistrationFormOpened() {
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
    }

    public void selectPolicyCheckBox() {
        click(By.cssSelector("#check_policy"));
    }
}
