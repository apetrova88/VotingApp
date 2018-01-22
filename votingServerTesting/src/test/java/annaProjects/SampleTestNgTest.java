package annaProjects;


import annaProjects.pages.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class SampleTestNgTest extends TestNgTestBase {
  StartPage stPage = new StartPage();
  GeneralButtons genButs = new GeneralButtons();
  EVoitingPage evoitPage = new EVoitingPage();
  CandidatesPage candsPage = new CandidatesPage();
  UnsignedBallotPage ballotPage = new UnsignedBallotPage();
  DecryptedBallotPage decrBallotPage = new DecryptedBallotPage();
  SignedBallotPage signBallotPage = new SignedBallotPage();
  SubmittedBallotPage submBallotPage = new SubmittedBallotPage();


  String url = "https://exonum.com/demo/voting";
  String startedPageText = "voting app";
  By appHeader = By.className("app-header");
  By appSubHeader = By.className("app-subheader");
  By usPresidentElBut = By.xpath("html/body/div/div[2]/div/elections-list/table/tbody/tr[1]/td[4]/div");
  By estoniaPresidentElBut = By.xpath("html/body/div/div[2]/div/elections-list/table/tbody/tr[2]/td[4]/div");
  By candidatePageTitle = By.xpath("//*[text()='Candidates of Election']");
  By donTr = By.xpath("//*[text()='Donald Trump']");
  By hillCl = By.xpath("//*[text()='Hillary Clinton']");
  By voitPage = By.xpath("//span[contains(@class, 'ng-binding') and text()='e-Voting']");
  By monitorPage = By.xpath("//span[contains(@class, 'ng-binding') and text()='Monitor election']");
  By electionDesc = By.className("list-option-description");
  By voitingPeriod = By.className("list-option-ends");
  By electCandidates = By.xpath("//*[text()='Candidates of Election']");
  By appContentHeader = By.className("app-content-header");
  By decrBallot = By.xpath("//*[text()='Your Decrypted Ballot']");
  By submitBallotInf = By.xpath("//*[text()='1) your ballot has been published on public bulletin board']");
  By warningPin = By.xpath("//*[text()='Warning, input your secret PIN2");
  String emailStr = "ann@guerrillamailblock.com";




  @Test(priority=0)
  public void verifyStartPageIsLoaded() {
    stPage.getStartPage(driver, url, startedPageText);
  }

  @Test(priority=2)
  public void verifyAppHeader(){
    stPage.getStartPage(driver, url, startedPageText);
    String appHeaderText = stPage.getAppHeader(driver, appHeader);
    Assert.assertTrue(appHeaderText.toLowerCase().equals("e-voting"));
  }

  @Test(priority=3)
  public void verifyAppSubHeader(){
    stPage.getStartPage(driver, url, startedPageText);
    String appSubHeaderText = stPage.getAppSubHeader(driver, appSubHeader);
    Assert.assertTrue(appSubHeaderText.toLowerCase().equals("app for elections"));
  }

 @Test(priority=4)
  public void voitInEllectionPageIsLoaded(){
    stPage.getStartPage(driver, url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    Assert.assertTrue(driver.findElement(voitPage).isDisplayed());
  }

  @Test(priority=5)
  public void voitInMonitorProcessPageIsLoaded(){
    stPage.getStartPage(driver, url, startedPageText);
    stPage.getMonitorProcessPage(driver);
    Assert.assertTrue(driver.findElement(monitorPage).isDisplayed());
  }

  @Test(priority=6)
  public void verifyReturnButtVoitingPage(){
    genButs.clickReturnButtonOnVoitingPage(driver, url, startedPageText);
    Assert.assertTrue(driver.findElement(By.className("app-subheader")).getText().toLowerCase().equals("app for elections"));
  }

  @Test(priority=7)
  public void verifyReturnButtMonitorPage(){
    genButs.clickReturnButtonOnMonitorPage(driver, url, startedPageText);
    Assert.assertTrue(driver.findElement(By.className("app-subheader")).getText().toLowerCase().equals("app for elections"));
  }

  @Test(priority=8)
  public void verifyVotingHelpButton() {
    genButs.pressVoitingHelpButton(driver, url, startedPageText);
    Assert.assertFalse(driver.findElement(voitPage).isDisplayed());
  }

  @Test(priority=9)
  public void verifyMonitoringHelpButton() {
    genButs.pressMonitoringHelpButton(driver, url, startedPageText);
    Assert.assertFalse(driver.findElement(monitorPage).isDisplayed());
  }
  @Test(priority=10)
  public void verifyBottomMonitorButton(){
    genButs.pressBottomMonitorPage(driver, url, startedPageText);
    Assert.assertTrue(driver.findElement(monitorPage).isDisplayed());
  }

  @Test(priority=11)
  public void verifyBottomVoitButton(){
    genButs.pressBottomVoitPage(driver, url, startedPageText);
    Assert.assertTrue(driver.findElement(voitPage).isDisplayed());
  }
  @Test(priority=12)
  public void verifySettingsButton(){
    genButs.pressBottomVoitPage(driver, url, startedPageText);
    Assert.assertFalse(driver.findElement(voitPage).isDisplayed());
  }
  @Test(priority=13)
  public void verifyUncheckedButtons(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    String us = evoitPage.IsChecked(driver, usPresidentElBut);
    System.out.println("for us: " + us);
    String estonia = evoitPage.IsChecked(driver, estoniaPresidentElBut);
    System.out.println("for estonia: " + estonia);
    Assert.assertEquals(us, "checker");
    Assert.assertEquals(estonia, "checker");
    evoitPage.enableRadioButton(driver, estoniaPresidentElBut);
    genButs.clickSimpleReturn(driver);
    stPage.getVoitInEllectionPage(driver);
    String estonia1 = evoitPage.IsChecked(driver, estoniaPresidentElBut);
    System.out.println("for estonia after page was reloaded: " + estonia1);
    Assert.assertEquals(estonia1, "checker");
  }
  @Test(priority=14)
  public void checkUSElectionType(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    String us = evoitPage.IsChecked(driver, usPresidentElBut);
    Assert.assertEquals(us, "checker active");
    String usDesc = evoitPage.getElectionDesc(driver, electionDesc);
    Assert.assertEquals(usDesc, "An election for President of the United States occurs every four years on Election Day, held the first Tuesday after the first Monday in November. The 2016 Presidential election will be held on November 8, 2016.");
    String usEndPeriod = evoitPage.getElectionDesc(driver, voitingPeriod);
    Assert.assertTrue(usEndPeriod.contains("Mon, 07 Nov 2016 14:00:00 -0600"));
  }
    @Test(priority=15)
    public void checkEstoniaElectionType(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, estoniaPresidentElBut);
    String estonia = evoitPage.IsChecked(driver, estoniaPresidentElBut);
    Assert.assertEquals(estonia, "checker active");
    String estoniaDesc = evoitPage.getElectionDesc(driver, electionDesc);
    Assert.assertEquals(estoniaDesc, "An indirect presidential election is scheduled to take place in Estonia on August 29, 2016. Incumbent President Toomas Hendrik Ilves, having served the maximum two terms, is not eligible to run for re-election.");
    String estoniaEndPeriod = evoitPage.getElectionDesc(driver, voitingPeriod);
    Assert.assertTrue(estoniaEndPeriod.contains("Mon, 29 Aug 2016 23:00:00 +0300"));
  }
  @Test(priority=16)
  public void checkVoteButtonVoitingPage(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    Assert.assertTrue(driver.findElement(candidatePageTitle).isDisplayed());
    genButs.clickSimpleReturn(driver);
    evoitPage.enableRadioButton(driver, estoniaPresidentElBut);
    evoitPage.clickVoteButton(driver);
    Assert.assertTrue(driver.findElement(candidatePageTitle).isDisplayed());
  }
  @Test(priority=17)
  public void checkDTrumpDetails(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, donTr);
    String trampDesc = candsPage.getCandidateDesc(driver);
    Assert.assertEquals(trampDesc, "Donald John Trump is an American businessman, television personality, author, politician, and the Republican Party nominee for President of the United States in the 2016 election.");
    candsPage.getCandidatePage(driver);
    String pageTitile = candsPage.checkCandidatePage(driver);
    Assert.assertEquals(pageTitile, "donald trump");
  }
  @Test(priority=18)
  public void checkHilClintonDetails(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    String clintonDesc = candsPage.getCandidateDesc(driver);
    Assert.assertEquals(clintonDesc, "Hillary Diane Rodham Clinton (born October 26, 1947) is an American politician and the nominee of the Democratic Party for President of the United States in the 2016 election.");
    candsPage.getCandidatePage(driver);
    String pageTitile = candsPage.checkCandidatePage(driver);
    Assert.assertEquals(pageTitile, "hillary clinton");
  }
    @Test(priority=19)
  public void checkTrumpLegislationDetails(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, donTr);
    candsPage.clickVoteButton(driver);
    String conf = candsPage.getConfWindowTitle(driver);
    Assert.assertEquals(conf, "donald trump");
    String legislationInfo = candsPage.getLegislationInfo(driver);
    Assert.assertEquals(legislationInfo, "Information about elections in US is available on webpage");
  }
  @Test(priority=20)
  public void checkCLintonLegislationDetails(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    String conf = candsPage.getConfWindowTitle(driver);
    Assert.assertEquals(conf, "hillary clinton");
    String legislationInfo = candsPage.getLegislationInfo(driver);
    Assert.assertEquals(legislationInfo, "Information about elections in US is available on webpage");
  }
  @Test(priority=21)//is not completed
  public void checkCancelInLegislation(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    String conf = candsPage.getConfWindowTitle(driver);
    Assert.assertEquals(conf, "hillary clinton");
    candsPage.clickCancel(driver);
    //need to complete assertion!!!
  }
  @Test(priority=22)//is not completed
  public void checkCrossButtonInLegislation(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    String conf = candsPage.getConfWindowTitle(driver);
    Assert.assertEquals(conf, "hillary clinton");
    candsPage.closeConfWindow(driver);
  }
  @Test(priority=23)
  public void checkBallotPage(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    Assert.assertEquals(ballotPage.ballotPageTitle(driver), "your unsigned ballot");
  }
  @Test(priority=24)
  public void checkDiscardButton(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickDiscardButton(driver);
    Assert.assertEquals(driver.findElement(electCandidates).getText(), "Candidates of Election");
  }
  @Test(priority=25)
  public void checkSaveBallotDetails(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickSaveBallotDetails(driver);
    Alert alert = driver.switchTo().alert();
    alert.accept();
  }
  @Test(priority=26)
  public void checkDecryptCancel(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickDecrypButton(driver);
    ballotPage.clickDecryptCancel(driver);
    Assert.assertEquals(driver.findElement(appContentHeader).getText().toLowerCase(), "ballot receipt");
    ballotPage.clickDecrypButton(driver);
    ballotPage.clickDecryptCross(driver);
    Assert.assertEquals(driver.findElement(appContentHeader).getText().toLowerCase(), "ballot receipt");
  }
  @Test(priority=27)
  public void checkDecryptConfirm(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickDecrypButton(driver);
    ballotPage.clickDecryptBallot(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(decrBallot));
    Assert.assertEquals(decrBallotPage.getDecryptionBallotTitle(driver).toLowerCase(), "full ballot encryption details");
  }

  @Test(priority=28)
  public void checkSignBallotCancel(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickSignButton(driver);
    ballotPage.clickSignCancel(driver);
    Assert.assertEquals(driver.findElement(appContentHeader).getText().toLowerCase(), "ballot receipt");
    ballotPage.clickSignButton(driver);
    ballotPage.clickSignCross(driver);
    Assert.assertEquals(driver.findElement(appContentHeader).getText().toLowerCase(), "ballot receipt");
  }
  @Test(priority=29)
  public void checkSignBallot(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickSignButton(driver);
    ballotPage.clickConfirmSign(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(submitBallotInf));
    Assert.assertEquals(signBallotPage.getSignedBallotTitle(driver).toLowerCase(), "ballot has been signed");
  }
  @Test(priority=30)
  public void checkDiscardSignBallot(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickSignButton(driver);
    ballotPage.inputPin(driver, 2);
    ballotPage.clickConfirmSign(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(submitBallotInf));
    signBallotPage.clickDiscardBallot(driver);
    Assert.assertEquals(ballotPage.ballotPageTitle(driver).toLowerCase(), "your unsigned ballot");
  }
  @Test(priority=31)
  public void checkNoSecretPinInput(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickSignButton(driver);
    ballotPage.clickConfirmSign(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(warningPin));
    Assert.assertTrue(driver.findElement(By.className("decrypt-desc")).getText().equals("Warning, input your secret PIN2")); //need to be changed if bug will be fixed
  }
  @Test(priority=32)
  public void checkReturnFromDecrBallot(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickDecrypButton(driver);
    ballotPage.clickDecryptBallot(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(decrBallot));
    decrBallotPage.discardDecryptedBallot(driver);
    Assert.assertEquals(driver.findElement(appContentHeader).getText().toLowerCase(), "ballot receipt");
  }
  @Test(priority=33)
  public void checkSaveDecrBallot(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickDecrypButton(driver);
    ballotPage.clickDecryptBallot(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(decrBallot));
    decrBallotPage.saveDecryptedBallot(driver);
    Assert.assertEquals(driver.findElement(appContentHeader).getText().toLowerCase(), "ballot is saved");
  }
  @Test(priority=33)
  public void checkSubmitSignedBallotWithEmail(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickSignButton(driver);
    ballotPage.inputPin(driver, 2);
    ballotPage.clickConfirmSign(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(submitBallotInf));
    signBallotPage.enterEmail(driver, emailStr);
    signBallotPage.clickSubmitBallot(driver);
    Assert.assertEquals(submBallotPage.getSubmitPageTitle(driver), "Congratulations!");
  }
  @Test(priority=1)
  public void checkBlockChainExplorer(){
    stPage.getStartPage(driver,url, startedPageText);
    stPage.getVoitInEllectionPage(driver);
    evoitPage.enableRadioButton(driver, usPresidentElBut);
    evoitPage.clickVoteButton(driver);
    candsPage.chooseCandidate(driver, hillCl);
    candsPage.clickVoteButton(driver);
    candsPage.clickYes(driver);
    ballotPage.clickSignButton(driver);
    ballotPage.inputPin(driver, 2);
    ballotPage.clickConfirmSign(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(submitBallotInf));
    signBallotPage.enterEmail(driver, emailStr);
    signBallotPage.clickSubmitBallot(driver);
    Assert.assertTrue(submBallotPage.blockChainExpl(driver).toLowerCase().contains("transaction"));
  }

}
