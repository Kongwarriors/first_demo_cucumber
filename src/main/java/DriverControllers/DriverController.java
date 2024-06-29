package DriverControllers;

import Constants.TestConfig;
import io.cucumber.messages.types.Hook;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
public class DriverController {
    public WebDriver driver;
    public DriverController() {
    }
    public void startChromeDriverDefault(){
        driver = ChromeController.openChromeDriver();
    }

    public void startChromeDriverOptions(){
        driver = new ChromeDriver(ChromeController.getChromeOptions());
    }

    public void startEdgeDriverDefault(){
        driver = EdgeController.openEdgeDriver();
    }
    public void startEdgeDriverOptions(){
        driver = new EdgeDriver(EdgeController.getEdgeOptions());
    }

    public  WebDriver getDriver() {
        if(driver == null){
            setDriver();
        }
        return driver;
    }
    public void setDriver(){
        try{
            assert TestConfig.BROWSER_NAME != null;
            switch (TestConfig.BROWSER_NAME.toUpperCase()) {
                case "CHROME":
                    startChromeDriverDefault();
                    break;
                case "CHROMEOPTIONS":
                    startChromeDriverOptions();
                    break;
                case "EDGE":
                    startEdgeDriverDefault();
                    break;
                case "EDGEOPTIONS":
                    startEdgeDriverOptions();
                    break;
                default:
                    // Xử lý trường hợp mặc định (nếu cần)
                    break;
            }
        }
        catch (Exception e){
            Logger logger = LogManager.getLogger(Hook.class);
            logger.error("Đã xảy ra lỗi: {}", e.getMessage(), e);
        }
    }

    public void stopDriver(){
        if (driver != null){
            driver.quit();
        }
        else{
            System.out.println("WebDriver is not initialized!!");
        }
    }
}
