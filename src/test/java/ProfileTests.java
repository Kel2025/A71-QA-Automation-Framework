import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;


public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileName() throws InterruptedException {

        //Navigate to Koel app
        navigateUrl();
        //provide email
        provideEmail("kelly.Wade@testpro.io");
        //provide password
        providePassword("P!990109189300ok");
        //click submit
        clickLoginBtn();
        String randomName = randomName();
        //pause for 2 seconds for page to load
        //Thread.sleep(2000);
        //click avatar icon to go to profile setting page
        clickAvatarIcon();
        //provide current Password
        provideCurrentPassword("P!990109189300ok");
        //provide profile name
        provideProfileName(randomName);
        //click save button
        clickSaveButton();
        //wait 2 seconds
        //Thread.sleep(2000);
        //verify profile name change
        WebElement actualProfileName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='name']")));
        Assert.assertEquals(actualProfileName.getText(),randomName);
    }

    public String randomName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public void clickAvatarIcon(){
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        WebElement avatarIcon = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String Password) {
        WebElement currentPassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='current_password']")));
        currentPassword.sendKeys(Password);
    }

    public void provideProfileName(String randomName) {
        WebElement profileNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        profileNameField.clear();
        profileNameField.sendKeys(randomName);
    }

    public void clickSaveButton() {
        WebElement saveButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.btn-submit")));
        saveButton.click();
    }

}



