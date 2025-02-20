package org.example.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTest {
    WebDriver driver;

    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void reloadPage(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    void theCheckboxesshouldSelected(){
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        Assert.assertTrue(checkbox2.isSelected());
    }

}
