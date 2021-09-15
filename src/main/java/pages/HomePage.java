package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public ContactPage clickContact(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-home")));
        clickLink("nav-contact");
        return new ContactPage(driver);
    }

    private void clickLink(String id){
        driver.findElement(By.id(id)).click();
    }
}
