package StepDefinitions;

import Hooks.TestContext;
import Pages.ProductDetailPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class ProductDetailPageStep {
    TestContext context;
    ProductDetailPage productDetailPage;
    public ProductDetailPageStep(TestContext context){
        this.context = context;
        productDetailPage = context.getProductDetailPage();
    }

    @And("User click button Gửi đánh giá")
    public void userClickButtonRate(){
        productDetailPage.doClickRate();
    }

    @And("User enter full information and click submit")
    public void userEnterFullInfo(DataTable dataTable){
        List<Map<String, String>> datas = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> data : datas){
            int star = Integer.parseInt(data.get("Star"));
            String comment = data.get("Comment");
            String gender = data.get("Gender");
            String name = data.get("Name");
            String phone = data.get("Phone");
            String email = data.get("Email");
            productDetailPage.waitBoxRateVisible();
            productDetailPage.doSelectStar(star);
            productDetailPage.doSelectGender(gender);
            productDetailPage.doEnterComment(comment);
            productDetailPage.doEnterUserInfo("Name", name);
            productDetailPage.doEnterUserInfo("Phone",phone);
            productDetailPage.doEnterUserInfo("Email", email);
            productDetailPage.doSubmitRate();
        }
    }

    @Then("User verify message success display")
    public void userVerifyMessageDisplay(){
        productDetailPage.verifyMessageSuccessDisplay();

    }
}
