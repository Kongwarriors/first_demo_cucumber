package DriverControllers;

import Constants.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeController {
    public static ChromeOptions getChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        Map<String, Object> prefs = new HashMap<>();
        String downloadPath = TestConfig.downloadPath;
        prefs.put("download.default_directory",downloadPath);
        chromeOptions.setExperimentalOption("prefs", prefs);
        return chromeOptions;
    }

    public static WebDriver openChromeDriver(){
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }
}
