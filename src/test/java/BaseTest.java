import PageFactory.BasePage;
import PageFactory.HomePage;
import PageFactory.LoginPage;
import PageFactory.ProfilePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = null;
    public static Actions actions = null;
    static WebDriverWait wait;

    @BeforeSuite
//    static void setupClass() {
//          WebDriverManager.chromedriver().setup();
//      //  WebDriverManager.firefoxdriver().setup();
//    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public static void launchBrowser(String baseURL) throws MalformedURLException {

        driver = pickBrowser(System.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // maximize window so all elements are visible
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        url = baseURL;
        navigateUrl();
    }
    public static void navigateUrl() {driver.get(url); }


    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Selenium Grid Setup
    public static WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        String gridURL = "http://192.168.1.67:4444/";
        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-firefox":
                cap.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), cap);
            case "grid-edge":
                cap.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), cap);
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }
}