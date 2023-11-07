package sauceTest.suite;

import base.TestUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import testPages.LoginPage;
import testPages.ProductPage;

public class ProductAdding extends TestUtil {

    @Test
    public void SuccessfulProductAdding(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user","secret_sauce");
        productPage.addItemToTheCart("bolt-t-shirt");
        productPage.addItemToTheCart("backpack");
        productPage.addItemToTheCart("fleece-jacket");

        Assert.assertEquals(productPage.getItemsInTheCart(), 3);
    }

}
