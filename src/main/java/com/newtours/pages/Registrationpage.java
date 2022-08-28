package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Registrationpage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(name="firstName")
    private WebElement firstNameTxtBox;

    @FindBy(name="lastName")
    private WebElement lastNameTxtBox;

    @FindBy(name="email")
    private WebElement emailTxtBox;

    @FindBy(name="password")
    private WebElement passwordTxttBox;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxtBox;

    @FindBy(name="register")
    private WebElement registerBtn;




    public Registrationpage(WebDriver driver)
    {
        this.driver=driver;
        this.wait=new WebDriverWait(driver,60);
        PageFactory.initElements(this.driver,this);
    }

    public void goTo()
    {
        driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        wait.until(ExpectedConditions.visibilityOf(this.firstNameTxtBox));
    }

    public void enterUserDetails(String firstName,String lastName){
        this.firstNameTxtBox.sendKeys(firstName);
        this.lastNameTxtBox.sendKeys(lastName);
    }

    public void enterUserCredentailsDetails(String userName,String pwd,String confirmPwd){
        this.emailTxtBox.sendKeys(userName);
        this.passwordTxttBox.sendKeys(pwd);
        this.confirmPasswordTxtBox.sendKeys(confirmPwd);
    }

    public void clickSubmitButton()
    {
        this.registerBtn.click();
    }


}
