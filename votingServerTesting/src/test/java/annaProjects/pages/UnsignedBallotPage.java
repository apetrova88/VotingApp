package annaProjects.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UnsignedBallotPage {
    WebDriver driver;
    By ballotPageTitle = By.xpath("//*[text()='Your Unsigned Ballot']");
    By saveBallotDetButton = By.xpath("//*[text()='Save 3-word memo and ballot hash']");
    By discardButton = By.xpath("//*[text()='DISCARD']");
    By decrypButton = By.xpath("//*[text()='DECRYPT']");
    By signButton = By.xpath("//*[text()='SIGN']");
    By cancelDecrypt = By.xpath("//*[text()='CANCEL']");
    By crossButton = By.className("modal-cross");
    By decriptBallot = By.xpath("//*[text()='DECRYPT BALLOT']");
    By cancelSign = By.xpath("html/body/div[1]/div[2]/div/ballot-actions/div[3]/div/div/div/div[5]/div[1]/div");
    By confirmSign = By.xpath("//*[text()='SIGN BALLOT']");
    By crossSign = By.xpath("html/body/div[1]/div[2]/div/ballot-actions/div[3]/div/div/div/div[1]");
    int digit;
    By keyboardButton = By.xpath("//*[contains (@class, 'keyboard-button-digit') and text()='"+digit+ "']");





    public String ballotPageTitle(WebDriver driver){
        this.driver = driver;
        return driver.findElement(ballotPageTitle).getText().toLowerCase();
    }
    public void clickSaveBallotDetails(WebDriver driver){
        this.driver = driver;
        WebElement sB = driver.findElement(saveBallotDetButton);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", sB);
    }
    public void clickDiscardButton(WebDriver driver){
        this.driver = driver;
        WebElement dB = driver.findElement(discardButton);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", dB);
    }
    public void clickDecrypButton(WebDriver driver){
        this.driver = driver;
        WebElement dB = driver.findElement(decrypButton);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", dB);
    }
    public void clickSignButton(WebDriver driver){
        this.driver = driver;
        WebElement sB = driver.findElement(signButton);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", sB);
    }
    public void clickDecryptCancel(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cancelDecrypt));
        String currentWindow = driver.getWindowHandle();
        for(String newWindow : driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        driver.findElement(cancelDecrypt).click();
        driver.switchTo().window(currentWindow);
    }
    public void clickDecryptCross(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(crossButton));
        String currentWindow = driver.getWindowHandle();
        for(String newWindow : driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        driver.findElement(crossButton).click();
        driver.switchTo().window(currentWindow);
    }
    public void clickDecryptBallot(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(decriptBallot));
        String currentWindow = driver.getWindowHandle();
        for(String newWindow : driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        driver.findElement(decriptBallot).click();
    }
    public void clickSignCancel(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cancelSign));
        String currentWindow = driver.getWindowHandle();
        for(String newWindow : driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        driver.findElement(cancelSign).click();
        driver.switchTo().window(currentWindow);
    }

    public void clickConfirmSign(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(confirmSign));
        String currentWindow = driver.getWindowHandle();
        for(String newWindow : driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        driver.findElement(confirmSign).click();
    }
    public void clickSignCross(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(crossSign));
        String currentWindow = driver.getWindowHandle();
        for(String newWindow : driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        driver.findElement(crossSign).click();
        driver.switchTo().window(currentWindow);
    }
    public void inputPin(WebDriver driver, int digit){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(keyboardButton));
        String currentWindow = driver.getWindowHandle();
        for(String newWindow : driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        for (int i = 0; i<4; i++) {
            driver.findElement(keyboardButton).click();
        }

    }




}

