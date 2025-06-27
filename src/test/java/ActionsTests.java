import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import POM.LoginPage;

import java.util.ArrayList;
import java.util.List;

    public class ActionsTests extends BaseTest {

        @Test
        public void playSongTest() throws InterruptedException {
            Actions actions = new Actions(driver);
            LoginPage loginPage = new LoginPage(driver);

            loginPage.login();

            driver.findElement(By.cssSelector(".music .songs")).click();
            // hover over in clickPlayBtn

            WebElement footerPlayBtn = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
            actions.moveToElement(footerPlayBtn).perform();
            footerPlayBtn.click();
            Thread.sleep(2000);
            Assert.assertTrue(driver.findElement(By.cssSelector("[data-testid='pause-btn']")).isDisplayed());

            // Count multiple elements
            List<WebElement> songs = driver.findElements(By.cssSelector(".song-list-wrap .scroller .items .title"));
            System.out.println(songs.size());
            // Get texts of multiple elements
            List<String> titles = new ArrayList<>();
            for (int i = 0; i < songs.size(); i++){
                titles.add(songs.get(i).getText());
            }
            System.out.println(titles);
            Assert.assertTrue(titles.contains("Algorithms"));
        }

        @Test
        public void renamePlaylist() throws InterruptedException {
            LoginPage loginPage = new LoginPage(driver);
            // double click to choose playlist
            String playlistName = generateRandomPlaylistName();

            loginPage.login();
            // check first custom playlist
            WebElement playlist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
            new Actions(driver)
                    .doubleClick(playlist)
                    .perform();

            // double click to choose playlist
            WebElement input = driver.findElement(By.cssSelector(".playlist:nth-child(3) input"));
            // remove the old name
            //input.sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.DELETE)); // this should work for Mac
            input.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.DELETE)); // this should work for Windows
            input.sendKeys(playlistName);
            input.sendKeys(Keys.ENTER);
            Thread.sleep(1000);
            Assert.assertTrue(driver.findElement(By.cssSelector(".success")).isDisplayed());
            Assert.assertEquals(playlist.getText(), playlistName);
        }

        @Test
        public void playSongFromListTest() {
            // right click on first song
            Actions actions = new Actions(driver);
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login();
            driver.findElement(By.cssSelector(".music .songs")).click();
            // right click
            WebElement song = driver.findElement(By.cssSelector(".song-list-wrap .scroller .items .title"));
            actions
                    .contextClick(song)
                    .perform();
            driver.findElement(By.cssSelector("li.playback")).click();
            Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='toggle-visualizer-btn']"))).isDisplayed());
        }



    }

