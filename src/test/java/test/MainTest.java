package test;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.SuccessfulSubmissionPage;

import static org.testng.Assert.assertTrue;

public class MainTest extends BaseTests {

    @Test
    public void testSubmitFeedback(){
        ContactPage contactPage = homePage.clickContact();
        contactPage.setForeName("Felicia");
        contactPage.setEmail("abc@email.com");
        contactPage.setMessage("I like this applicatoin.");
        SuccessfulSubmissionPage successfulSubmissionPage = contactPage.clickSubmitButton();
        assertTrue(successfulSubmissionPage.getSuccessfulMessage().contains("we appreciate your feedback."),
                "Message is incorrect");
    }
}
