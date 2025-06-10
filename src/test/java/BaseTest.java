import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.UUID;


public class BaseTest {
    public WebDriver driver = null;
    public String url = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters ({"BaseURL"})

    public void launchBrowser(String baseURL) {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        url = baseURL;
        navigateUrl();

    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    public void navigateUrl() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public String randomName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    public void clickAvatarIcon(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String Password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.sendKeys(Password);
    }

    public void provideProfileName(String randomName) {
        WebElement profileNameField = driver.findElement(By.cssSelector("[name='name']"));
        profileNameField.clear();
        profileNameField.sendKeys(randomName);
    }

    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    // Search for a song
    public void searchSong(String song) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.click();
        searchField.sendKeys(song);
    }

    // Click 'View All' button to display search results
    public void clickViewAllBtn() {
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();
    }

    // Click the first song in the search results
    public void selectFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    // Click the 'ADD TO...' button
    public void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//button[@class='btn-add-to']"));
        addToBtn.click();
    }

    // Choose the playlist to add selected song to
    public void selectPlaylist() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Second User Playlist')]"));
        playlist.click();
    }

    public String getAddToPlaylistSuccessMsg()  {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }

    //Click «Play next song» (media player controls), then the Play button, to play a song.
    public void clickPlayNextSong () {
        WebElement playNextSongBtn = driver.findElement(By.cssSelector("i[class='next fa fa-step-forward control']"));
        playNextSongBtn.click();
        WebElement playButton = driver.findElement(By.xpath("//footer//i[@class='fa fa-play']"));
        playButton.click();
    }


    // Select playlist from side menu
    public void clickPlaylist () {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//a[contains(text(), 'Delete This')]"));
        playlist.click();
    }

    // Click the red delete playlist button
    public void clickDeletePlaylistButton () {
        WebElement deletePlaylistButton = driver.findElement(By.cssSelector("button[class=\"del btn-delete-playlist\"]"));
        deletePlaylistButton.click();
    }

    // Get the notification for successful playlist delete
    public String getDeletedPlaylistSuccessMsg() {
        WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        return notification.getText();
    }
}