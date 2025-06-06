import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {

        // Navigate to koel app
        navigateUrl();
        // Login with valid credentials
        provideEmail("kelly.wade@testpro.io");
        providePassword("P!990109189300ok");
        clickSubmit();
        //Click «Play next song» (media player controls), then the Play button, to play a song.
        clickPlayNextSong();
        // Validate that a song is playing by verifying if the sound bar, or the pause button is displayed.
        WebElement pauseButton = driver.findElement(By.xpath("//footer//i[@class='fa fa-pause']"));
        Assert.assertTrue(pauseButton.isDisplayed());
    }
}
