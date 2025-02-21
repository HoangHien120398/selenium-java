package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

public class JavaScripAlertPage {



    public void clickButton(String clickForJS){
        Browser.click(By.xpath(String.format("//button[.='Click for JS %s']",clickForJS)));

//        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
//        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
//        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
    }

    public String getResult(){
        return Browser.getText(By.id("result"));
    }

    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/javascript_alerts");
    }

}
