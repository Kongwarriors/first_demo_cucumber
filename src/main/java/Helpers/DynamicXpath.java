package Helpers;

import org.openqa.selenium.By;

public class DynamicXpath {
    public static By setXpath(By locator, String s){
        String xPath = locator.toString().replace("By.xpath: ","");
        locator = By.xpath(String.format(xPath,s));
        return locator;
    }
    public static By setXpath(By locator, int i){
        String xPath = locator.toString().replace("By.xpath: ","");
        locator = By.xpath(String.format(xPath,i));
        return locator;
    }
    //Set xPath cho 1 vị trí cụ thể là %s
    public static By setXpath(By locator, int index, String s){
        String xPath = locator.toString().replace("By.xpath: ","");
        String placeholder = "%" + index + "%";
        locator = By.xpath(xPath.replaceFirst(placeholder,s));
        return locator;
    }

    //Set xPath cho tất cả vị trí là %s cùng lúc
    public static By setXpath(By locator, String... args){
        String xPath = locator.toString().replace("By.xpath: ","");
        for(String arg : args){
            xPath = xPath.replaceFirst("%s", arg);
        }
        locator = By.xpath(xPath);
        return locator;
    }
}
