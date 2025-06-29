package PageFactory;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    static WebDriverWait wait;
    Actions actions;

    public BasePage (WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement findElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    @FindBy(css = "div.success.show")
    WebElement successMsg;
    @FindBy(css = "span[class='name']")
    WebElement actualProfileName;

    public void click (WebElement webElement) {findElement(webElement).click();}
    public void doubleClick (WebElement webElement) { actions.doubleClick(findElement(webElement)).perform();}
    public void contextClick (WebElement webElement) { actions.contextClick(findElement(webElement)).perform();}

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
        return actualProfileName.getText();
    }
}
