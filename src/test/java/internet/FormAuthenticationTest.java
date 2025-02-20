package internet;

import internet.pages.FormAuthenticationPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import static supports.Browser.*;

public class FormAuthenticationTest {
    FormAuthenticationPage formAuthenticationPage;
    @DataProvider
    Object[][] testData(){
        return new Object[][]{
                {"tomsmith","SuperSecretPassword!","https://the-internet.herokuapp.com/secure","success","You logged into a secure area!"},
                {"tomsmith1","SuperSecretPassword","https://the-internet.herokuapp.com/login","error","Your username is invalid!"},
                {"tomsmith","SuperSecretPassword1","https://the-internet.herokuapp.com/login","error","Your password is invalid!"},
                {"","SuperSecretPassword","https://the-internet.herokuapp.com/login","error","Your username is invalid!"},
                {"tomsmith","","https://the-internet.herokuapp.com/login","error","Your password is invalid!"},
        };
    }

    @Parameters({"browser","url"})
    @BeforeMethod
    void setUp(String browser, String url){
        openBrowser(browser);
        formAuthenticationPage = new FormAuthenticationPage();
        formAuthenticationPage.open(url+"/login");
    }

    @Test(dataProvider = "testData")
    public void authenticationFormTest(String username, String password, String expectedUrl, String expectedMessageType,String expectedMessageCentent ){

        formAuthenticationPage.login(username,password);

        Assert.assertEquals(getCurrentUrl(),expectedUrl);
        Assert.assertTrue(formAuthenticationPage.isMessageContains(expectedMessageType,expectedMessageCentent));
    }

    @AfterMethod
    void tearDown(ITestResult iTestResult){
        if(!iTestResult.isSuccess()){
            captureScreen(iTestResult.getName());
        }
        quit();
    }
}
