package StepDefinitions;

import Hooks.TestContext;
import Pages.MobilePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class MobilePageStep {
    TestContext context;
    MobilePage mobilePage;
    public MobilePageStep(TestContext context){
        this.context = context;
        mobilePage = context.getMobilePage();
    }

    @And("User choose some option filter")
    public void userChooseOptionFilter(DataTable dataTable){
        List<Map<String, String>> datas = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> data : datas){
            String brandProduct = data.get("Hãng sản xuất");
            mobilePage.chooseOptionFilter("Hãng sản xuất", brandProduct);
            mobilePage.waitForLoading();
            String rangeProduct = data.get("Mức giá");
            mobilePage.chooseOptionFilter("Mức giá", rangeProduct);
            mobilePage.waitForLoading();
            String typeProduct = data.get("Loại điện thoại");
            mobilePage.chooseOptionFilter("Loại điện thoại", typeProduct);
            mobilePage.waitForLoading();
            String specialFeature = data.get("Tính năng đặc biệt");
            mobilePage.chooseOptionFilter("Tính năng đặc biệt", specialFeature);
            mobilePage.waitForLoading();
            String performanceProduct = data.get("Hiệu năng và Pin");
            mobilePage.chooseOptionFilter("Hiệu năng và Pin",performanceProduct);
            mobilePage.waitForLoading();
            String screenProduct = data.get("Màn hình");
            mobilePage.chooseOptionFilter("Màn hình", screenProduct);
            mobilePage.waitForLoading();
            String cameraProduct = data.get("Camera");
            mobilePage.chooseOptionFilter("Camera", cameraProduct);
            mobilePage.waitForLoading();
        }
    }

    @Then("User verify has {string} product on Mobile Page")
    public void userVerifyNumberProduct(String productNumber){
        mobilePage.verifyNumberProductIsDisplay(productNumber);
    }

    @And("And User choose product name {string}")
    public void userChooseProductByName(String productName){

    }
}
