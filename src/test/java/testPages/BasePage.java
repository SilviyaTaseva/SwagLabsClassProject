package testPages;

import base.TestUtil;
import org.openqa.selenium.WebDriver;

public abstract class  BasePage extends TestUtil {
    protected static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;

    }
    public abstract boolean isAt();
}
