package Login_Functionality;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.Assert.assertEquals;
public class LoginPage {
    @FindBy(xpath = "//div/h2[text()=\"Login\"]")
    WebElement loginpage;
    @FindBy(id = "username")
    WebElement txtUsername;
    @FindBy(id = "password")
    WebElement txtpassword;
    @FindBy(id = "login-btn")
    WebElement loginbtnclick;
    @FindBy(id = "manga-search")
    WebElement manga_search;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void doLogin(String username, String password) throws InterruptedException {
        //Verify that the login page is displayed.
        String loginpageText = loginpage.getText();
        System.out.println(loginpageText);
        String expectedloginText = "Login";
        assertEquals(loginpageText, expectedloginText, "The text does not match!");
        Thread.sleep(3000);

        //Enter valid login credentials (e.g., testuser and password).
        txtUsername.sendKeys(username);
        txtpassword.sendKeys(password);
        loginbtnclick.click();
        Thread.sleep(3000);

        //Verify that the user is redirected to the manga search page.
        String searchpageText = manga_search.getAttribute("placeholder");
        System.out.println(searchpageText);
        String searchpageTextText = "Search Manga";
        assertEquals(searchpageText, searchpageTextText, "The text does not match!");
        System.out.println("Pass >> Verify that the login functionality works correctly.");
    }
}
