package SideInMenuNavigationTests.SupportServicesNavigationsTests;

import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import PageObjectModel.supportServicesElements;
import PageObjectModel.sideInMenuBarElements;
import SideInMenuBarFeatures.safetyTools;
import SideInMenuBarFeatures.supportServices;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class benefitsOfSeekingStaffSupportTests {
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
    public void canGoToBenefitsofSeekingStaffSupport(){
        sideInMenuBarElements.supportServicesTab().click();

        try{
            driver.waitDriverForElement(supportServicesElements.benefitsofSeekingStaffSupportTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        supportServicesElements.benefitsofSeekingStaffSupportTab().click();

        try{
            driver.waitDriverForElement(supportServicesElements.benefitsofSeekingStaffSupportTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }
        Assert.assertEquals(supportServices.canGoToBenefitsOfSeekingStaffSupport(), true, "\"Benefits of seeking Staff Support\" page is not loaded!");

    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(supportServicesElements.benefitsofSeekingStaffSupportUiCards().isDisplayed(), true, "\"Benefits of seeking Staff Support\" UI cards are not shown");
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
