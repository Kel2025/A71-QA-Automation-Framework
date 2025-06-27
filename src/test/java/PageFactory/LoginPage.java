package PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    // locators
    @FindBy (css = "input[type='email']")
    WebElement emailField;
    @FindBy (css = "input[type='password']")
    WebElement passwordField;
    @FindBy (css = "button[type='submit']")
    WebElement submitBtnLocator;
    @FindBy (css = "a[href='registration']")
    WebElement registrationLink;

    public LoginPage (WebDriver givenDriver) {super(givenDriver);}

    // Fluent interface
    public LoginPage provideEmail (String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword (String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmit () {
      click(submitBtnLocator);
      return this;
    }
    public boolean getRegistrationLink () {
        findElement(registrationLink).isDisplayed();
       return  true;
    }
}
