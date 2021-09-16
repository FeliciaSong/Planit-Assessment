package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.CheckoutPage;
import pages.HomePage;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    protected CheckoutPage checkoutPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        goHome();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://jupiter.cloud.planittesting.com/#/");
        homePage = new HomePage(driver);
    }

    @AfterMethod
    public void clearCart(){
        driver.get("https://jupiter.cloud.planittesting.com/#/cart");
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.emptyCart();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
