import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileName() throws InterruptedException {

        //Navigate to Koel app
        navigateUrl();
        //provide email
        provideEmail("kelly.Wade@testpro.io");
        //provide password
        providePassword("P!990109189300ok");
        //click submit
        clickSubmit();
        String randomName = randomName();
        //pause for 2 seconds for page to load
        Thread.sleep(2000);
        //click avatar icon to go to profile setting page
        clickAvatarIcon();
        //provide current Password
        provideCurrentPassword("P!990109189300ok");
        //provide profile name
        provideProfileName(randomName);
        //click save button
        clickSaveButton();
        //wait 2 seconds
        Thread.sleep(2000);
        //verify profile name change
        WebElement actualProfileName = driver.findElement(By.cssSelector("span[class='name']"));
        Assert.assertEquals(actualProfileName.getText(),randomName);
    }
}
