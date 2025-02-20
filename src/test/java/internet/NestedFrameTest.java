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
     String content = driver.findElement(By.xpath("/html/body")).getText();
     System.out.println(content);

     Assert.assertTrue(content.contains("LEFT"));

     driver.switchTo().parentFrame();
     driver.switchTo().frame("frame-middle");
     content = driver.findElement(By.id("content")).getText();
     Assert.assertEquals(content, "MIDDLE");

     driver.switchTo().parentFrame();
     driver.switchTo().frame("frame-right");
     // content = driver.findElement(By.id("content")).getText();
     // Assert.assertEquals(content, "RIGHT");

     driver.switchTo().defaultContent();
     driver.switchTo().frame("frame-bottom");
     content = driver.findElement(By.id("content")).getText();
     Assert.assertEquals(content, "BOTTOM");

     }
    
 }
