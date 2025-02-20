package internet;

import internet.pages.DropDownFruitsPage;
import internet.pages.DropDownPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class DropdownTest {

    @BeforeMethod
    public void setUp(){
        Browser.openBrowser("chrome");
    }

    @Test
    public void ableSelectOptions(){
        DropDownPage dropDownPage = new DropDownPage();
        dropDownPage.open();
        dropDownPage.select("1");

        Assert.assertTrue(dropDownPage.isSelect("1"));
    }

    @Test
    void ableSelectMulipleOptions(){
        DropDownFruitsPage dropDownFruitsPage = new DropDownFruitsPage();
        dropDownFruitsPage.open();

        dropDownFruitsPage
                .select("Banana")
                .select("Grape");

        Assert.assertTrue(dropDownFruitsPage.isSelectedMultiple());
        Assert.assertTrue(dropDownFruitsPage.isSelect("Banana"));
        Assert.assertTrue(dropDownFruitsPage.isSelect("Grape"));
        Assert.assertFalse(dropDownFruitsPage.isSelect("Orange"));
        Assert.assertFalse(dropDownFruitsPage.isSelect("Apple"));

        dropDownFruitsPage.deSelect("Banana");
        Assert.assertFalse(dropDownFruitsPage.isSelect("Banana"));
        Assert.assertTrue(dropDownFruitsPage.isSelect("Grape"));
        Assert.assertFalse(dropDownFruitsPage.isSelect("Orange"));
        Assert.assertFalse(dropDownFruitsPage.isSelect("Apple"));

        dropDownFruitsPage.deSelectAll();
        Assert.assertFalse(dropDownFruitsPage.isSelect("Banana"));
        Assert.assertFalse(dropDownFruitsPage.isSelect("Grape"));
        Assert.assertFalse(dropDownFruitsPage.isSelect("Orange"));
        Assert.assertFalse(dropDownFruitsPage.isSelect("Apple"));
    }

    @AfterMethod
    public void tearDown(){
        Browser.quit();
    }
}
