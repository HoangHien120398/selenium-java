package internet;

import internet.pages.HyperLinkPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class HyperLinkTest {
    HyperLinkPage hyperLinkPage;
    @BeforeMethod
    public void setup(){
        Browser.openBrowser("chrome");
        hyperLinkPage = new HyperLinkPage();
        hyperLinkPage.open();
    }

    @Test
    public void redirector(){
        //Open redirect page

        hyperLinkPage.clickHyperLink();
        Assert.assertTrue(hyperLinkPage.assertCurrentUrl("https://the-internet.herokuapp.com/status_codes"));

        //Open 200 page
        hyperLinkPage.click("200");
        Assert.assertTrue(hyperLinkPage.assertCurrentUrl("https://the-internet.herokuapp.com/status_codes/200"));
        String content200 = hyperLinkPage.getContent();
        Assert.assertTrue(hyperLinkPage.checkContainWithText(content200,"This page returned a 200 status code."));
        hyperLinkPage.back();

        //Open 301 page
        hyperLinkPage.click("301");
        Assert.assertTrue(hyperLinkPage.assertCurrentUrl("https://the-internet.herokuapp.com/status_codes/301"));
        String content301 = hyperLinkPage.getContent();
        Assert.assertTrue(hyperLinkPage.checkContainWithText(content301,"This page returned a 301 status code."));
        hyperLinkPage.back();


//        //Open 404 page
        hyperLinkPage.click("404");
        Assert.assertTrue(hyperLinkPage.assertCurrentUrl("https://the-internet.herokuapp.com/status_codes/404"));
        String content404 = hyperLinkPage.getContent();
        Assert.assertTrue(hyperLinkPage.checkContainWithText(content404,"This page returned a 404 status code."));
        hyperLinkPage.back();

//        //Open 500 page
        hyperLinkPage.click("500");
        Assert.assertTrue(hyperLinkPage.assertCurrentUrl("https://the-internet.herokuapp.com/status_codes/500"));
        String content500 = hyperLinkPage.getContent();
        Assert.assertTrue(hyperLinkPage.checkContainWithText(content500,"This page returned a 500 status code."));
        hyperLinkPage.back();
    }

    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }
}
