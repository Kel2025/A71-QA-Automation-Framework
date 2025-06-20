import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework21 extends BaseTest {
    Actions actions = new Actions(driver);

    @BeforeMethod
    public void setUp() {
        //Initialize the WebDriver and other necessary components
        driver = new ChromeDriver();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    // prerequisite: must have at least 1 user playlist created
    public void renamePlaylist() {
        String newPlaylistName = generateRandomPlaylistName();

        login();

        // double click playlist from side menu
        doubleClickPlaylist();

        //clear field, enter new playlist name
        enterPlaylistName(newPlaylistName);

        //verify success message and playlist name is changed
        Assert.assertTrue(successNotification.isDisplayed());
        Assert.assertEquals(playlist.getText(), newPlaylistName);
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
    //web element locator and wait for success notification
    WebElement successNotification = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));

    // web element, locator, and wait for playlist to assert name change
    WebElement playlist = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".playlist:nth-child(3)")));

}




