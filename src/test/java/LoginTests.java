import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test (enabled = true, priority = 0, description = "Login with valid email and valid password")
    public void loginValidEmailPassword() throws InterruptedException {
        //Test Steps
        //Step 1 navigate to koel app
        navigateUrl();
        //Step 2 enter email
        provideEmail("kelly.wade@testpro.io");
        //Step 3 enter password
        providePassword("P!990109189300ok");
        //Step 4 click submit button
        clickLoginBtn();
        //Thread.sleep(2000);
        //Step 5 verify user is logged in
        isAvatarDisplayed();
    }

    @Test (enabled = true, priority = 1, description = "Login with invalid email and valid password")
    public void loginInvalidEmail() throws InterruptedException {
        // Test Steps
        //Step 1 : Open koel login page
        //navigateUrl();
        //Step 2: Enter non existing email
        provideEmail("Incorrect@testpro.io");
        //Step 3: Enter correct Password
        providePassword("P!990109189300ok");
        //Step 4: Click Login Button
        clickLoginBtn();
        //Thread.sleep(2000);
        //Step 5: Verify user remains on login page
        isRegistrationLinkDisplayed();
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public void loginEmptyPassword() throws InterruptedException {

        navigateUrl();
        provideEmail("kelly.wade@testpro.io");
        clickLoginBtn();
       // Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = TestDataProvider.class)
    //Above:  Calls the data provider set by name, calls the class where the data provider set is located

    public void NegativeTesting (String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickLoginBtn();
       // Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    // explicit wait for avatar icon to be visible
    public void isAvatarDisplayed() {
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        //added explicit wait
        WebElement avatarIcon = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    public void isRegistrationLinkDisplayed() {
       // WebElement registrationLink = driver.findElement(By.cssSelector("a[href='registration']"));
        //added explicit wait
        WebElement registrationLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("a[href='registration']")));
        Assert.assertTrue(registrationLink.isDisplayed());
    }

}