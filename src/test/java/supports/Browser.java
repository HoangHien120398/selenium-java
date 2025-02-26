package supports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Browser {
    private static WebDriver driver;

    public static WebDriverWait wait;

    public static void openBrowser(String browser) {
        switch (browser) {
            case "chrome": {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox": {
                driver = new FirefoxDriver();
                break;
            }
            case "safari": {
                driver = new SafariDriver();
                break;
            }
            case "edge": {

                driver = new EdgeDriver();
                break;
            }
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public static void visit(String url){
        driver.get(url);
    }
    public static void quit(){
        driver.quit();
    }
    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public static void click(By locator){
        driver.findElement(locator).click();
//        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public static void fill(By locator,String withText){
        driver.findElement(locator).sendKeys(withText);
    }
    public static String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public static void captureScreen(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", name, System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void check(By locator){
        if(!driver.findElement(locator).isSelected())
            click(locator);
    }

    public static void uncheck(By locator){
        if(driver.findElement(locator).isSelected())
            click(locator);
    }
    public static boolean assertSelected(By locator){
        if(driver.findElement(locator).isSelected())
            return true;
        return false;
    }
    public static void select(By locator, String withValue){
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(withValue);
    }
    public static void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public static void cancelAlert(){
        driver.switchTo().alert().dismiss();
    }
    public static void acceptAlert(String promptWithText){
        driver.switchTo().alert().sendKeys(promptWithText);
        driver.switchTo().alert().accept();
    }

    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    public static boolean isSelected(By locator){
        return driver.findElement(locator).isSelected();
    }

    public static void hover(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    public static void dragDrop(WebElement source, WebElement target){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();
    }
    public static void clickSlider(WebElement pointer, int width){
        Actions actions = new Actions(driver);
        actions.clickAndHold(pointer)
                .moveByOffset(width,0)
                .perform();
    }
    public static void waitTime(int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
    }
    public static boolean waitVisibleText(By locator, String range){
        return wait.until(ExpectedConditions.textToBe(locator,range));
    }
    public static void scrollBar(){
        Actions actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            actions.scrollByAmount(0,500).perform();
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(2000));
        }
    }
    public static void rightClick(By locator){
        Actions actions = new Actions(driver);
        actions.contextClick(Browser.getElement(locator)).perform();
        driver.switchTo().alert().accept();
    }
}
