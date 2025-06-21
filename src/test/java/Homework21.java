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

        //Log in to koel app
        login();
        // double click playlist from side menu
        doubleClickPlaylist();
        //clear field, enter new playlist name
        enterNewPlaylistName(newPlaylistName);
        //verify success message and playlist name is changed
        // first assert that success message is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        //locator for playlist element
        WebElement playlist = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".playlist:nth-child(3)")));
        //  then assert that the actual playlist name matches the randomly generated name
        Assert.assertEquals(playlist.getText(), newPlaylistName);
    }

    //methods

    // double click playlist from side menu
    public void doubleClickPlaylist () {
        // explicit wait for playlist locater
        WebElement playlist = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".playlist:nth-child(3)")));
        // double click action
        actions.doubleClick(playlist).perform();
    }

    // clear input field and enter new name for playlist
    public void enterNewPlaylistName(String newPlaylistName)  {
        // wait for web element to be located
        WebElement playlistNameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".playlist:nth-child(3) input")));
        //clear the input field
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.DELETE));
        //enter new playlist name
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
    }
}




