package annaProjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EVoitingPage {
    WebDriver driver;
    StartPage spObj = new StartPage();
    By voitButton = By.xpath("//*[text()='VOTE IN ELECTION']");
    By usPresidentElBut = By.xpath("html/body/div/div[2]/div/elections-list/table/tbody/tr[1]/td[4]/div"); // need to make correct xpaths
    By estoniaPresidentElBut = By.xpath("html/body/div/div[2]/div/elections-list/table/tbody/tr[2]/td[4]/div");

    public String IsChecked(WebDriver driver, By electionButton){
        this.driver = driver;
        return driver.findElement(electionButton).getAttribute("class");
    }

    public void enableRadioButton(WebDriver driver, By electionButton){
        driver.findElement(electionButton).click();
    }

    public String getElectionDesc(WebDriver driver, By electionButton){
        this.driver = driver;
        return driver.findElement(electionButton).getText();
    }
    public void clickVoteButton(WebDriver driver){
        this.driver = driver;
        WebElement vB = driver.findElement(voitButton);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", vB);
        //driver.findElement(voitButton).click();
    }



}
