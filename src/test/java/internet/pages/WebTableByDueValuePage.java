package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WebTableByDueValuePage {
    public void open() {
        Browser.visit("https://the-internet.herokuapp.com/tables");
    }
    public int getMaxDueValue(){
        List<Double> dueValue = Browser.getElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .map(cell -> Double.parseDouble(cell.getText().replace("$","")))
                .collect(Collectors.toList());
        Double maxDueValue = dueValue.stream().max(Comparator.naturalOrder()).get();
        return dueValue.indexOf(maxDueValue);
    }

    public String getLastName(int maxDueIndex){
        return Browser.getElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]",maxDueIndex+1))).getText();
    }

    public String getFirstName(int maxDueIndex){
        return Browser.getElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]",maxDueIndex+1))).getText();
    }
}
