package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationConfirmationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(partialLinkText="sign-in")
    private WebElement signOnMsg;

    @FindBy(linkText="Flights")
    private WebElement flightsLink;

    @FindBy(name="findFlights")
    private WebElement continueBtn;

    @FindBy(name="reserveFlights")
    private WebElement reserveFlights;
    @FindBy(name="buyFlights")
    private WebElement buyFlights;

    @FindBy(xpath="//h1/font")
    private WebElement findIternaryPage;


    public RegistrationConfirmationPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(this.driver,this);
    }

    public void waitForConfirmaitonPage()
    {
        this.wait.until(ExpectedConditions.visibilityOf(signOnMsg));
        this.flightsLink.click();
    }

    public void wait(WebElement ele)
    {
        this.wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public void clickContinueButton()
    {
        wait(this.continueBtn);
        this.continueBtn.click();
    }
    public void clickReserveFlightsButton()
    {
        wait(this.reserveFlights);
        this.reserveFlights.click();
        wait(this.buyFlights);
        this.buyFlights.click();
    }

    public String getText()
    {
        wait(this.findIternaryPage);
        return this.findIternaryPage.getText();
    }

}
