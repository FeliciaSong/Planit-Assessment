package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {

    private WebDriver driver;
    private By foreNameField = By.id("forename");
    private By emailField = By.id("email");
    private By messageField = By.id("message");
    private By submitButton = By.linkText("Submit");


    public ContactPage (WebDriver driver){
        this.driver = driver;
    }

    public void setForeName(String foreName){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header-message")));
        driver.findElement(foreNameField).sendKeys(foreName);
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setMessage(String message){
        driver.findElement(messageField).sendKeys(message);
    }

    public SuccessfulSubmissionPage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new SuccessfulSubmissionPage(driver);
    }
}
