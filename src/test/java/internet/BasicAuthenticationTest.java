package internet;

import internet.pages.BasicAuthenticationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v129.page.model.WebAppManifest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class BasicAuthenticationTest {
    @BeforeMethod
    void setup(){
        Browser.openBrowser("chrome");
    }

    @Test
    void loginSuccess(){
        BasicAuthenticationPage basicAuthenticationPage = new BasicAuthenticationPage();
        basicAuthenticationPage.open();

        Assert.assertTrue(basicAuthenticationPage.checkContainWithText("Congratulations! You must have the proper credentials."));
    }

    @AfterMethod
    void tearDown(){
        Browser.quit();
    }
}
