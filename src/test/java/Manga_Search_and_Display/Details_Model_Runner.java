package Manga_Search_and_Display;

import Manga_Details_Modal.Manga_Search;
import Setup_Page.Setup_Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Details_Model_Runner extends Setup_Page {

    @Test(priority = 3,description = "Verify that the modal displays the correct manga details.")
    public void MangaSearch() throws InterruptedException {

        Details_Model details_model = new Details_Model(driver);
        details_model.DetailsModel("testuser", "password");

        //Verify that the modal is closed and no longer visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isModalInvisible = wait.until(ExpectedConditions.invisibilityOf(details_model.Modalpopup));

        if (isModalInvisible) {
            System.out.println("Pass >> The modal is closed and no longer visible.");
        } else {
            System.out.println("Fail >> The modal is still visible.");
        }
    }
}
