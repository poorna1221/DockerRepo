package com.newtours.tests;

import com.newtours.pages.RegistrationConfirmationPage;
import com.newtours.pages.Registrationpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest{

    @Test

    public void registerForNewToursSite()
    {
        Registrationpage rp=new Registrationpage(driver);
        RegistrationConfirmationPage rcp= new RegistrationConfirmationPage(driver);
        rp.goTo();
        rp.enterUserDetails("Chandra","lastName");
        rp.enterUserCredentailsDetails("poorna948","12345","12345");
        rp.clickSubmitButton();
        rcp.waitForConfirmaitonPage();
        rcp.clickContinueButton();
        rcp.clickReserveFlightsButton();
        String actualText=rcp.getText();
        Assert.assertEquals(actualText, "Flight Itinerary Page");

    }


}
