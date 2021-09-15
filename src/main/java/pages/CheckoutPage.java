package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class CheckoutPage {

    private WebDriver driver;
    private String linkXpath_Format = ".//a[contains(text(), '%s')]";
    private By itemList = By.xpath("//tr[@ng-repeat='item in cart.items()']/td[1]");

    public CheckoutPage (WebDriver driver){
        this.driver = driver;
    }

    public List<String> getItems() {
        List<String> itemName = new ArrayList<String>();
        List<WebElement> itemListResult = driver.findElements(itemList);
        for (WebElement w : itemListResult) {
            itemName.add(w.getText().trim());
            System.out.println(w.getText().trim());
        }
        return itemName;
    }


}
