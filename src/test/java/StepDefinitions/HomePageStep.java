package StepDefinitions;

import Constants.EnumURL;
import Hooks.Hook;
import Hooks.TestContext;
import Pages.HomePage;
import Pages.ResultSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageStep {
    TestContext context;
    HomePage homePage;

    public HomePageStep(TestContext testContext){
        this.context = testContext;
        this.homePage = context.getHomePage();
    }
    @Given("Navigate to Home page")
    public void userNavigateToHomePage(){
        Hook.driverAction.openPage(EnumURL.BASE_URL.getUrl());
    }

    @When("User search product by key {string}")
    public void userSearchProductByKey(String key){
        homePage.searchProductByKey(key);
    }

    @When("User choose {string} on navbar")
    public void userChooseOptionOnNavbar(String optionOnNav){
        homePage.doClickOptionOnNav(optionOnNav);
    }

    @When("User move {string} on navbar")
    public void userMoveOptionOnNav(String optionName){
        homePage.doMoveToOptionOnNav(optionName);
        homePage.doClickPrizeInfo();
    }
}
