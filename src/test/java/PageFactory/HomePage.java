package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

// Page of objects for the Koel --Home Page-- WebElements, objects, interactions found on the Home page of the application

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // WebElements + locators
    @FindBy(css = "img.avatar")
    WebElement userAvatarIcon;
    @FindBy(css = ".playlist:nth-child(3)")
    WebElement firstUserPlaylist;
    @FindBy(css = "[name='name']")
    WebElement playlistNameField;
    @FindBy(xpath = "//*[@id=\"playlists\"]/h1/i")
    WebElement createNewPlaylistBtn;
    @FindBy(css = "[data-testid= 'playlist-context-menu-create-simple']")
    WebElement newPlaylist;
    @FindBy(xpath = "//*[@id=\"playlists\"]/form/input")
    WebElement newPlaylistNameField;
    @FindBy(css = "div.success.show")
     WebElement successMsg;

    // *********** FLUENT INTERFACE METHODS **********

    //***** User Avatar interactions *****
    // return the userAvatarIcon element
    public boolean getUserAvatarIcon () {
         findElement(userAvatarIcon).isDisplayed();
         return  true;
    }
    // Click user avatar icon
    public HomePage clickUserAvatarIcon() {
        click(userAvatarIcon);
        return this;
    }

    //***** Playlist Interactions *****
    //Double click first user playlist
    public HomePage doubleClickPlaylist() {
        doubleClick(firstUserPlaylist);
        return this;
    }
    //Enter new playlist name in the playlist name field
    public HomePage editPlaylistName (String playlistName) {
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        return this;
    }
    //Get success message for  changing playlist name
    public HomePage getSuccessMsgText() {
        findElement(successMsg).getText();
        return this;
    }
    //Click create playlist button
    public HomePage clickCreatePlaylistBtn() {
        findElement(createNewPlaylistBtn).click();
        return this;
    }
    //Click new playlist
    public HomePage clickNewPlaylist() {
        findElement(newPlaylist).click();
        return this;
    }
    //Enter playlist name in playlist name field
    public HomePage enterPlaylistName (String randomPlaylistName) {
        findElement(newPlaylistNameField).sendKeys(randomPlaylistName + Keys.ENTER);
        return this;
    }
}


/*
    // By locators for page elements
    By userAvatarIcon = By.cssSelector("img.avatar");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='name']");
    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");
    By createNewPlaylistBtn = By.xpath("//*[@id=\"playlists\"]/h1/i");
    By newPlaylist = By.cssSelector("[data-testid= 'playlist-context-menu-create-simple']");
    By newPlaylistNameField = By.xpath("//*[@id=\"playlists\"]/form/input");

    //METHODS
    // return the userAvatarIcon element
    public WebElement getUserAvatarIcon() {return findElement(userAvatarIcon);}
    // Click user avatar icon
    public void clickUserAvatarIcon() { findElement(userAvatarIcon).click();}
    public void doubleClickPlaylist () {doubleClick(firstPlaylist);}
    public void enterNewPlaylistName (String playlistName) {
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        findElement(playlistNameField).sendKeys(playlistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
    }
    public String getRenamePlaylistSuccessMsg () { return findElement(renamePlaylistSuccessMsg).getText();}
    public void clickCreatePlaylistBtn () { findElement(createNewPlaylistBtn).click();}
    public void clickNewPlaylist () { findElement(newPlaylist).click();}
    public void enterPlaylistName (String randomPlaylistName) {
        findElement(newPlaylistNameField).sendKeys(randomPlaylistName + Keys.ENTER);
    }
    public String getCreatedPlaylistSuccessMsg () { return findElement(renamePlaylistSuccessMsg).getText();}
*/