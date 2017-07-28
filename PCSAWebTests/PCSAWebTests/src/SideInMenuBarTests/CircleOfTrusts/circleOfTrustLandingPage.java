package SideInMenuBarTests.CircleOfTrusts;

import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import SideInMenuBarFeatures.sideInMenu;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class circleOfTrustLandingPage {

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

    @Test
    public void canGoToCircleOfTrustTab(){
        log4j.Log.info("Starting circleOfTrustNavigationTest");
        Assert.assertEquals(sideInMenu.canNavigateToCircleOfTrust(), true, "circleOfTrustNavigationTest failed");
        log4j.Log.info("circleOfTrustNavigationTest over");
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
