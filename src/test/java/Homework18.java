import PageFactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);

        // Navigate to koel app
        //navigateUrl();
        // Login with valid credentials
        loginPage.provideEmail("kelly.wade@testpro.io");
        loginPage.providePassword("P!990109189300ok");
        loginPage.clickSubmit();
        //Click «Play next song» (media player controls), then the Play button, to play a song.
        clickPlayNextSong();
        // Validate that a song is playing by verifying if the sound bar, or the pause button is displayed.
            // WebElement pauseButton = driver.findElement(By.xpath("//span[@data-testid='pause-btn']"));
        Assert.assertTrue(songIsPlaying());
    }

    //Click «Play next song» (media player controls), then the Play button, to play a song.
    public void clickPlayNextSong () {
        WebElement playNextSongBtn = driver.findElement(
                By.xpath("//i[@data-testid='play-next-btn']"));
        WebElement playButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));

        playNextSongBtn.click();
        playButton.click();
    }

    public boolean songIsPlaying() {

        WebElement pauseButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@data-testid='pause-btn']")));
        return pauseButton.isDisplayed();
    }

}
