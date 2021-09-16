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
    private By StuffedFrogBuy = By.xpath("//li[@id='product-2']//a");
    private By ValentineBearBuy = By.xpath("//li[@id='product-7']//a");
    private By cart = By.id("nav-cart");

    public ShopPage (WebDriver driver){
        this.driver = driver;
    }

    public void buyFunnyCow(int noOfTimes){
        clickBuyButton(FunnyCowBuy, noOfTimes);
    }

    public void buyFluffyBunny(int noOfTimes){
        clickBuyButton(FluffyBunnyBuy, noOfTimes);
    }

    public void buyStuffedFrog(int noOfTimes){
        clickBuyButton(StuffedFrogBuy, noOfTimes);
    }

    public void buyValentineBear(int noOfTimes){
        clickBuyButton(ValentineBearBuy, noOfTimes);
    }

    public CheckoutPage clickCart(){
        driver.findElement(cart).click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart-msg")));
        return new CheckoutPage(driver);
    }

    private void clickBuyButton(By item, int noOfTimes){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(TeddyBear));
        for (int i = 1; i <= noOfTimes; i++) {
            driver.findElement(item).click();
        }
    }

}
