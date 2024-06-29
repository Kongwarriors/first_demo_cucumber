package StepDefinitions;

import Hooks.TestContext;
import Pages.ResultSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ResultSearchPageStep {
    TestContext context;
    ResultSearchPage resultSearchPage;

    public ResultSearchPageStep(TestContext context) {
        this.context = context;
        resultSearchPage = context.getResultSearchPage();
    }

    @And("User choose radio button {string}")
    public void userChooseRadioButton(String productType){
        resultSearchPage.chooseProductType(productType);
    }

    @And("User choose list product has name {string}")
    public void userChooseProductList(String nameProduct){
        resultSearchPage.chooseProductList(nameProduct);
    }

    @Then("User verify has {string} product on Result Search Page")
    public void userVerifyNumberProduct(String numberProduct){
        resultSearchPage.verifyNumberProducts(numberProduct);
    }

    @And("User choose product name {string}")
    public void userChooseProductByName(String nameProduct){
        resultSearchPage.chooseProductByName(nameProduct);
    }
}
