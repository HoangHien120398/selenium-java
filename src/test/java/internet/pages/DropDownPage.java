package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class DropDownPage {
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/dropdown");
    }

    public void select(String option){
        Select select = new Select(Browser.getElement(By.id("dropdown")));
        select.selectByValue("1");
    }

    public boolean isSelect(String option){
        String locatorDropdown = String.format("option[value='%s']",option);
        return Browser.isSelected(By.cssSelector(locatorDropdown));
    }
}
