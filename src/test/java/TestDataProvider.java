import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest {
    @DataProvider(name = "IncorrectLoginData")
    public static Object[][] negativeTestData() {
        // 'static' allows us to call this from another class, in this case LoginTests.java
        return new Object[][] {
                {"invalid@testpro.io", "invalidPassword"},
                {"wrongemail@testpro.io", "wrongPassword"},
                {"invalid@testpro.io", ""},
                {"", "P!990109189300ok"},
                {"",""}
        };
    }
}
