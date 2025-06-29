import PageFactory.BasePage;
import PageFactory.ProfilePage;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileName() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        BasePage basePage = new BasePage(driver);

        String randomName = basePage.generateRandomName();


        loginPage.login();
        homePage.clickUserAvatarIcon();
        profilePage.provideCurrentPassword("P!990109189300ok").provideNewProfileName(randomName).clickSaveBtn();
        //assert profile name changed
      //  Assert.assertEquals(homePage.getProfileNameText(), randomName);
        String profileName = homePage.getProfileNameText();
        Assert.assertEquals(profileName, randomName);

    }
 }



