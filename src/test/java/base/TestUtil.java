package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil extends DataProvider {

    public WebDriver driver;
    private String testURL, browser;
    private int implicitWait;

    @BeforeMethod
    public void driverSetUpAndOpenTestAddress() {
        readConfig("src/test/resources/config.properties");
        setupDriver();
        driver.get(testURL);
    }

    private void readConfig(String pathToCofigFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(pathToCofigFile);
            Properties properties = new Properties();
            properties.load(fileInputStream);
            testURL = properties.getProperty("URL");
            browser = properties.getProperty("browser");
            implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void setupDriver() {
        switch (browser) {
            case "chrome":
                driver = setupChromeDriver();
                break;
            case "firefox":
                driver = setupFireFoxDriver();
                break;
        }
    }
    private WebDriver setupChromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();

    }
    private WebDriver setupFireFoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @AfterMethod
public void tearDown(){driver.quit();}
}