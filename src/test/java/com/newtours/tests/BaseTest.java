package com.newtours.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public WebDriver driver;
    @BeforeTest
    public void setupDriver() throws MalformedURLException {

        DesiredCapabilities dc;
        //System.setProperty("webdriver.chrome.driver","D:\\LearningTools\\ClipboardHealth\\Docker\\src\\resources\\chromedriver.exe");
        //this.driver=new ChromeDriver();
        String host="localhost";

        if((System.getProperty("BROWSER")!=null) && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }else
        {
            dc=DesiredCapabilities.chrome();
        }
        if((System.getProperty("HUB_HOST")!=null)){
            host=System.getProperty("HUB_HOST");
        }

        String url="http://"+host+":4444/wd/hub";

        this.driver=new RemoteWebDriver(new URL(url),dc);
        //driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }


}
