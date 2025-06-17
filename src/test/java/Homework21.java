import com.github.dockerjava.core.KeystoreSSLConfig;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest {


    @Test
    // prerequisite: must have at least 1 user playlist created
    public void renamePlaylist() {
        String newPlaylistName = generateRandomPlaylistName();
        Actions actions = new Actions(driver);
        login();

        // double click playlist from side menu
        doubleClickPlaylist();

        //clear field, enter new playlist name
        enterPlaylistName(newPlaylistName);

        //verify success message and playlist name is changed
        WebElement successNotification = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        WebElement playlist = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector(".playlist:nth-child(3)")));
        Assert.assertEquals(playlist.getText(), newPlaylistName );
    }

    // generate random name for playlist
    public String generateRandomPlaylistName() {
        Faker faker = new Faker();
        return faker.buffy().characters();
    }

    // double click playlist from side menu
    public void doubleClickPlaylist () {
        // explicit wait for playlist locater
        WebElement playlist = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".playlist:nth-child(3)")));
        // double click action
        actions.doubleClick(playlist).perform();
    }

    public void enterPlaylistName(String newPlaylistName) {
        // wait for web element to be located
        WebElement playlistNameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("[name='name']")));
        //clear the input field
        playlistNameField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.DELETE));
        //enter new playlist name
        playlistNameField.sendKeys(newPlaylistName);
        playlistNameField.sendKeys(Keys.ENTER);
    }
}




