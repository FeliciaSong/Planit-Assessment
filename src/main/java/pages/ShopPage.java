package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage {
    private WebDriver driver;
    private By TeddyBear = By.id("product-1");
    private By FunnyCowBuy = By.xpath("//li[@id='product-6']//a");
    private By FluffyBunnyBuy = By.xpath("//li[@id='product-4']//a");
    private By cart = By.id("nav-cart");

    public ShopPage (WebDriver driver){
        this.driver = driver;
    }

    public void buyFunnyCow(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(TeddyBear));
        driver.findElement(FunnyCowBuy).click();
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.);
        driver.findElement(FunnyCowBuy).click();
    }

    public void buyFluffyBunny(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(TeddyBear));
        driver.findElement(FluffyBunnyBuy).click();
    }


    public CheckoutPage clickCart(){
        driver.findElement(cart).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart-msg")));
        return new CheckoutPage(driver);
    }

}
