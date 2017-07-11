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

public class glossaryTests {
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
    public void canGoToGlossaryTab(){
        sideInMenuBarElements.policiesAndGlossaryTab().click();

        try{
            driver.waitDriverForElement(policiesAndGlossaryElements.glossaryTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        policiesAndGlossaryElements.glossaryTab().click();

        try{
            driver.waitDriverForElement(policiesAndGlossaryElements.glossaryTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(polciesAndGlossary.canGoToGlossary(), true, "\"Glossary\" page is not loaded!");
    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(policiesAndGlossaryElements.policySummarySheetUiCards().isDisplayed(), true, "\"Glossary\" Ui cards are not loaded on 1 st page!");
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
