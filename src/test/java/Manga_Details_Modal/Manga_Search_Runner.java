package Manga_Details_Modal;

import Login_Functionality.LoginPage;
import Setup_Page.Setup_Page;
import org.testng.annotations.Test;

public class Manga_Search_Runner extends Setup_Page {


    @Test(priority = 2,description = "Verify that searching for manga returns the correct results")
    public void MangaSearch() throws InterruptedException {

        Manga_Search mangaSearch = new Manga_Search(driver);
        mangaSearch.MangaSearch("testuser", "password");
    }
}
