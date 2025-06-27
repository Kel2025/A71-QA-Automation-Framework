package PageFactory;
import org.openqa.selenium.By;
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
    By submitBtnLocator;



    // Fluent interface
    public LoginPage provideEmail (String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword (String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn () {
      click(submitBtnLocator);
      return this;

    }

}
