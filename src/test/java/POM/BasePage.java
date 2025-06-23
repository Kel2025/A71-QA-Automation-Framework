package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// Page of objects for Koel app

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;


    // Locators
    By allSongsList = By.cssSelector("li a.songs");
    By soundBarVisualizer = By.cssSelector("[data-testid = 'sound-bar-play']");

    //Methods

    public BasePage ( WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }
    // Method for finding elements with explicit wait. This will be passed on to child pages, eliminates repetition
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void click (By locator) {wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();}
    public void doubleClick (By locator) {actions.doubleClick(findElement(locator)).perform(); }
    public void chooseAllSongsList() {click(allSongsList);}
    public boolean isSongPlaying() {return findElement(soundBarVisualizer).isDisplayed();}
}

