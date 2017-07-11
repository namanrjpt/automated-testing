package SideInMenuNavigationTests.SafetyToolsNavigationsTests;

import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import PageObjectModel.safetyToolsElements;
import PageObjectModel.sideInMenuBarElements;
import SideInMenuBarFeatures.safetyTools;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class copingWithUnwantedAttentionTests {
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

    /*
    * Coping with unwanted attention tests
    * */
    @Test(priority = 0)
    public void canGoToCopingWithUnwantedStrategies(){
        sideInMenuBarElements.safetyToolsTab().click();

        try{
            driver.waitDriverForElement(safetyToolsElements.copingwithUnwantedAttentionTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        safetyToolsElements.copingwithUnwantedAttentionTab().click();
        try{
            driver.waitDriverForElement(safetyToolsElements.copingwithUnwantedAttentionTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }
        Assert.assertEquals(safetyTools.canGotoUnwantedAttention(), true, "\"Coping with Unwanted Attention Strategies\" page is not loaded!");

    }

    @Test(priority = 1)
    public void copingWithUnwantedPresent(){
        Assert.assertEquals(safetyToolsElements.copingWithUnwantedAttentionUiCards().get(0).isDisplayed() && safetyToolsElements.copingWithUnwantedAttentionUiCards().get(1).isDisplayed(), true, "Coping with unwanted attention ui cards are not visible");
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
