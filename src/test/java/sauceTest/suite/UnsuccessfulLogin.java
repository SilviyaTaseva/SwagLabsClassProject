package sauceTest.suite;

import base.TestUtil;
import org.testng.annotations.Test;
import testPages.LoginPage;

public class UnsuccessfulLogin extends TestUtil {

    @Test(dataProvider = "unValidUsersFromCsv")
    public void UnsseccesfulLogin1(String userName, String passsword){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userName,passsword);

    }
}
