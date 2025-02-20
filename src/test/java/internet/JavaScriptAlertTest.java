package internet;

import internet.pages.JavaScripAlertPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class JavaScriptAlertTest {
    JavaScripAlertPage javaScripAlertPage;
    @BeforeMethod
    void setup(){
        Browser.openBrowser("chrome");
        javaScripAlertPage = new JavaScripAlertPage();
        javaScripAlertPage.open();
    }

    @Test
    void ableClickJSAlert(){
        javaScripAlertPage.clickButton("Alert");
        Browser.acceptAlert();

        Assert.assertEquals(javaScripAlertPage.getResult(),"You successfully clicked an alert");
    }

    @Test
    void ableCancelJSConfirm(){
        javaScripAlertPage.clickButton("Confirm");
        Browser.cancelAlert();

        Assert.assertEquals(javaScripAlertPage.getResult(),"You clicked: Cancel");
    }

    @Test
    void ableAcceptJSConfirm(){
        javaScripAlertPage.clickButton("Confirm");
        Browser.acceptAlert();

        Assert.assertEquals(javaScripAlertPage.getResult(),"You clicked: Ok");
    }
    
    @Test
    void ableSendKeysInJSPrompt(){
        javaScripAlertPage.clickButton("Prompt");
        Browser.acceptAlert("hell");

        Assert.assertEquals(javaScripAlertPage.getResult(),"You entered: hell");
    }

    @AfterMethod
    void tearDown(){
        Browser.quit();
    }
}
