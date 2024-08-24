package Manga_Details_Modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class Manga_Search {

    @FindBy(id = "username")
    WebElement txtUsername;
    @FindBy(id = "password")
    WebElement txtpassword;
    @FindBy(id = "login-btn")
    WebElement loginbtnclick;
    @FindBy(id = "manga-search")
    WebElement manga_search;
    @FindBy(xpath = "//button[text()=\"Search\"]")
    WebElement Searchbtn;

    @FindBy(id = "manga-name")
    WebElement Search_Result;


    @FindBy(xpath = "//p[text()=\"No manga found\"]")
    WebElement No_Found_Result;

    public Manga_Search(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void MangaSearch(String username, String password) throws InterruptedException {

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

        manga_search.sendKeys("Naruto");
        Searchbtn.click();
        //Verify that manga cards with the name "Naruto" are displayed.
        Search_Result.isDisplayed();
        String Search_Result_show = Search_Result.getText();
        System.out.println(Search_Result_show);
        String Search_Result_showText = "Naruto";
        assertEquals(Search_Result_show, Search_Result_showText, "The Naruto text does not match!");
        Thread.sleep(3000);

        manga_search.clear();
        manga_search.sendKeys("One Piece");
        Searchbtn.click();
        //Verify that manga cards with the name "One Piece" are displayed.
        Search_Result.isDisplayed();
        String Search_Result_show_1 = Search_Result.getText();
        System.out.println(Search_Result_show_1);
        String Search_Result_showText_1 = "One Piece";
        assertEquals(Search_Result_show_1, Search_Result_showText_1, "The One Piece text does not match!");
        Thread.sleep(3000);

        manga_search.clear();
        manga_search.sendKeys("Seven Deadly Sins");
        Searchbtn.click();
        //Verify that a "No manga found" message is displayed.
        No_Found_Result.isDisplayed();
        String Search_Result_show_2 = No_Found_Result.getText();
        System.out.println(Search_Result_show_2);
        String Search_Result_showText_2 = "No manga found";
        assertEquals(Search_Result_show_2, Search_Result_showText_2, "The No manga found text does not match!");
        Thread.sleep(3000);


    }


}
