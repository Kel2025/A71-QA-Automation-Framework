package PageFactory;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

// Page of objects for Koel app -- Base Page-- WebElements, objects, interactions used throughout the whole application

public class BasePage {
    WebDriver driver;
    static WebDriverWait wait;
    Actions actions;

    public BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    // Web Elements and their locators
    @FindBy(css = "div.success.show")
    WebElement successMsg;
    @FindBy(css = "span[class='name']")
    WebElement actualProfileName;

    // *********** FLUENT INTERFACE METHODS **********

    public void click (WebElement webElement) {findElement(webElement).click();}
    public void doubleClick (WebElement webElement) { actions.doubleClick(findElement(webElement)).perform();}
    public void contextClick (WebElement webElement) { actions.contextClick(findElement(webElement)).perform();}

 /* Find element By locator methods and By locators

    public WebElement findElement(By locator) {return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    // By Locators
    By allSongsList = By.cssSelector("li a.songs");
    By soundBarVisualizer = By.cssSelector("[data-testid = 'sound-bar-play']");
    //Methods
    public void click (By locator) {wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();}
    public void doubleClick (By locator) {actions.doubleClick(findElement(locator)).perform(); }
    public void chooseAllSongsList() {click(allSongsList);}
    public boolean isSongPlaying() {return findElement(soundBarVisualizer).isDisplayed();}
*/
    public String generateRandomPlaylistName() {
        Faker faker = new Faker();
        String newName = faker.buffy().characters();
        return newName;
    }

    public String randomPlaylistName() {
        Faker faker = new Faker();
        String newName = faker.cat().breed();
        return newName;
    }
    public String generateRandomName() {
        Faker faker = new Faker();
        String newName = faker.funnyName().name();
        return newName;
    }
    public String getProfileNameText () {
        wait.until(ExpectedConditions.visibilityOf(actualProfileName));
        return actualProfileName.getText();
    }
}
