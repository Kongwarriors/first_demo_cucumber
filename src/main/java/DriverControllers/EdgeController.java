package DriverControllers;

import Constants.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;

public class EdgeController {
    public static EdgeOptions getEdgeOptions(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");
        Map<String, Object> prefs = new HashMap<>();
        String downloadPath = TestConfig.downloadPath;
        prefs.put("download.default_directory",downloadPath);
        edgeOptions.setExperimentalOption("prefs", prefs);
        return edgeOptions;
    }

    public static WebDriver openEdgeDriver(){
        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.manage().window().maximize();
        return edgeDriver;
    }
}
