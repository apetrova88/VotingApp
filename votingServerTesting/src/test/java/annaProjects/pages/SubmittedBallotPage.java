package annaProjects.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmittedBallotPage {
    WebDriver driver;
    By congrats = By.className("grats-title");
    By contInf = By.xpath("//*[text()='CONTACT INFORMATION']");
    By blCh = By.xpath("//*[text()='Blockchain explorer']");
    By transPage = By.xpath("html/body/div[1]/h1");

    public String getSubmitPageTitle(WebDriver driver){
        this.driver = driver;
        return driver.findElement(congrats).getText();
    }
    public void contactInfo(WebDriver driver){
        this.driver = driver;
        WebElement cI = driver.findElement(contInf);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", cI);
    }
    public String blockChainExpl(WebDriver driver){
        this.driver = driver;
        WebElement bCh = driver.findElement(blCh);
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("arguments[0].click();", bCh);
       // WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(transPage));
        String currentWindow = driver.getWindowHandle();
        for(String newWindow : driver.getWindowHandles()){
            driver.switchTo().window(newWindow);
        }
        String title =  driver.findElement(transPage).getText();
        driver.close();
        driver.switchTo().window(currentWindow);
        return title;
    }
}
