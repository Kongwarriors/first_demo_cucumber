package Pages;

import Helpers.DynamicXpath;
import org.openqa.selenium.By;

public class ProductDetailPage extends Page{
    private By btn_Compare = By.xpath("//a[text() = 'So sánh']");
    private By btn_Rate = By.xpath("//div[contains(@class, 'user-rate')]//div[contains(@class,'btn')]");
    private By box_RateProduct = By.xpath("//div[@class = 'modal-box']");
    private By li_StarRate = By.xpath("//ul[@class = 'list-star is-invalid']//li[%d]");
    private By ta_Comment = By.xpath("//div[@class = 'modal-box']//textarea");
    private By rdo_Gender = By.xpath("//input[@type = 'radio' and @value='%s']");
    private By txt_UserInfo = By.xpath("//div[@class = 'modal-box']//input[@name = '%s']");
    private By btn_SubmitRate = By.xpath("//div[@class = 'modal-box']//button[@type = 'submit']");
    private By msg_Success = By.xpath("//div[@class='modal-box']//div[text()='Gửi đánh giá thành công']");
    private By btn_Confirm = By.xpath("//div[@class = 'modal-box']//button[text()= 'XÁC NHẬN']");
    public void addToCompare(){
        doClickElement(btn_Compare);
    }

    public void doClickRate(){
        doClickElement(btn_Rate);
    }

    public void doSelectStar(int star){
        li_StarRate = DynamicXpath.setXpath(li_StarRate, star);
        doClickElement(li_StarRate);
    }

    public void doEnterComment(String comment){
        doClearAndInitText(ta_Comment, comment);
    }

    public void doSelectGender(String gender){
        rdo_Gender = DynamicXpath.setXpath(rdo_Gender, gender);
        doClickElement(rdo_Gender);
    }

    public void doEnterUserInfo(String userAttribute, String userInfo){
        By temp_Locator = DynamicXpath.setXpath(txt_UserInfo,userAttribute);
        doClearAndInitText(temp_Locator, userInfo);
    }

    public void doSubmitRate(){
        doClickElement(btn_SubmitRate);
    }
    public void waitBoxRateVisible(){
        waitElementVisible(box_RateProduct);
    }
    public void verifyMessageSuccessDisplay(){
        waitElementVisible(msg_Success);
        waitElementClickable(btn_Confirm);
        doClickElement(btn_Confirm);
    }
}
