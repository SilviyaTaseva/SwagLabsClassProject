package testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(id ="user-name")
    static WebElement userNameInput;
    @FindBy(id = "password")
    static WebElement userPasswordInput;
    @FindBy(id = "login-button")
    static WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt(){ return loginButton.isDisplayed();}

    public static ProductPage login(String userName, String password){
        userNameInput.submit();
        userNameInput.clear();
        userNameInput.sendKeys(userName);

        userPasswordInput.submit();
        userPasswordInput.clear();
        userPasswordInput.sendKeys(password);

        loginButton.submit();
        return new ProductPage(driver);
    }
}
