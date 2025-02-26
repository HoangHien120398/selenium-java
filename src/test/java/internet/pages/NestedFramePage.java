package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

public class NestedFramePage {
    public void open(){
        Browser.visit("https://the-internet.herokuapp.com/nested_frames");
    }
    public void switchToFrame(String name){
        Browser.switchFrame(name);
    }
    public String getContent(){
        return Browser.getElement(By.xpath("/html/body")).getText();
    }
    public String getContentMiddle(){
        return Browser.getElement(By.id("content")).getText();
    }
    public void switchToParentFrame(){
        Browser.switchToParent();
    }
    public void switchToDefaultContent(){
        Browser.switchToDefault();
    }
}
