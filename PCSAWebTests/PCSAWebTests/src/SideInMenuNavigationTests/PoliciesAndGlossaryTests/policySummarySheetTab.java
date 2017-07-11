package SideInMenuNavigationTests.PoliciesAndGlossaryTests;

import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import PageObjectModel.policiesAndGlossaryElements;
import PageObjectModel.sideInMenuBarElements;
import SideInMenuBarFeatures.polciesAndGlossary;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class policySummarySheetTab {
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
    public void canGoTopolicySummarySheetTab(){
        sideInMenuBarElements.policiesAndGlossaryTab().click();

        try{
            driver.waitDriverForElement(policiesAndGlossaryElements.policySummarySheetTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        policiesAndGlossaryElements.policySummarySheetTab().click();

        try{
            driver.waitDriverForElement(policiesAndGlossaryElements.policySummarySheetTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(polciesAndGlossary.canGoToPolicySummarySheet(), true, "\"Peace Corps Policy Summary Sheet\" page is not loaded!");
    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(policiesAndGlossaryElements.policySummarySheetUiCards().isDisplayed(), true, "\"Peace Corps Policy Summary Sheet\" Ui cards not present on 1st page");
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
