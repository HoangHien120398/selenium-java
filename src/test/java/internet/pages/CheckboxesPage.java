package internet.pages;

import org.openqa.selenium.By;
import static supports.Browser.*;

public class CheckboxesPage {
    private By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    private By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    public void open(String url){
        visit(url);
    }
    public void ableSelectCheckbox(){
        check(checkbox1);
        check(checkbox2);
    }
    public void ableUnSelectCheckbox(){
        uncheck(checkbox1);
        uncheck(checkbox2);
    }
    public boolean checkSelectedCheckbox1(){
        return assertSelected(checkbox1);
    }
    public boolean checkSelectedCheckbox2(){
        return assertSelected(checkbox2);
    }
}
