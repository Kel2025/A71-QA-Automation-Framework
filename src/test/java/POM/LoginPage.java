package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


// Page of objects for the Koel Login Page

public class LoginPage extends BasePage{
    public LoginPage (WebDriver givenDriver) {super(givenDriver);}

    // Elements and their locators
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");
    By registrationLink = By.cssSelector("a[href='registration']");

    // METHODS
    // Input email address in the email field
    public void provideEmail (String email) {findElement(emailField).sendKeys(email);}
    // Input password in the password field
    public void providePassword (String password) {findElement(passwordField).sendKeys(password);}
    // Click submit button to log in
    public void clickSubmit() { findElement(submitBtn).click();}
    // Login method puts methods together to log in to the koel app
    public void login() {
        provideEmail("kelly.wade@testpro.io");
        providePassword("P!990109189300ok");
        clickSubmit();
    }
}
