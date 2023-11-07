package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{

    private static String ProductBaseID = "add-to-cart-sauce-labs-";
    private static String RemoveProductBaseID = "remove-sauce-labs-";

    @FindBy(css = "[class='shopping_cart_badge']")
    WebElement shoppingCartContainer;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void addItemToTheCart(String itemName){
        WebElement itemToBeAdded = driver.findElement(By.id(ProductBaseID + itemName));
        itemToBeAdded.click();
    }
    public void removeProductFromTheCart(String itemName){
        WebElement itemToBeRemoved = driver.findElement(By.id(By.id(RemoveProductBaseID) + itemName));
    }

    public int getItemsInTheCart(){
        return Integer.parseInt(shoppingCartContainer.getText());
    }
    @Override
    public boolean isAt() {
        return false;
    }
}
