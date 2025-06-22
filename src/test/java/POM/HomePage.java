package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Page of objects for the Koel Home Page

public class HomePage extends BasePage{
    public HomePage (WebDriver givenDriver) {
        super(givenDriver);
    }

    // Page elements and their locators
    By userAvatarIcon = By.cssSelector("img.avatar");

    //METHODS

    // return the userAvatarIcon element
    public WebElement getUserAvatarIcon() {
        return findElement(userAvatarIcon);
    }
    // Click user avatar icon
    public void clickUserAvatarIcon() { findElement(userAvatarIcon).click();}

}
