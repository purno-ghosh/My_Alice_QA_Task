package Login_Functionality;
import Setup_Page.Setup_Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;
import static org.testng.Assert.assertEquals;

public class Login_Page_Runner extends Setup_Page {

    @Test(priority = 1,description = "Verify that the login functionality works correctly.")
    public void doLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("testuser", "password");
    }
}
