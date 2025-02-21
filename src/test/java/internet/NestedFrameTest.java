 package internet;

 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.Assert;
 import org.testng.annotations.Test;

 public class NestedFrameTest {

     @Test
     public void test(){
     WebDriver driver = new ChromeDriver();
     driver.get("https://the-internet.herokuapp.com/nested_frames");
     driver.switchTo().frame("frame-top");
     driver.switchTo().frame("frame-left");
     String content_left = driver.findElement(By.xpath("/html/body")).getText();
     //System.out.println(content);
     Assert.assertTrue(content_left.contains("LEFT"));

     driver.switchTo().parentFrame();
     driver.switchTo().frame("frame-middle");
     String content_middle = driver.findElement(By.id("content")).getText();
     Assert.assertEquals(content_middle, "MIDDLE");

     driver.switchTo().parentFrame();
     driver.switchTo().frame("frame-right");
     String content_right = driver.findElement(By.xpath("/html/body")).getText();
     Assert.assertEquals(content_right, "RIGHT");

     driver.switchTo().defaultContent();
     driver.switchTo().frame("frame-bottom");
     String content_bottom = driver.findElement(By.xpath("/html/body")).getText();
     Assert.assertEquals(content_bottom, "BOTTOM");

     driver.quit();

     }
    
 }
