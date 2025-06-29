package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
    @FindBy(css = "[name='current_password']")
    WebElement currentPasswordField;
    @FindBy(css = "[name='name']")
    WebElement profileNameField;
    @FindBy(css = "button.btn-submit")
    WebElement saveBtn;

    //Fluent interface methods

    //Provide current password on the profile page
    public ProfilePage provideCurrentPassword(String currentPassword) {
        findElement(currentPasswordField).sendKeys(currentPassword);
        return this;
    }
    // Provide profile name in the profile name field
    public ProfilePage provideNewProfileName(String randomName) {
        profileNameField.clear();
        profileNameField.sendKeys(randomName);
        return this;
    }
    public ProfilePage clickSaveBtn() {
        saveBtn.click();
        return this;
    }
}
