package annaProjects.pages;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

public class DecryptedBallotPage {
    WebDriver driver;

    By decryptBallotTitle = By.className("app-content-header");
    By saveBallot = By.xpath("//*[text()='SAVE BALLOT DETAILS']");
    By returnButton = By.xpath("//*[text()='RETURN']");


    public String getDecryptionBallotTitle(WebDriver driver){
        this.driver = driver;
        return driver.findElement(decryptBallotTitle).getText();
    }
    public void discardDecryptedBallot(WebDriver driver){
        this.driver = driver;
        WebElement rB = driver.findElement(returnButton);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", rB);
    }
    public void saveDecryptedBallot(WebDriver driver){
        this.driver = driver;
        WebElement rB = driver.findElement(saveBallot);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", rB);
    }

}
