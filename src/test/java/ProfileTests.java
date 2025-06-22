import POM.HomePage;
import POM.LoginPage;
import POM.ProfilePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;


public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        String randomName = generateRandomName();

        loginPage.login();
       // Thread.sleep(2000);
        // The test fails without using Thread.sleep(2000)
        // It gives the "element click intercepted error for the line below: homePage.clickUserAvatarIcon();
        homePage.clickUserAvatarIcon();
        profilePage.provideCurrentPassword("P!990109189300ok");
        //provide new profile name
        profilePage.provideNewProfileName(randomName);
        // Click save button to save changes
        profilePage.clickSaveBtn();
        //assert profile name changed
        wait.until(ExpectedConditions.textToBe(profilePage.actualProfileName, randomName));
        Assert.assertEquals(profilePage.getProfileNameText(), randomName);

    }
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }
}



