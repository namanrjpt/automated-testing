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

public class bystanderInterventionTests {
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
    public void canGoToBystanderIntervention(){

        sideInMenuBarElements.safetyToolsTab().click();
        try{
            driver.waitDriverForElement(safetyToolsElements.bystanderInterventionTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        safetyToolsElements.bystanderInterventionTab().click();
        try{
            driver.waitDriverForElement(safetyToolsElements.bystanderInterventionTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }
        Assert.assertEquals(safetyTools.canGoToBystanderIntervention(), true, "\"Bystander Intervention\" page is not loaded!");

    }

    @Test(priority = 1)
    public void bystanderInterventionPage1CardsPresent(){
        Assert.assertEquals(safetyToolsElements.bystanderInterventionUiCards().get(0).isDisplayed() && safetyToolsElements.bystanderInterventionUiCards().get(1).isDisplayed(), true, "\"Bystander Intervention UI cards are not shown\"");
    }

    @Test(priority = 2)
    public void canNavigateTo2ndPage(){
        safetyToolsElements.rightNavButton().click();
        Assert.assertEquals(safetyToolsElements.bystanderInterventionUiCards().get(2).isDisplayed() && safetyToolsElements.bystanderInterventionUiCards().get(3).isDisplayed(), true, "\"Bystander Intervention UI cards are not shown\"");
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
