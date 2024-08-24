package Manga_Search_and_Display;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class Details_Model {

    @FindBy(id = "username")
    WebElement txtUsername;
    @FindBy(id = "password")
    WebElement txtpassword;
    @FindBy(id = "login-btn")
    WebElement loginbtnclick;
    @FindBy(id = "manga-search")
    WebElement manga_search;

    @FindBy(xpath = "(//p/span[text()=\"Details\"])[1]")
    WebElement Detailsbtn;


    @FindBy(xpath = "//div[@class=\"bg-white p-6 rounded-lg shadow-lg w-96\"]")
    WebElement Modalpopup;

    @FindBy(xpath = "(//div/h3[text()=\"Attack on Titan\"])[2]")
    WebElement modal_name;

    @FindBy(xpath = "//div/p[text()=\"Humanity fights for survival against giant humanoid Titans that have brought civilization to the brink of extinction.\"]")
    WebElement modal_sum;

    @FindBy(xpath = "(//img[@alt='Attack on Titan'])[2]")
    WebElement modal_image;

    @FindBy(xpath = "//button[contains(.,'Close')]")
    WebElement modal_close;

    public Details_Model(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void DetailsModel(String username, String password) throws InterruptedException {

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
        Thread.sleep(2000);

        //Verify that the modal appears
        Detailsbtn.click();
        Modalpopup.isDisplayed();
        System.out.println("popup is displayed");

       //Verify that the modal name
        String ModalnameText = modal_name.getText();
        System.out.println(ModalnameText);
        String ModalnameTextText = "Attack on Titan";
        assertEquals(ModalnameText, ModalnameTextText, "The text does not match!");
        Thread.sleep(2000);

       //Verify that the modal summary
        String summaryText = modal_sum.getText();
        System.out.println(summaryText);
        String summaryTextText = "Humanity fights for survival against giant humanoid Titans that have brought civilization to the brink of extinction.";
        assertEquals(summaryText, summaryTextText, "The text does not match!");
        Thread.sleep(2000);

        //Verify that the modal summary image
        boolean isImageDisplayed = modal_image.isDisplayed();
        Assert.assertTrue(isImageDisplayed, "The image is not displayed on the page.");
        String expectedImageSrc = "https://res.cloudinary.com/emerging-it/image/upload/v1724240584/mangaImage/lyj3i7qwtp3f2qz59so1.jpg";
        String actualImageSrc = modal_image.getAttribute("src");
        Assert.assertEquals(actualImageSrc, expectedImageSrc, "The image source does not match the expected source.");

        modal_close.click();




        }





}
