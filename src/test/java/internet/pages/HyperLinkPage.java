package internet.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import supports.Browser;

public class HyperLinkPage {
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/redirector");
    }
    public void clickHyperLink(){
        Browser.click(By.xpath("*//a[@id='redirect']"));
    }

    public boolean assertCurrentUrl(String expectedUrl){
        if(Browser.getCurrentUrl().equals(expectedUrl)) {
            return true;
        }
        return false;
    }

    public void click(String httpCode){
        By hyperLinkLocator = By.linkText(String.format("%s",httpCode));
        Browser.getElement(hyperLinkLocator).click();
    }
    public String getContent(){
       return Browser.getText(By.id("content"));
    }
    public boolean checkContainWithText(String content, String withText){
        if(content.contains(withText)==true)
            return true;
        return false;
    }
    public void back(){
        Browser.click(By.linkText("here"));
    }

}
