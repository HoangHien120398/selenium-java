package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;

public class BasicAuthenticationPage {
    public void open(){
        Browser.visit("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }

    public boolean checkContainWithText( String withText){
        String content = Browser.getText(By.xpath("//div[@id='content']//p"));
        if(content.contains(withText)==true)
            return true;
        return false;
    }
}
