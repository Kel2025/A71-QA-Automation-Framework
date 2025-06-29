package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    public LoginPage (WebDriver givenDriver) {super(givenDriver);}

    // locators
    @FindBy (css = "input[type='email']")
    WebElement emailField;
    @FindBy (css = "input[type='password']")
    WebElement passwordField;
    @FindBy (css = "button[type='submit']")
    WebElement submitBtnLocator;
    @FindBy (css = "a[href='registration']")
    WebElement registrationLink;


    // Fluent interface

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
    public LoginPage login() {
        provideEmail("kelly.wade@testpro.io");
        providePassword("P!990109189300ok");
        clickSubmit();
        return this;
    }

}
