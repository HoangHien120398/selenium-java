package internet;

import internet.pages.CheckboxesPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static supports.Browser.*;

public class CheckboxesTest {
    CheckboxesPage checkboxesPage;

    @Parameters({"browser","url"})
    @BeforeMethod
    void setup(String browser, String url) {
        openBrowser(browser);
        checkboxesPage = new CheckboxesPage();
        checkboxesPage.open(url + "/checkboxes");
    }

    @Test
    void verifyAbleSelectCheckboxes(){
        checkboxesPage.ableSelectCheckbox();
        Assert.assertTrue(checkboxesPage.checkSelectedCheckbox1());
        Assert.assertTrue(checkboxesPage.checkSelectedCheckbox2());
    }

    @Test
    void verifyAbleUnSelectCheckboxes(){
        checkboxesPage.ableUnSelectCheckbox();
        Assert.assertFalse(checkboxesPage.checkSelectedCheckbox1());
        Assert.assertFalse(checkboxesPage.checkSelectedCheckbox2());
    }

    @AfterMethod
    public void tearDown(){
        quit();
    }
}
