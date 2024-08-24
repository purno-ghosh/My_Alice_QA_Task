package Setup_Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup_Page {
    protected WebDriver driver;
    //WebDriver driver;
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://myalice-automation-test.netlify.app/");
    }
    @AfterTest
    public void close() {
        driver.close();
    }
}
