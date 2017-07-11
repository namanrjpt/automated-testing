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

public class safetyPlanWorksheetsTests {
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
    public void canGoToSafetyPlanWorksheet(){
        sideInMenuBarElements.safetyToolsTab().click();

        try{
            driver.waitDriverForElement(safetyToolsElements.safetyPlanWorksheetTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        safetyToolsElements.safetyPlanWorksheetTab().click();
        try{
            driver.waitDriverForElement(safetyToolsElements.safetyPlanWorksheetTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }
        Assert.assertEquals(safetyTools.canGoToSafetyPlanWorksheet(), true, "\"Safety Plan Worksheet\" page is not loaded!");

    }

    @Test(priority = 1)
    public void safetyPlanWorksheetpage1CardsPresent(){
        Assert.assertEquals(safetyToolsElements.safetyPlanWorksheetUiCards().get(0).isDisplayed() && safetyToolsElements.safetyPlanWorksheetUiCards().get(1).isDisplayed(), true, "\"Safety Plan Worksheet\" page 1 UI cards are not shown");
    }

    @Test(priority = 2)
    public void canNavigateTo2ndPage(){
        safetyToolsElements.rightNavButton().click();
        Assert.assertEquals(safetyToolsElements.safetyPlanWorksheetUiCards().get(2).isDisplayed() && safetyToolsElements.safetyPlanWorksheetUiCards().get(3).isDisplayed(), true, "\"Safety Plan Worksheet\" page 1 UI cards are not shown");
    }

    @Test(priority = 3)
    public void canNavigateTo3rdPage(){
        safetyToolsElements.rightNavButton().click();
        Assert.assertEquals(safetyToolsElements.safetyPlanWorksheetUiCards().get(4).isDisplayed() && safetyToolsElements.safetyPlanWorksheetUiCards().get(5).isDisplayed(), true, "\"Safety Plan Worksheet\" page 1 UI cards are not shown");
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
