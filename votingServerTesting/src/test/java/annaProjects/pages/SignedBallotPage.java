package annaProjects.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignedBallotPage {
    WebDriver driver;
    By signedBallotTitle = By.className("toolbar-title");
    By discBal = By.xpath("//*[text()='DISCARD BALLOT']");
    By submBal = By.xpath("//*[text()='SUBMIT BALLOT']");
    By emailField = By.className("ng-pristine");


    public String getSignedBallotTitle(WebDriver driver){
        this.driver = driver;
        return driver.findElement(signedBallotTitle).getText();
    }
    public void clickDiscardBallot(WebDriver driver){
        this.driver = driver;
        WebElement dB = driver.findElement(discBal);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", dB);
    }
    public void clickSubmitBallot(WebDriver driver){
        this.driver = driver;
        WebElement sB = driver.findElement(submBal);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", sB);
    }
    public void enterEmail(WebDriver driver, String email){
        this.driver = driver;
        driver.findElement(emailField).sendKeys(email);
    }
}
