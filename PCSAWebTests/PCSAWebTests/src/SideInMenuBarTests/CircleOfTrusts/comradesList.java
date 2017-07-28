package SideInMenuBarTests.CircleOfTrusts;

import CircleOfTrustFeatures.circleOfTrust;
import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import PageObjectModel.circleOfTrustPageElements;
import PageObjectModel.sideInMenuBarElements;
import WebDriver.driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class comradesList {

    @BeforeClass
    public static void startDriver()
    {
        try
        {
            driver.initalizeDriver();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        existingUserLogin.login();
    }

    @Test(priority = 0)
    public void canGoToComradesListPage(){
        log4j.Log.info("Starting comrades list page navigation Test");
        WebElement circleOfTrustTab = sideInMenuBarElements.circleOfTrustTab();
        try{
            driver.waitDriverForElement(circleOfTrustTab);
        }
        catch(IOException e){
            log4j.Log.info(e);
        }
<<<<<<< c042a03ba3b8b971ab37eba8b55f1776f672258d

=======
>>>>>>> Adds Circle of Trust navigations and editing comrads list test
        circleOfTrustTab.click();

        try{
            driver.waitDriverForElement(circleOfTrustPageElements.circleOfTrustEditButton());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }
        circleOfTrustPageElements.circleOfTrustEditButton().click();

        try{
            driver.waitDriverForElement(circleOfTrustPageElements.comrade1_TextBox());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }
        Assert.assertEquals(circleOfTrustPageElements.comrade1_TextBox().isDisplayed(), true, "Navigation to Comrades List Page has failed");

    }

    @Test(priority = 1)
    public void canEditComradesList(){
        log4j.Log.info("Starting edit comrades list test");
        Assert.assertEquals(circleOfTrust.canEditComradesNumbers("12345678"), true, "Editing failed on the Edit comrade page");
    }



    @AfterClass
    public static void tearDown()
    {
        try
        {
            driver.closeDriver();
        }
        catch( Exception e)
        {
            e.printStackTrace();
        }
    }

}
