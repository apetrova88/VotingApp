package annaProjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class StartPage {
    WebDriver driver;
    By voitInEllectionButton = By.xpath("//*[text() = \"VOTE IN ELECTION\"]");
    By monitorProcessButton = By.xpath("//*[text() = \"Monitor election process\"]");
    By voitPageTitle = By.xpath("//span[contains(@class, 'ng-binding') and text()='e-Voting']");
    By monitorPageTitle = By.xpath("//span[contains(@class, 'ng-binding') and text()='Monitor election']");

    public void getStartPage(WebDriver driver, String url, String startedPageText){
        this.driver = driver;
        driver.manage().window().maximize();
        driver.get(url);
        if (!driver.getTitle().toLowerCase().equals(startedPageText)){
            throw new IllegalStateException("not a start page of e-voiting app for elections");
        }
    }

    public void getVoitInEllectionPage(WebDriver driver){
        this.driver = driver;
        this.voitInEllectionButton = voitInEllectionButton;
        driver.findElement(voitInEllectionButton).click();
    }

    public void getMonitorProcessPage(WebDriver driver){
        this.driver = driver;
        this.monitorProcessButton = monitorProcessButton;
        driver.findElement(monitorProcessButton).click();
    }

    public String getAppHeader(WebDriver driver, By appHeader){
        this.driver = driver;
        return driver.findElement(appHeader).getText();
    }

    public String getAppSubHeader(WebDriver driver, By appSubHeader){
        this.driver = driver;
        return driver.findElement(appSubHeader).getText();
    }

}
