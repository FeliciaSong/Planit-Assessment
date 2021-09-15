package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccessfulSubmissionPage {

    private WebDriver driver;
    private By successSubmission = By.className("alert alert-success");
    private By loadingBar = By.className("popup modal hide ng-scope");

    public SuccessfulSubmissionPage (WebDriver driver){
        this.driver = driver;
    }

    public String getSuccessfulMessage(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingBar));
        return driver.findElement(successSubmission).getText();
    }
}
