 package internet;

 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
 import org.testng.Assert;
 import org.testng.annotations.Test;

 import java.util.Comparator;
 import java.util.List;
 import java.util.stream.Collectors;

 public class WebTableTest {
     @Test
     public void tc05(){
         WebDriver driver = new ChromeDriver();
         driver.get("https://the-internet.herokuapp.com/tables");

         /**
          * Giai thuat:
          * tim hang co due lon nhat => lay first name va last nam voi hang co cot due lon nhat
          */

         // XPATH=//table[@id='table1']/tbody/tr[1]/td[1] = cell[maxDue][1]
         // XPATH=//table[@id='table1']/tbody/tr[1]/td = row 1
         // XPATH=//table[@id='table1']/tbody/tr/td[1] = column1
         // XPATH=//table[@id='table1']/tbody/tr/td[4] = due column

         List<Double> dueValue = driver
                 .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                 .stream()
                 .map(cell -> Double.parseDouble(cell.getText().replace("$","")))
                 .collect(Collectors.toList());

         dueValue.forEach(System.out::println);
         Double maxDueValue = dueValue.stream().max(Comparator.naturalOrder()).get();
         System.out.println("max due value is "+maxDueValue);

         int maxDueIndex = dueValue.indexOf(maxDueValue);
         System.out.println("max due index is "+ maxDueIndex);

         String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[1]",maxDueIndex+1))).getText();
         String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%d]/td[2]",maxDueIndex+1))).getText();

         Assert.assertEquals(String.format("%s %s",lastName,firstName),"Doe Jason");

         driver.quit();
     }

 }
