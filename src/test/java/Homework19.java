import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test (dataProvider = "ValidLoginData", dataProviderClass = TestDataProvider.class)
    public void deletePlaylist(String email, String password) throws InterruptedException {
        String expectedPlaylistDeletedMsg = "Deleted playlist \"Delete This.\"";

        navigateUrl();
        // Log in to Koel app
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        // Select playlist to be deleted
        clickPlaylist();
        // Click on the delete playlist button
        clickDeletePlaylistButton();
        // Verify confirmation notification of successful delete
        Thread.sleep(2000);
        Assert.assertEquals(getDeletedPlaylistSuccessMsg(), expectedPlaylistDeletedMsg);
    }
}
