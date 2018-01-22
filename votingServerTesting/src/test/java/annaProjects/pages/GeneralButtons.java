package annaProjects.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GeneralButtons {

    WebDriver driver;
    StartPage spObj = new StartPage();

    By returnButton = By.className("toolbar-return-button");
    By helpButton = By.className("toolbar-help-button");
    By bottomMonitorButton = By.xpath("//*[contains (@class, 'bottom-menu-item-title') and text()='Monitor']");
    By bottomVoitButton = By.xpath("//*[contains (@class, 'bottom-menu-item-title') and text()='Elections']");
    By settingsButton = By.xpath("//*[contains (@class, bottom-menu-item-title)  and text()='Settings'");

    public void clickReturnButtonOnVoitingPage(WebDriver driver, String url, String startedPageText){
        this.driver = driver;
        spObj.getStartPage(driver, url, startedPageText);
        spObj.getVoitInEllectionPage(driver);
        driver.findElement(returnButton).click();
    }

    public void clickSimpleReturn(WebDriver driver){
        this.driver = driver;
        driver.findElement(returnButton).click();
    }

    public void clickReturnButtonOnMonitorPage(WebDriver driver, String url, String startedPageText){
        this.driver = driver;
        spObj.getStartPage(driver, url, startedPageText);
        spObj.getMonitorProcessPage(driver);
        driver.findElement(returnButton).click();
    }

    public void pressVoitingHelpButton(WebDriver driver, String url, String startedPageText){
        this.driver = driver;
        spObj.getStartPage(driver, url, startedPageText);
        spObj.getVoitInEllectionPage(driver);
        driver.findElement(helpButton).click();
    }
    public void pressMonitoringHelpButton(WebDriver driver, String url, String startedPageText){
        this.driver = driver;
        spObj.getStartPage(driver, url, startedPageText);
        spObj.getMonitorProcessPage(driver);
        driver.findElement(helpButton).click();
    }
    public void pressBottomMonitorPage(WebDriver driver, String url, String startedPageText){
        this.driver = driver;
        spObj.getStartPage(driver, url, startedPageText);
        spObj.getVoitInEllectionPage(driver);
        driver.findElement(bottomMonitorButton).click();
    }
    public void pressBottomVoitPage(WebDriver driver, String url, String startedPageText){
        this.driver = driver;
        spObj.getStartPage(driver, url, startedPageText);
        spObj.getMonitorProcessPage(driver);
        driver.findElement(bottomVoitButton).click();
    }
    public void pressSettingsButton(WebDriver driver, String url, String startedPageText){
        this.driver = driver;
        spObj.getStartPage(driver, url, startedPageText);
        spObj.getVoitInEllectionPage(driver);
        driver.findElement(settingsButton).click();
    }
}
