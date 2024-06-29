package Pages;

import Helpers.DynamicXpath;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class MobilePage extends Page{
    private By chk_OptionFilter = By.xpath("//label[text() = '%s']/preceding-sibling::i");
    private By chk_OptionAllFilter = By.xpath("//div[text()='%s']//parent::div//p[text()='Tất cả']");
    private final By item_Product = By.xpath("//div[@class = 'cdt-product  product-sale']");
    public void chooseOptionFilter(String blockName, String optionFilter){
        if(optionFilter.trim().equalsIgnoreCase("Tất cả")){
            chooseOptionAllFilter(blockName);
        }
        else{
            doClickCheckbox(DynamicXpath.setXpath(chk_OptionFilter, optionFilter));
        }
    }

    public void chooseOptionAllFilter(String blockName){
        By temp_locator = DynamicXpath.setXpath(chk_OptionAllFilter, blockName);
        doMoveAndClickElement(temp_locator);
        doClickCheckbox(temp_locator);
    }

    public void verifyNumberProductIsDisplay(String numberProduct){
        int productNumber = Integer.parseInt(numberProduct);
        waitElementVisible(item_Product);
        int productNumberDisplay = driver.findElements(item_Product).size();
        Assert.assertEquals(productNumber, productNumberDisplay, "Number product display is incorrect");
    }
}
