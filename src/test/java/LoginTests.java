import PageFactory.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test (enabled = true, priority = 0, description = "Login with valid email and valid password")
    public void loginValidEmailPassword()  {
       // Implement pages from PageFactory, create new objects for each page
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        //call methods from PageFactory pages
        loginPage.provideEmail("kelly.wade@testpro.io").providePassword("P!990109189300ok").clickSubmit();
        Assert.assertTrue(homePage.getUserAvatarIcon());
    }

    @Test (enabled = true, priority = 1, description = "Login with invalid email and valid password")
    public void loginInvalidEmail() {
        // Implement pages from PageFactory, create new objects for each page
        LoginPage loginPage = new LoginPage(getDriver());
        //Call methods from PageFactory pages
        loginPage.provideEmail("Incorrect@testpro.io").providePassword("P!990109189300ok").clickSubmit();
        Assert.assertTrue(loginPage.registrationLinkIsDisplayed());
    }

    @Test (enabled = true, priority = 2, description = "Login with valid email and empty password")
    public void loginEmptyPassword() {
        // Implement pages from PageFactory, create new objects for each page
        LoginPage loginPage = new LoginPage(getDriver());
        //Call methods from PageFactory pages
        loginPage.provideEmail("kelly.wade@testpro.io")
                .providePassword("")
                .clickSubmit();
        Assert.assertTrue(loginPage.registrationLinkIsDisplayed());
    }

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = TestDataProvider.class)
    //Above:  Calls the data provider set by name, calls the class where the data provider set is located

    public void NegativeTesting (String email, String password) {
        // Implement pages from PageFactory, create new objects for each page
        LoginPage loginPage = new LoginPage(getDriver());
        //Call methods from PageFactory pages
        loginPage.provideEmail(email)
                .providePassword(password)
                .clickSubmit();
        Assert.assertTrue(loginPage.registrationLinkIsDisplayed());
    }
}
