package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfulSubmissionPage {

    private WebDriver driver;
    private By submitSuccessAlert = By.xpath("//div[@ui-if='contactValidSubmit']/div[@class='alert alert-success']");

    public SuccessfulSubmissionPage (WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessfulMessage(){
        // Wait till the success submission alert is visible
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitSuccessAlert));

        // Return submit success text
        return driver.findElement(submitSuccessAlert).getText();
    }
}
