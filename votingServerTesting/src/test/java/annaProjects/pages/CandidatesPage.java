package annaProjects.pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CandidatesPage {
    WebDriver driver;

    By candidatePageTitle = By.xpath("//*[text()='Candidates of Election']");
    By donTr = By.xpath("//*[text()='Donald Trump']");
    By hillCl = By.xpath("//*[text()='Hillary Clinton']");
    By desc = By.className("list-option-description");
    By officialPage = By.xpath("//*[text()='Official candidate page']");
    By pageTitle = By.id("firstHeading");
    By confTitle = By.className("confirm-choise-block-name");
    By confLink = By.className("confirm-choise-block-addition-link");
    By legislationTitle = By.xpath("//*[@id='articlearea']/h1[2]/strong");
    By voteButton = By.xpath("//*[text()='VOTE IN ELECTION']");
    By cancelButton = By.xpath("//*[text()='CANCEL']");
    By yesButton = By.xpath("//*[text()='YES']");
    By crossButton = By.className("modal-cross");


    public void chooseCandidate(WebDriver driver, By candidate){
        this.driver = driver;
        driver.findElement(candidate).click();
    }

    public String getCandidateDesc(WebDriver driver){
        this.driver = driver;
        return driver.findElement(desc).getText();
    }

    public void getCandidatePage(WebDriver driver){
        this.driver = driver;
        driver.findElement(officialPage).click();
    }

    public void clickVoteButton(WebDriver driver){
        this.driver = driver;
        WebElement vB = driver.findElement(voteButton);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", vB);
    }
    public String checkCandidatePage(WebDriver driver){
        this.driver = driver;
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(confLink));
        String currentWindow = driver.getWindowHandle();
        for(String newWindow : driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        String title =  driver.findElement(pageTitle).getText().toLowerCase();
        driver.close();
        driver.switchTo().window(currentWindow);
        return title;
    }
    public String getConfWindowTitle(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(confLink));
        return driver.findElement(confTitle).getText().toLowerCase();
    }
    public String getLegislationInfo(WebDriver driver){
        this.driver = driver;
        //WebDriverWait wait = new WebDriverWait(driver, 20);
        //wait.until(ExpectedConditions.elementToBeClickable(confLink));
        driver.findElement(confLink).click();
        String currentWindow = driver.getWindowHandle();
        for(String newWindow : driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        String title =  driver.findElement(legislationTitle).getText().toLowerCase();
        driver.close();
        driver.switchTo().window(currentWindow);
        return title;
    }

    public void clickCancel(WebDriver driver){
        this.driver = driver;
        driver.findElement(cancelButton).click();
    }
    public void clickYes(WebDriver driver){
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        driver.findElement(yesButton).click();
    }
    public void closeConfWindow(WebDriver driver){
        this.driver = driver;
        driver.findElement(crossButton).click();
    }

}
