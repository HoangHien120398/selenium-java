package internet;

import internet.pages.InteractionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class InteractionTest {
    InteractionPage interactionPage;

    @BeforeMethod
    void setup() {
        interactionPage = new InteractionPage();
        Browser.openBrowser("chrome");
    }

    @Test
    void hoverToImage() {
        interactionPage.openHoverToImage();

        interactionPage.hoverToImage();

        Assert.assertEquals(interactionPage.getImageProfile(), "name: user1");
    }

    @Test
    void dragDropElements() {
        interactionPage.openDragDropElements();

        Assert.assertEquals(interactionPage.getLabelDragDropElement("a"), "A");
        Assert.assertEquals(interactionPage.getLabelDragDropElement("b"), "B");

        interactionPage.dragDrop();

        Assert.assertEquals(interactionPage.getLabelDragDropElement("a"), "B");
        Assert.assertEquals(interactionPage.getLabelDragDropElement("b"), "A");
    }

    @Test
    void horizontalSliderThrowEx() throws InterruptedException {
        interactionPage.openSliderUrl();
        interactionPage.clickAndHoldSilder();
        Browser.waitTime(60);

        Assert.assertTrue(interactionPage.waitUntilVisibleText("5"));
    }

    @Test
    void scrollDown() throws InterruptedException {
        interactionPage.openScrollBarUrl();
        Browser.scrollBar();
    }

    @Test
    void rightClick() {
        interactionPage.openRightClickUrl();
        interactionPage.rightClickContext();
    }

    @Test
    void keyPress() {
        interactionPage.openKeyPressUrl();

        Actions actions = Browser.getActions();
        actions.keyDown(Keys.COMMAND).perform();
        Assert.assertEquals(interactionPage.getResultWhenCLickContent(), "You entered: WIN");

        actions.keyDown("A").perform();
        Assert.assertEquals(interactionPage.getResultWhenCLickContent(), "You entered: A");

        actions.keyDown(Keys.ENTER).perform();
        Assert.assertEquals(interactionPage.getResultWhenCLickContent(), "You entered: ENTER");

    }
    @Test
    void dynamicLoading() throws InterruptedException {
        interactionPage.opendynamicLoadingUrl();
        interactionPage.startLoading();

        Browser.waitTime(10);
        interactionPage.waitUntilCompleteLoading();

        Assert.assertEquals(interactionPage.getResultAfterCompleteLoading(),"Hello World!");
    }

//    @Test
//    void captureScreenShot(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/context_menu");
//
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File destFile = new File(String.format("target/screenshot-%s-%s.png", "context-menu", System.currentTimeMillis()));
//        try {
//            FileUtils.copyFile(srcFile, destFile);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    @AfterMethod
    void tearDown() {
        Browser.quit();
    }

}
