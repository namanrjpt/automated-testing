package SideInMenuBarTests.CircleOfTrusts;


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

public class helpMeTests {

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
    public void canGoToHelpMePage(){
        log4j.Log.info("Starting help me page navigation Test");
        WebElement circleOfTrustTab = sideInMenuBarElements.circleOfTrustTab();

        try{
            driver.waitDriverForElement(circleOfTrustTab);
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        circleOfTrustTab.click();

        try{
            driver.waitDriverForElement(circleOfTrustPageElements.circleOfTrustHelpMeButton());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }
        circleOfTrustPageElements.circleOfTrustHelpMeButton().click();

        try{
            driver.waitDriverForElement(circleOfTrustPageElements.msg1_Button());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(circleOfTrustPageElements.msg1_Button().isDisplayed() &&  circleOfTrustPageElements.msg2_Button().isDisplayed() && circleOfTrustPageElements.msg3_Button().isDisplayed() , true, "Help me page is not loaded");
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
