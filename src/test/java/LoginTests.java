import POM.HomePage;
import POM.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTests extends BaseTest {

    @Test (enabled = true, priority = 0, description = "Login with valid email and valid password")
    public void loginValidEmailPassword()  {
       // Implement pages from POM, create new objects for each page
        LoginPage loginpage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //call methods from POM pages
        loginpage.login();
        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }

    @Test (enabled = true, priority = 1, description = "Login with invalid email and valid password")
    public void loginInvalidEmail() {
        // Implement pages from POM, create new objects for each page
        LoginPage loginPage = new LoginPage(driver);
        //Call methods from POM pages
        loginPage.provideEmail("Incorrect@testpro.io");
        loginPage.providePassword("P!990109189300ok");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test (enabled = true, priority = 3, description = "Login with valid email and empty password")
    public void loginEmptyPassword() {
        // Implement pages from POM, create new objects for each page
        LoginPage loginPage = new LoginPage(driver);
        //Call methods from POM pages
        loginPage.provideEmail("kelly.wade@testpro.io");
        loginPage.providePassword("");
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    @Test (dataProvider = "IncorrectLoginData", dataProviderClass = TestDataProvider.class)
    //Above:  Calls the data provider set by name, calls the class where the data provider set is located

    public void NegativeTesting (String email, String password) {
        // Implement pages from POM, create new objects for each page
        LoginPage loginPage = new LoginPage(driver);
        //Call methods from POM pages
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmit();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }
}