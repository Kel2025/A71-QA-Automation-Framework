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
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public static WebDriver driver = null;
    public static String url = null;
    public static WebDriverWait wait;
    public static Actions actions = null;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();


    @BeforeMethod
    @Parameters({"BaseURL"})
    // setup and open a browser before each test
    public void setupBrowser (String baseURL) throws MalformedURLException {
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();

        url = baseURL;
        navigateUrl();
    }

    public static void navigateUrl() {getDriver().get(url); }

    @AfterMethod
    // closes driver and removes it from thread
    public void tearDown () {
        threadDriver.get().close();
        threadDriver.remove();
    }

    // Selenium Grid Setup
    public  WebDriver pickBrowser (String browser) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        String gridURL = "http://192.168.1.67:4444/";
        switch (browser) {
            case "firefox": // gradle clean test -Dbrowser=firefox
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "MicrosoftEdge": // gradle clean test -Dbrowser=MicrosoftEdge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-firefox": // gradle clean test -Dbrowser=grid-firefox
                cap.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), cap);
            case "grid-edge": // gradle clean test -Dbrowser=grid-edge
                cap.setCapability("browserName", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), cap);
            case "grid-chrome": // gradle clean test -Dbrowser=grid-chrome
                cap.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), cap);
            case "cloud": // gradle clean test -Dbrowser=cloud
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }

    public WebDriver lambdaTest() throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("beta");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "kellywade");
        ltOptions.put("accessKey", "LT_KY46gBJQTyHaG1foCgetrP3C7F2txOdcXNq9z9XOa5PgLeI");
        ltOptions.put("project", "Homework25");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

}