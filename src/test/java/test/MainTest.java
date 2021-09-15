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

    @Test(invocationCount = 5)
    public void testSubmitFeedback(){
        ContactPage contactPage = homePage.clickContact();
        contactPage.setForeName("Felicia");
        contactPage.setEmail("abc@email.com");
        contactPage.setMessage("I like this application.");
        SuccessfulSubmissionPage successfulSubmissionPage = contactPage.clickSubmitButton();
        assertTrue(successfulSubmissionPage.getSuccessfulMessage().contains("we appreciate your feedback."),
                "Message is incorrect");
    }

    @Test
    public void testCartItems(){
        ShopPage shopPage = homePage.clickShop();
        shopPage.buyFunnyCow();
        shopPage.buyFluffyBunny();
        CheckoutPage checkoutPage = shopPage.clickCart();
        List<String> items = checkoutPage.getItems();
        List<String> expected = new ArrayList<String>() {
            {
                add("Funny Cow");
                add("Fluffy Bunny");
            }
        };
        assertEquals(expected, items);
    }
}
