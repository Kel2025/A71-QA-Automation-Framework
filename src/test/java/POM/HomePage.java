//package POM;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//// Page of objects for the Koel Home Page
//
//public class HomePage extends BasePage{
//    public HomePage (WebDriver givenDriver) {super(givenDriver);}
//
//    // Page elements and their locators
//    By userAvatarIcon = By.cssSelector("img.avatar");
//    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
//    By playlistNameField = By.cssSelector("[name='name']");
//    By renamePlaylistSuccessMsg = By.cssSelector("div.success.show");
//    By createNewPlaylistBtn = By.xpath("//*[@id=\"playlists\"]/h1/i");
//    By newPlaylist = By.cssSelector("[data-testid= 'playlist-context-menu-create-simple']");
//    By newPlaylistNameField = By.xpath("//*[@id=\"playlists\"]/form/input");
//
//    //METHODS
//
//    // return the userAvatarIcon element
//    public WebElement getUserAvatarIcon() {
//        return findElement(userAvatarIcon);
//    }
//    // Click user avatar icon
//    public void clickUserAvatarIcon() { findElement(userAvatarIcon).click();}
//    public void doubleClickPlaylist () {doubleClick(firstPlaylist);}
//    public void enterNewPlaylistName (String playlistName) {
//        findElement(playlistNameField).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        findElement(playlistNameField).sendKeys(playlistName);
//        findElement(playlistNameField).sendKeys(Keys.ENTER);
//    }
//    public String getRenamePlaylistSuccessMsg () { return findElement(renamePlaylistSuccessMsg).getText();}
//    public void clickCreatePlaylistBtn () { findElement(createNewPlaylistBtn).click();}
//    public void clickNewPlaylist () { findElement(newPlaylist).click();}
//    public void enterPlaylistName (String randomPlaylistName) {
//        findElement(newPlaylistNameField).sendKeys(randomPlaylistName + Keys.ENTER);
//    }
//    public String getCreatedPlaylistSuccessMsg () { return findElement(renamePlaylistSuccessMsg).getText();}
//
//}
