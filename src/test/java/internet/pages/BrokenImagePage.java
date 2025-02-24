package internet.pages;

import org.openqa.selenium.By;
import supports.Browser;
import supports.Util;

public class BrokenImagePage {
    public void open(){
        Browser.visit(Util.getBaseUrl() +"/broken_images");
    }

    public void checkLoadedImage(){
            Browser.getElements(By.xpath("//div/img")).forEach(img ->{
            int naturalHeight = Integer.parseInt( img.getDomProperty("naturalHeight"));
            int naturalWidth = Integer.parseInt( img.getDomProperty("naturalWidth"));
            if (naturalHeight==0 && naturalWidth==0){
                System.out.println("Image is broken");
            }else {
                System.out.println("Image is loaded");
            }
        });
    }

}
