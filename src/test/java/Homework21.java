import PageFactory.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist ()  {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        BasePage basePage = new BasePage(driver);
        String newPlaylistName = basePage.generateRandomPlaylistName();
        String updatedPlaylistMsg = "Updated playlist \"" + newPlaylistName  + ".\"";


        //Log in to koel app
        loginPage.login();
        // double click playlist from side menu
        homePage.doubleClickPlaylist();
        //clear field, enter new playlist name
        homePage.editPlaylistName(newPlaylistName);
        // Assert that the actual playlist name matches the new randomly generated name
        Assert.assertEquals(homePage.getSuccessMsgText(), updatedPlaylistMsg);
    }

    @Test
    public void createNewPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        BasePage basePage = new BasePage(driver);
        String playlistName = basePage.randomPlaylistName();
        String createdPlaylistMsg = "Created playlist \"" + playlistName  + ".\"";

        loginPage.login();
        homePage.clickCreatePlaylistBtn();
        homePage.clickNewPlaylist();
        homePage.enterPlaylistName(playlistName);
        Assert.assertEquals(homePage.getSuccessMsgText(), createdPlaylistMsg);
    }
}




