//package PageFactory;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//
//public class HomePage extends BasePage {
//    public HomePage(WebDriver givenDriver) {
//        super(givenDriver);
//    }
//
//    // Locators
//    @FindBy(css = "img.avatar")
//    WebElement userAvatarIcon;
//    @FindBy(css = ".playlist:nth-child(3)")
//    WebElement firstUserPlaylist;
//    @FindBy(css = "[name='name']")
//    WebElement playlistNameField;
//    @FindBy(css = "div.success.show")
//    WebElement renamePlaylistSuccessMsg;
//    @FindBy(xpath = "//*[@id=\"playlists\"]/h1/i")
//    WebElement createNewPlaylistBtn;
//    @FindBy(css = "[data-testid= 'playlist-context-menu-create-simple']")
//    WebElement newPlaylist;
//    @FindBy(xpath = "//*[@id=\"playlists\"]/form/input")
//    WebElement newPlaylistNameField;
//
//    //fluent interface methods
//
//
//}