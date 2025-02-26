package internet;

import internet.pages.NestedFramePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class NestedFrameTest {
    NestedFramePage nestedFramePage;

    @BeforeMethod
    void setup() {
        Browser.openBrowser("chrome");
        nestedFramePage = new NestedFramePage();
        nestedFramePage.open();
    }

    @Test
    public void testFrame() {
        nestedFramePage.switchToFrame("frame-top");
        nestedFramePage.switchToFrame("frame-left");
        Assert.assertTrue(nestedFramePage.getContent().contains("LEFT"));

        nestedFramePage.switchToParentFrame();
        nestedFramePage.switchToFrame("frame-middle");
        Assert.assertEquals(nestedFramePage.getContentMiddle(), "MIDDLE");

        nestedFramePage.switchToParentFrame();
        nestedFramePage.switchToFrame("frame-right");
        Assert.assertEquals(nestedFramePage.getContent(), "RIGHT");

        nestedFramePage.switchToDefaultContent();
        nestedFramePage.switchToFrame("frame-bottom");
        Assert.assertEquals(nestedFramePage.getContent(), "BOTTOM");
    }

    @AfterMethod
    void tearDown() {
        Browser.quit();
    }

}
