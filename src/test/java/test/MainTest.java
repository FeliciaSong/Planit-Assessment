package test;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.CheckoutPage;
import pages.ContactPage;
import pages.ShopPage;
import pages.SuccessfulSubmissionPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.*;

public class MainTest extends BaseTests {

    @Test(invocationCount = 5) // run test case 1 for 5 times
    public void testSubmitFeedback(){
        // Click Contact link
        ContactPage contactPage = homePage.clickContact();

        // Fill in the mandatory fields
        // TODO Field values to externalized
        contactPage.setForeName("Felicia");
        contactPage.setEmail("abc@email.com");
        contactPage.setMessage("I like this application.");

        // Click submit button
        SuccessfulSubmissionPage successfulSubmissionPage = contactPage.clickSubmitButton();

        // Assert submit successful message
        assertTrue(successfulSubmissionPage.getSuccessfulMessage().contains("we appreciate your feedback."),
                "Message is incorrect");
    }

    @Test
    public void testCartItems(){
        // Click shop link
        ShopPage shopPage = homePage.clickShop();

        // Click 2 times on "Funny Cow"
        shopPage.buyFunnyCow(2);

        // Click 1 time on "Fluffy Bunny"
        shopPage.buyFluffyBunny(1);

        // Click Cart link
        CheckoutPage checkoutPage = shopPage.clickCart();

        // Get items from cart
        List<String> actualItems = checkoutPage.getItems();

        // Declare expected items data
        List<String> expectedItems = new ArrayList<String>() {
            {
                add("Funny Cow");
                add("Fluffy Bunny");
            }
        };

        // Assert
        assertEquals(expectedItems, actualItems);
    }
}
