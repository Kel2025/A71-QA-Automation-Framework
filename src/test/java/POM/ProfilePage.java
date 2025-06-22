package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


// Page of objects for Koel Profile Page

public class ProfilePage extends BasePage{
    public ProfilePage(WebDriver givenDriver) {
        super(givenDriver);
    }

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
}
