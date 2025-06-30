import PageFactory.LoginPage;
import PageFactory.HomePage;
import PageFactory.ProfilePage;
import PageFactory.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() {
        String expectedSongAddedMsg = "Added 1 song into \"Second User Playlist.\"";

        LoginPage loginPage = new LoginPage(driver);

        // Navigate to koel app
        navigateUrl();

        // Log in with valid credentials
        loginPage.provideEmail("kelly.wade@testpro.io");
        loginPage.providePassword("P!990109189300ok");
        loginPage.clickSubmit();
        // Search for a song
        searchSong("Lament");
        // Click 'View All' button to display search results
        clickViewAllBtn();
        // Click the first song in the search results
        selectFirstSong();
        // Click the 'ADD TO...' button
        clickAddToBtn();
        // Choose the playlist to add selected song to
        selectPlaylist();
        //Assertion
        Assert.assertEquals(getAddToPlaylistSuccessMsg(), expectedSongAddedMsg);
    }

    // Search for a song
    public void searchSong(String song) {
        //WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        // Change to explicit wait
        WebElement searchField = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='search']")));
        searchField.click();
        searchField.sendKeys(song);
    }

    // Click 'View All' button to display search results
    public void clickViewAllBtn() {
        //WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        //Change to explicit wait
        WebElement viewAllButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-test='view-all-songs-btn']")));
        viewAllButton.click();
    }

    // Click the first song in the search results
    public void selectFirstSong() {
        //WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        //Change to explicit wait
        WebElement firstSong = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
        firstSong.click();
    }

    // Click the 'ADD TO...' button
    public void clickAddToBtn() {
        //WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@class='btn-add-to']"));
        //Change to explicit wait
        WebElement addToBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//section[@id='songResultsWrapper']//button[@class='btn-add-to']")));
        addToBtn.click();
    }

    // Choose the playlist to add selected song to
    public void selectPlaylist() {
        //WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Second User Playlist')]"));
        //Change to explicit wait
        WebElement playlist = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(
                        "//section[@id='songResultsWrapper']//li[contains(text(), 'Second User Playlist')]")));
        playlist.click();
    }

    public String getAddToPlaylistSuccessMsg()  {
        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        //Change to explicit wait
        WebElement notification = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}

