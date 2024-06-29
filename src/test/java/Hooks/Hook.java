package Hooks;

import DriverActions.DriverAction;
import DriverControllers.DriverController;
import Pages.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hook {
    public static DriverController driverController = new DriverController();
    public static DriverAction driverAction = new DriverAction();
    @Before
    public void beforeTest(){
        WebDriver driver = driverController.getDriver();
        Page.setDriver(driver);
        driverAction.setDriver(driver);
    }
//    @After
//    public void afterTest(){
//        driverController.stopDriver();
//    }
}
