package sauceTest.suite;

import base.DataProvider;
import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import testPages.LoginPage;
import testPages.ProductPage;

public class SuccessfulLogin extends TestUtil {

    @Test(dataProvider = "validUsersFromCsv")
    public void successfulLogin1(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login(userName,password);

        Assert.assertTrue(productPage.isAt());
    }
}
