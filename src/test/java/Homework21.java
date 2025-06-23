import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest {

    @Test
    public void renamePlaylist ()  {
        String newPlaylistName = generateRandomPlaylistName();
        String updatedPlaylistMsg = "Updated playlist \"" + newPlaylistName  + ".\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Log in to koel app
        loginPage.login();
        // double click playlist from side menu
        homePage.doubleClickPlaylist();
        //clear field, enter new playlist name
        homePage.enterNewPlaylistName(newPlaylistName);
        // Assert that the actual playlist name matches the new randomly generated name
        Assert.assertEquals(homePage.getRenamePlaylistSuccessMsg(), updatedPlaylistMsg);
    }

    @Test
    public void createNewPlaylist() {
        String playlistName = randomPlaylistName();
        String createdPlaylistMsg = "Created playlist \"" + playlistName  + ".\"";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
        homePage.clickCreatePlaylistBtn();
        homePage.clickNewPlaylist();
        homePage.enterPlaylistName(playlistName);
        Assert.assertEquals(homePage.getCreatedPlaylistSuccessMsg(), createdPlaylistMsg);
    }
}




