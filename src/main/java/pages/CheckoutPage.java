package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class CheckoutPage {

    private WebDriver driver;
    private String linkXpath_Format = ".//a[contains(text(), '%s')]";
    private By itemNames = By.xpath("//tr[@ng-repeat='item in cart.items()']/td[1]");
    private By subtotals = By.xpath("//tr[@ng-repeat='item in cart.items()']/td[4]");
    private By emptyCartButton = By.xpath("//a[@ui-if='cart.getCount() > 0']");

    public CheckoutPage (WebDriver driver){
        this.driver = driver;
    }

    // Get item's name from the list of checkout page
    public List<String> getItems() {
       return getStringsByColumn(itemNames);
    }

    // Get item's subtotal from list of checkout pge
    public List<String> getSubtotals() {
        return getStringsByColumn(subtotals);
    }

    private List<String> getStringsByColumn(By columnList) {
        List<String> itemName = new ArrayList<String>();
        List<WebElement> columnListResult = driver.findElements(columnList);
        for (WebElement w : columnListResult) {
            itemName.add(w.getText().trim());
            System.out.println(w.getText().trim());
        }
        return itemName;
    }

    public void emptyCart(){
        if (driver.findElements(emptyCartButton).size() > 0){
            WebElement emptyCartButtonElement = driver.findElement(emptyCartButton);
            emptyCartButtonElement.click();
        }
    }

    public Map<String, String> getItemSubtotalCollection(){
        Map<String, String> itemSubtotals = new HashMap<String, String>();
        List<String> items = getItems();
        List<String> subTotals = getSubtotals();
        for(int i = 0; i < items.size(); i++){
            itemSubtotals.put(items.get(i), subTotals.get(i));
        }
        return itemSubtotals;
    }

}
