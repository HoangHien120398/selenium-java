package org.example.lesson04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormAuthenticationTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver = new ChromeDriver();
    }
    @BeforeMethod
    void load(){
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void validUsernameAndPassword(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.id("flash")).isDisplayed());
    }

    @Test
    public void invalidUsernameAndPassword(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
//        Assert.assertTrue(driver.findElement(By.className("flash error")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"flash\"]")).isDisplayed());
    }

    @AfterClass
    void tearDown(){
        driver.quit();
    }


}
