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
public class pcSavesAnonymousHelpline {

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
    public void canGoToPCSavesAnonymousHelpline()
    {
        sideInMenuBarElements.getHelpNowTab().click();
        log4j.Log.info("canGoToGetHelpNow starting");
        try{
            driver.waitDriverForElement(getHelpNowPageElements.gethelpPageTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        getHelpNowPageElements.PCHelpline().click();

        try{
            driver.waitDriverForElement(getHelpNowPageElements.voiceCallButton());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(getHelpNowPageElements.voiceCallButton().isDisplayed() && getHelpNowPageElements.sendMessageButton().isDisplayed(), true, "Contact PCMO page is not loading!");

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
