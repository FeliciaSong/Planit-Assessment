package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import constants.*;

import java.util.*;

public class CheckoutPage {

    private WebDriver driver;
    private By itemNames = By.xpath("//tr[@ng-repeat='item in cart.items()']/td[1]");
    private By subtotals = By.xpath("//tr[@ng-repeat='item in cart.items()']/td[4]");
    private By quantities = By.xpath("//tr[@ng-repeat='item in cart.items()']/td[3]/input");
    private By emptyCartButton = By.xpath("//a[@ui-if='cart.getCount() > 0']");

    public CheckoutPage (WebDriver driver){
        this.driver = driver;
    }

    // Get item's name from the list of checkout page
    public List<String> getItems() {
       return getStringsByColumn(itemNames, GetValueTypeEnum.ByText, "");
    }

    // Get item's subtotal from list of checkout page
    public List<String> getSubtotals() {
        return getStringsByColumn(subtotals, GetValueTypeEnum.ByText, "");
    }

    // Get item's quantities from list of checkout pge
    public List<String> getQuantities() {
        return getStringsByColumn(quantities, GetValueTypeEnum.ByAttribute, "value");
    }

    private List<String> getStringsByColumn(By columnList, GetValueTypeEnum valueType, String name) {
        List<String> itemName = new ArrayList<String>();
        List<WebElement> columnListResult = driver.findElements(columnList);
        for (WebElement w : columnListResult) {
            String value = new String();
            switch (valueType) {
                case ByAttribute:
                    value = w.getAttribute(name);
                    break;
                case ByCss:
                    value = w.getCssValue(name);
                    break;
                default:    // Default to getText
                    value = w.getText().trim();
                    break;
            }
            itemName.add(value);
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
