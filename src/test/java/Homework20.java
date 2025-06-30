import PageFactory.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest{

    @Test (dataProvider = "ValidLoginData", dataProviderClass = TestDataProvider.class)
    public void deletePlaylist(String email, String password) {
        String expectedPlaylistDeletedMsg = "Deleted playlist \"Delete This.\"";

        LoginPage loginPage = new LoginPage(driver);

        navigateUrl();
        // Log in to Koel app
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmit();
        // Select playlist to be deleted
        clickPlaylist();
        // Click on the delete playlist button
        clickDeletePlaylistButton();
        // Verify confirmation notification of successful delete
        Assert.assertEquals(getDeletedPlaylistSuccessMsg(), expectedPlaylistDeletedMsg);
    }

    // Select playlist from side menu
    public void clickPlaylist () {
       // WebElement playlist = driver.findElement(By.xpath("//section[@id='playlists']//a[contains(text(), 'Delete This')]"));
       //explicit wait
        WebElement playlist = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "//section[@id='playlists']//a[contains(text(), 'Delete This')]")));
        playlist.click();
    }

    // Click the red delete playlist button
    public void clickDeletePlaylistButton () {
        //WebElement deletePlaylistButton = driver.findElement(By.cssSelector("button[class=\"del btn-delete-playlist\"]"));
        //explicit wait
        WebElement deletePlaylistButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
                        "button[class=\"del btn-delete-playlist\"]")));
        deletePlaylistButton.click();
    }

    // Get the notification for successful playlist delete
    public String getDeletedPlaylistSuccessMsg() {
        //WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
        // explicit wait
        WebElement notification = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

}
