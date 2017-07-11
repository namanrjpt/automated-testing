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

public class safetyPlanBasicsTests {
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
    public void canGoToSafetyPlanBasics(){
        sideInMenuBarElements.safetyToolsTab().click();

        try{
            driver.waitDriverForElement(safetyToolsElements.safetyPlanBasicsTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        safetyToolsElements.safetyPlanBasicsTab().click();
        try{
            driver.waitDriverForElement(safetyToolsElements.safetyPlanBasicsTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }
        Assert.assertEquals(safetyTools.canGoToSafetyPlanBasics(), true, "\"Safety Plan Basics\" page is not loaded!");

    }

    @Test(priority = 1)
    public void safetyPlanBasicsPage1CardsPresent(){
        Assert.assertEquals(safetyToolsElements.safetyPlanBasicsUiCards().get(0).isDisplayed() && safetyToolsElements.safetyPlanBasicsUiCards().get(1).isDisplayed(), true, "Informative UI cards are not shown!");
    }

    @Test(priority = 2)
    public void canNavigateTo2ndPage(){
        safetyToolsElements.rightNavButton().click();

        Assert.assertEquals(safetyToolsElements.safetyPlanBasicsUiCards().get(2).isDisplayed(), true, "Informative UI cards are not shown!");
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
