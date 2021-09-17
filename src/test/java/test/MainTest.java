package test;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ContactPage;
import pages.ShopPage;
import pages.SuccessfulSubmissionPage;

import java.util.*;

import static org.testng.Assert.*;

public class MainTest extends BaseTests {

    @Test(invocationCount = 5, priority  = 1)// run test case 1 for 5 times
    public void testcase1_testSubmitFeedback(){
        // Click Contact link
        ContactPage contactPage = homePage.clickContact();

        // Fill in the mandatory fields
        contactPage.setForeName("Felicia");
        contactPage.setEmail("abc@email.com");
        contactPage.setMessage("I like this application.");

        // Click submit button
        SuccessfulSubmissionPage successfulSubmissionPage = contactPage.clickSubmitButton();

        // Assert submit successful message
        assertTrue(successfulSubmissionPage.getSuccessfulMessage().contains("we appreciate your feedback."),
                "Message is incorrect");
    }

    @Test (priority = 2)
    public void testcase2_testCartItems(){
        // Click shop link
        ShopPage shopPage = homePage.clickShop();

        // Click 2 times on "Funny Cow"
        shopPage.buyFunnyCow(2);

        // Click 1 time on "Fluffy Bunny"
        shopPage.buyFluffyBunny(1);

        // Click Cart link
        CheckoutPage checkoutPage = shopPage.clickCart();

        // Get the list of items' names from cart
        List<String> actualItems = checkoutPage.getItems();

        // Declare expected items data
        List<String> expectedItems = new ArrayList<String>() {
            {
                add("Funny Cow");
                add("Fluffy Bunny");
            }
        };

        // Get the list of items' quantities from cart
        List<String> actualQuantities = checkoutPage.getQuantities();

        //Declare expected items quantity
        List<String> expectedQuantities = new ArrayList<String>() {
            {
                add("2");
                add("1");
            }
        };

        // Assert items' names.
        assertEquals(expectedItems, actualItems);

        // Assert items' quantities.
        assertEquals(expectedQuantities, actualQuantities);
    }

    @Test (priority = 3)
    public void testcase3_testSubtotal(){
        // Click shop link
        ShopPage shopPage = homePage.clickShop();

        // Click 2 times on "Stuffed Frog"
        shopPage.buyStuffedFrog(2);

        // Click 5 times on "Fluffy Bunny"
        shopPage.buyFluffyBunny(5);

        // Click 3 times on "Valentine Bear"
        shopPage.buyValentineBear(3);

        // Click Cart link
        CheckoutPage checkoutPage = shopPage.clickCart();

        // Get the item and total pairs from cart
        Map<String, String> actualItemSubtotal = checkoutPage.getItemSubtotalCollection();

        // Declare expected collection data
        Map<String, String> expectedItemSubtotal = new HashMap<String, String>();
        expectedItemSubtotal.put("Stuffed Frog", "$21.98");
        expectedItemSubtotal.put("Fluffy Bunny", "$49.95");
        expectedItemSubtotal.put("Valentine Bear", "$44.97");

        // Assert collection
        assertEqualsDeep(expectedItemSubtotal, actualItemSubtotal);
    }
}
