import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        //Test Steps
        //Step 1 navigate to koel app
        navigateUrl();
        //Step 2 enter email
        provideEmail("kelly.wade@testpro.io");
        //Step 3 enter password
        providePassword("P!990109189300ok");
        //Step 4 click submit button
        clickSubmit();
        Thread.sleep(2000);
        //Step 5 verify user is logged in
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void loginInvalidEmail() throws InterruptedException {
        // Test Steps
        //Step 1 : Open koel login page
        navigateUrl();
        //Step 2: Enter non existing email
        provideEmail("Incorrect@testpro.io");
        //Step 3: Enter correct Password
        providePassword("P!990109189300ok");
        //Step 4: Click Login Button
        clickSubmit();
        Thread.sleep(2000);
        //Step 5: Verify user remains on login page
        WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        Assert.assertTrue(registrationLink.isDisplayed());
    }

    @Test
    public void loginEmptyPassword() throws InterruptedException {

        navigateUrl();
        provideEmail("kelly.wade@testpro.io");
        clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }




}