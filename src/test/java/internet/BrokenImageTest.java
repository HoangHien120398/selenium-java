package internet;

import internet.pages.BrokenImagePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class BrokenImageTest {
    BrokenImagePage brokenImagePage;
    @BeforeMethod
    void setup(){
        Browser.openBrowser("chrome");
        brokenImagePage = new BrokenImagePage();
        brokenImagePage.open();
    }

    @Test
    void verifyBrokenImage(){
        brokenImagePage.checkLoadedImage();
    }

    @AfterMethod
    void tearDown(){
        Browser.quit();
    }
}
