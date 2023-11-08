package sauceTest.suite;

import base.TestUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import testPages.LoginPage;

public class UnsuccessfulLogin extends TestUtil {

    @Test(dataProvider = "unValidUsersFromCsv")
    public void UnsuccessfulLogin1(String userName, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,password);

        Assert.assertTrue(loginPage.isAt());
    }
}
