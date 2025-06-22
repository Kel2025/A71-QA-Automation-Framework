import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;



public class BaseTest {

    public WebDriver driver = null;
    public String url = null;
    public Actions actions = null;
    WebDriverWait wait;


    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})


    public void launchBrowser(String baseURL) {
        // Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // maximize window so all elements are visible
        driver.manage().window().maximize();
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        //switching to explicit wait
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        //switching to explicit wait
        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginBtn() {
        //WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        //switching to explicit wait
        WebElement loginBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        loginBtn.click();
    }

    public void login() {
        provideEmail("kelly.wade@testpro.io");
        providePassword("P!990109189300ok");
        clickLoginBtn();
    }

    public String generateRandomPlaylistName() {
        Faker faker = new Faker();
        String newName = faker.buffy().characters();
        return newName;
    }
}