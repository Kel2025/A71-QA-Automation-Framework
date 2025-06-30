package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

// Page of objects for the Koel --Login Page-- WebElements, objects, interactions found on the Login page of the application

public class LoginPage extends BasePage {
    public LoginPage (WebDriver givenDriver) {super(givenDriver);}

    // Web Elements and their locators
    @FindBy (css = "input[type='email']")
    WebElement emailField;
    @FindBy (css = "input[type='password']")
    WebElement passwordField;
    @FindBy (css = "button[type='submit']")
    WebElement submitBtnLocator;
    @FindBy (css = "a[href='registration']")
    WebElement registrationLink;


    // *********** FLUENT INTERFACE METHODS **********

    // Provide email in the email field
    public LoginPage provideEmail (String email) {
        emailField.sendKeys(email);
        return this;
    }
    // Provide password in the password field
    public LoginPage providePassword (String password) {
        passwordField.sendKeys(password);
        return this;
    }
    // click submit to log in
    public LoginPage clickSubmit () {
      click(submitBtnLocator);
      return this;
    }
    // Confirm the registration link is displayed
    public boolean registrationLinkIsDisplayed () {
        findElement(registrationLink).isDisplayed();
       return  true;
    }
    // Login method
    public LoginPage login() {
        provideEmail("kelly.wade@testpro.io");
        providePassword("P!990109189300ok");
        clickSubmit();
        return this;
    }
/*
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
        clickSubmit();  }
*/

}
