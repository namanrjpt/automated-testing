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

public class radarTests {
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
    * Radar tests
    * */
    @Test(priority = 0)
    public void canGoToRADAR(){
        sideInMenuBarElements.safetyToolsTab().click();
        safetyToolsElements.radarTab().click();
        try{
            driver.waitDriverForElement(safetyToolsElements.radarTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }
        Assert.assertEquals(safetyTools.canGotoRadar(), true, "RADAR page is not loaded!");

    }

    @Test(priority = 1)
    public void RADARPage1CardsPresent(){

        Assert.assertEquals(safetyToolsElements.radarUiCards().get(0).isDisplayed() && safetyToolsElements.radarUiCards().get(1).isDisplayed(), true, "Informative UI cards are not shown!");
    }

    @Test(priority = 2)
    public void canNavigateTo2ndPage(){
        safetyToolsElements.rightNavButton().click();

        Assert.assertEquals(safetyToolsElements.radarUiCards().get(2).isDisplayed() && safetyToolsElements.radarUiCards().get(3).isDisplayed(), true, "Informative UI cards are not shown!");
    }

    @Test(priority = 3)
    public void canNavigateTo3rdPage(){
        safetyToolsElements.rightNavButton().click();

        Assert.assertEquals(safetyToolsElements.radarUiCards().get(4).isDisplayed() && safetyToolsElements.radarUiCards().get(5).isDisplayed(), true, "Informative UI cards are not shown!");
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
