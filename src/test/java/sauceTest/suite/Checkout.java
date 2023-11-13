package sauceTest.suite;

import base.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import testPages.LoginPage;
import testPages.ProductPage;

import java.time.Duration;

public class Checkout extends TestUtil {

    @Test
    public void checkingOut(){
        LoginPage loginPage = new LoginPage(driver);
        ProductPage productPage = loginPage.login("standard_user","secret_sauce");
        productPage.addItemToTheCart("backpack");
        productPage.addItemToTheCart("bike-light");

        Assert.assertEquals(productPage.getItemsInTheCart(),2);

        WebElement shoppingCartContainer = driver.findElement(By.cssSelector("[class='shopping_cart_badge']"));
        shoppingCartContainer.click();
        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();
    }
}
