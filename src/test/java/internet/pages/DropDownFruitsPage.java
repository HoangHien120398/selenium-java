package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import supports.Browser;

public class DropDownFruitsPage {
    Select select;

    public DropDownFruitsPage() {
        open();
        select = new Select(Browser.getElement(By.id("fruits")));
    }

    public void open() {
        Browser.visit("https://output.jsbin.com/osebed/2");
    }

    public DropDownFruitsPage select(String option) {
        select.selectByVisibleText(option);
        return this;
    }

    public DropDownFruitsPage deSelect(String option) {
        select.deselectByVisibleText(option);
        return this;
    }

    public void deSelectAll() {
        select.deselectAll();
    }

    public boolean isSelectedMultiple() {
        return select.isMultiple();
    }

    public boolean isSelect(String option) {
        String locatorDropdown = String.format("//option[.='%s']", option);
        return Browser.isSelected(By.xpath(locatorDropdown));
    }
}
