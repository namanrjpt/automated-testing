package GetHelpNowTests;

import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import PageObjectModel.getHelpNowPageElements;
import PageObjectModel.sideInMenuBarElements;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by naman on 11/7/17.
 */
public class contactSARL {

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
    public void canGoToSARL()
    {
        sideInMenuBarElements.getHelpNowTab().click();
        log4j.Log.info("canGoToGetHelpNow starting");
        try{
            driver.waitDriverForElement(getHelpNowPageElements.gethelpPageTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        getHelpNowPageElements.contactSARL().click();

        try{
            driver.waitDriverForElement(getHelpNowPageElements.sarlCallButton());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(getHelpNowPageElements.sarlCallButton().isDisplayed() && getHelpNowPageElements.sarlSMSButton().isDisplayed(), true, "Contact PCMO page is not loading!");

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
