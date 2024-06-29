package Pages;

import Helpers.DynamicXpath;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Page{
    private By txt_KeySearch = By.id("key");
    private By btn_Search = By.xpath("//button[@aria-label = 'Tìm kiếm']");
    private By btn_OptionOnNav = By.xpath("//a[text() = '%s']");
    private By li_PrizeInfor = By.xpath("//a[text()='Thông tin trao thưởng']//parent::li");

    public void searchProductByKey(String key){
        waitElementVisible(txt_KeySearch);
        doClearAndInitText(txt_KeySearch, key);
        waitElementClickable(btn_Search);
        doClickElement(btn_Search);
    }

    public void doClickOptionOnNav(String optionName){
        By tempLocator = DynamicXpath.setXpath(btn_OptionOnNav, optionName);
        doClickElement(tempLocator);
    }

    public void doMoveToOptionOnNav(String optionName){
        By tempLocator = DynamicXpath.setXpath(btn_OptionOnNav, optionName);
        doMoveElement(tempLocator);
    }
    public void doClickPrizeInfo(){
        doClickElement(li_PrizeInfor);
    }
}
