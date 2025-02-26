package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

public class InteractionPage {
    public void openHoverToImage(){
        Browser.visit("https://the-internet.herokuapp.com/hovers");
    }
    public void openDragDropElements(){
        Browser.visit("https://the-internet.herokuapp.com/drag_and_drop");
    }
    public void openSliderUrl(){
        Browser.visit("https://the-internet.herokuapp.com/horizontal_slider");
    }
    public void openScrollBarUrl(){
        Browser.visit("https://the-internet.herokuapp.com/infinite_scroll");
    }

    public void hoverToImage(){
        WebElement image1 = Browser.getElement(By.xpath("//div[@class='example']/div[1]/img"));
        Browser.hover(image1);
    }

    public String getImageProfile(){
        return Browser.getElement(By.xpath("//div[@class='example']/div[1]/div/h5")).getText();
    }

    public String locatorDragDropLabel(String text){
        return String.format("//div[@id='column-%s']/header",text);
    }
    public void dragDrop(){
        WebElement source = Browser.getElement(By.id("column-a"));
        WebElement target = Browser.getElement(By.id("column-b"));
        Browser.dragDrop(source,target);
    }
    public String getLabelDragDropElement(String text){
        return Browser.getElement(By.xpath(locatorDragDropLabel(text))).getText();
    }
    public void clickAndHoldSilder(){
        WebElement pointer = Browser.getElement(By.xpath("//div[@class='sliderContainer']/input"));
        int width = pointer.getSize().getWidth();
        Browser.clickSlider(pointer,width);
    }
    public boolean waitUntilVisibleText(String range){
        return Browser.waitVisibleText(By.id("range"), range);
    }
}
