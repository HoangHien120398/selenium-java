 package internet;

 import internet.pages.WebTableByDueValuePage;
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.Assert;
 import org.testng.annotations.AfterMethod;
 import org.testng.annotations.BeforeMethod;
 import org.testng.annotations.Test;
 import supports.Browser;

 import java.util.Comparator;
 import java.util.List;
 import java.util.stream.Collectors;

 public class WebTableByDueValueTest {
     WebTableByDueValuePage webTableByDueValuePage;
     @BeforeMethod
     void setup(){
         Browser.openBrowser("chrome");
         webTableByDueValuePage = new WebTableByDueValuePage();
         webTableByDueValuePage.open();
     }

     @Test
     public void getPersonMaxDueValue(){
         /**
          * Giai thuat:
          * tim hang co due lon nhat => lay first name va last nam voi hang co cot due lon nhat
          */

         // XPATH=//table[@id='table1']/tbody/tr[1]/td[1] = cell[maxDue][1]
         // XPATH=//table[@id='table1']/tbody/tr[1]/td = row 1
         // XPATH=//table[@id='table1']/tbody/tr/td[1] = column1
         // XPATH=//table[@id='table1']/tbody/tr/td[4] = due column

         int maxDueIndex = webTableByDueValuePage.getMaxDueValue();
         String lastName = webTableByDueValuePage.getLastName(maxDueIndex);
         String firstName = webTableByDueValuePage.getFirstName(maxDueIndex);

         Assert.assertEquals(String.format("%s %s",lastName,firstName),"Doe Jason");

     }

     @AfterMethod
     void tearDown(){
         Browser.quit();
     }

 }
