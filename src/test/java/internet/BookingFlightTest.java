package internet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


/*
- Open chrome
- Chon 10/1/2025
- Verify
 */

// XPATH=//table[@id='table1']/tbody/tr[1]/td[1] = cell[maxDue][1]
// XPATH=//table[@id='table1']/tbody/tr[1]/td = row 1
// XPATH=//table[@id='table1']/tbody/tr/td[1] = column1
// XPATH=//table[@id='table1']/tbody/tr/td[4] = due column

public class BookingFlightTest {
    @Test
    void verifyAbleSelectDepartDate(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vietnamairlines.com/vn/en/home");
        driver.findElement(By.id("cookie-agree")).click();

        driver.findElement(By.id("roundtrip-date-depart")).click();

        driver.findElements(By.cssSelector(".ui-datepicker-calendar"))
                .get(0)
                .findElements(By.tagName("a"))
                .stream()
                .filter(d -> d.getText().contains("10"))
                .findFirst()
                .get()
                .click();

        driver.findElements(By.cssSelector(".ui-datepicker-calendar"))
                .get(1)
                .findElements(By.tagName("a"))
                .stream()
                .filter(d -> d.getText().contains("4"))
                .findFirst()
                .get()
                .click();

        driver.findElement(By.className("confirm-dates")).click();

        Assert.assertEquals(driver.findElement(By.id("roundtrip-date-depart")).getDomProperty("value"),"10/01/2025");
        driver.quit();
    }
}
