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

public class furtherResources {
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
    public void canGoToFurtherResourcesTab(){
        sideInMenuBarElements.policiesAndGlossaryTab().click();

        try{
            driver.waitDriverForElement(policiesAndGlossaryElements.furtherResourcesTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        policiesAndGlossaryElements.furtherResourcesTab().click();

        try{
            driver.waitDriverForElement(policiesAndGlossaryElements.furtherResourcesTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(polciesAndGlossary.canGoToFurtherResources(), true, "\"Further Resources\" page is not loaded!");
    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(policiesAndGlossaryElements.furtherResourcesUiCards().isDisplayed(), true, "\"Further Resources\" Ui cards are not loaded on 1 st page!");
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
