package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;

public abstract class Page {
    public static WebDriver driver;
    public static Actions actions;
    public FluentWait<WebDriver> fluentWait;
    public Page(){
        fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(10));
        fluentWait.pollingEvery(Duration.ofSeconds(2));
        fluentWait.ignoring(NoSuchElementException.class);
    }

    public static void setDriver(WebDriver driver) {
        Page.driver = driver;
        actions = new Actions(driver);
    }

    public void waitForLoading(){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);


        wait.until(webDriver -> {
            JavascriptExecutor js = (JavascriptExecutor) webDriver;
            return js.executeScript("return document.readyState").equals("complete");
        });



    }

    public void sleepTime(int time){
        try{
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Đợi một phần từ đến khi nó có thể click
    public void waitElementClickable(By locator){
        try{
            fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        catch (RuntimeException e){
            Assert.fail("Time out for " + locator + " is clickable");
        }
    }
    //Đợi một phần tử hiên thị trên màn hình
    public void waitElementVisible(By locator){
        try{
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch (RuntimeException e){
            Assert.fail("Time out for " + locator + " is visible");
        }
    }
    //Đợi một phần tử hiển thị trong DOM
    public void waitElementPresence(By locator){
        try{
            fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch(RuntimeException e){
            Assert.fail("Time out for " + locator + " is presence");
        }
    }

    public void doClickElement(By locator){
        waitElementClickable(locator);
        driver.findElement(locator).click();
    }

    public void doMoveElement(By locator){
        waitElementVisible(locator);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }

    public void doMoveAndClickElement(By locator){
        waitElementVisible(locator);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).click().build().perform();
    }
    public void doClearAndInitText(By locator, String inputString){
        waitElementVisible(locator);
        WebElement element = driver.findElement(locator);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(inputString);
    }
    public String getTextOfElement(By locator){
        waitElementVisible(locator);
        return driver.findElement(locator).getText();
    }
    public String getAttributeOfElement(By locator, String attribute){
        waitElementVisible(locator);
        return driver.findElement(locator).getAttribute(attribute);
    }
    public void doScrollToElement(JavascriptExecutor javascriptExecutor, By locator){
        Dimension windowSize = driver.manage().window().getSize();
        Point elementLocated = driver.findElement(locator).getLocation();
        int highScroll = elementLocated.getY() - windowSize.getHeight()/2;
        javascriptExecutor.executeScript("window.scrollTo(0, arguments[0]);", highScroll);
    }
    public void doClickCheckbox(By locator){
        if(!driver.findElement(locator).isSelected()){
            doClickElement(locator);
        }
    }
}
