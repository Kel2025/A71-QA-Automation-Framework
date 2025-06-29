package PageFactory;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Locators
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



    //fluent interface methods

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
    //Double click first user playlist
    public HomePage doubleClickPlaylist() {
        doubleClick(firstUserPlaylist);
        return this;
    }
    //Enter new playlist name in the playlist name field
    public HomePage enterNewPlaylistName (String playlistName) {
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