import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;


public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //navigate to url
        String url = "https://qa.koel.app/";
        driver.get(url);

        // Click registration link
        WebElement registrationLink = driver.findElement(By.cssSelector("a[href^=\"registration\"]"));
        registrationLink.click();
        //Verify that you are redirected to Registration page using Assert method
        WebElement registrationPage = driver.findElement(By.cssSelector("span[class=\"small\"]"));
        Assert.assertTrue(registrationPage.isDisplayed());
        driver.quit();
    }
}


