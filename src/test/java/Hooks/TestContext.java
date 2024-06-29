package Hooks;

import Pages.HomePage;
import Pages.MobilePage;
import Pages.ProductDetailPage;
import Pages.ResultSearchPage;

public class TestContext {
    private HomePage homePage;
    private ResultSearchPage resultSearchPage;
    private MobilePage mobilePage;
    private ProductDetailPage productDetailPage;
    public HomePage getHomePage(){
        if(homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }

    public ResultSearchPage getResultSearchPage() {
        if(resultSearchPage == null){
            resultSearchPage = new ResultSearchPage();
        }
        return resultSearchPage;
    }

    public MobilePage getMobilePage() {
        if(mobilePage == null){
            mobilePage = new MobilePage();
        }
        return mobilePage;
    }

    public ProductDetailPage getProductDetailPage() {
        if(productDetailPage == null){
            productDetailPage = new ProductDetailPage();
        }
        return productDetailPage;
    }
}
