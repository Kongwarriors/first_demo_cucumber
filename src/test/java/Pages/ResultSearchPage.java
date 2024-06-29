package Pages;

import Helpers.DynamicXpath;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ResultSearchPage extends Page{
    private By rdo_ProductType = By.xpath("//label[text() ='%s']");
    private By link_ProductList = By.xpath("//a[@title ='%s']");
    private By link_ProductDetail = By.xpath("//div[@class = 'mc-lpcol']");
    private By item_Product = By.xpath("//a[@title = '%s']//ancestor::div[@class='cdt-product']");

    public void chooseProductType(String productType){
        rdo_ProductType = DynamicXpath.setXpath(rdo_ProductType, productType);
        doClickElement(rdo_ProductType);
    }

    public void chooseProductList(String nameProductList){
        link_ProductList = DynamicXpath.setXpath(link_ProductList, nameProductList);
        doMoveAndClickElement(link_ProductList);
    }

    public void verifyNumberProducts(String numberProduct){
        int productNumber = Integer.parseInt(numberProduct);
        int numberProductInSite = driver.findElements(link_ProductDetail).size();
        Assert.assertEquals(productNumber, numberProductInSite,"Number product display is incorrect");
    }

    public void chooseProductByName(String nameProduct){
        doClickElement(DynamicXpath.setXpath(item_Product,nameProduct));
    }
}
