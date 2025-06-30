package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Page of objects for the Koel --Profile Page-- WebElements, objects, interactions found on the Profile page of the application

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver givenDriver) {super(givenDriver);}

    // Web Elements and their locators
    @FindBy(css = "[name='current_password']")
    WebElement currentPasswordField;
    @FindBy(css = "[name='name']")
    WebElement profileNameField;
    @FindBy(css = "button.btn-submit")
    WebElement saveBtn;

    // *********** FLUENT INTERFACE METHODS **********

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
    // Click save button to save profile changes
    public ProfilePage clickSaveBtn() {
        saveBtn.click();
        return this;
    }
}
/*
    // Page elements and their locators
    By currentPasswordField = By.cssSelector("[name='current_password']");
    By profileNameField = By.cssSelector("[name='name']");
    By saveBtn = By.cssSelector("button.btn-submit");
    public By actualProfileName = By.cssSelector("a.view-profile>span");

    //METHODS
    public void provideCurrentPassword (String currentPassword) {
        findElement(currentPasswordField).sendKeys(currentPassword);
    }
    public void provideNewProfileName (String randomName) {
        findElement(profileNameField).clear();
        findElement(profileNameField).sendKeys(randomName);
    }
    public void clickSaveBtn() {
        findElement(saveBtn).click();
    }
    public String getProfileNameText () {
        return findElement(actualProfileName).getText();
    }
 */
