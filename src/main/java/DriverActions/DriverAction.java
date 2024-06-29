package DriverActions;

import Constants.EnumURL;
import DriverControllers.DriverController;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class DriverAction {
    private WebDriver driver;
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    public void openPage(EnumURL url){
        if (driver != null) {
            driver.navigate().to(EnumURL.BASE_URL.getUrl() + url.getUrl());
        } else {
            System.out.println("WebDriver is not initialized. Please set the driver first.");
        }
    }

    public void openPage(String url){
        if (driver != null) {
            driver.navigate().to(url);
        } else {
            System.out.println("WebDriver is not initialized. Please set the driver first.");
        }
    }
    public void waitPageLoading(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public void forwardPage(){
        driver.navigate().forward();
    }
    public void backPage(){
        driver.navigate().back();
    }
    public void openNewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }
    public void openTabByWindowHandlesName(String name){
        driver.switchTo().window(name);
    }
    public void openTabByWindowIndex(int index){
        Set<String> windowHandles = driver.getWindowHandles();
        String windowToSwitch = windowHandles.toArray(new String[0])[index - 1];
        driver.switchTo().window(windowToSwitch);
    }
}
