package SideInMenuNavigationTests.SupportServicesNavigationsTests;

import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import PageObjectModel.sideInMenuBarElements;
import PageObjectModel.supportServicesElements;
import SideInMenuBarFeatures.supportServices;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class availableServicesAfterASexualAssaultTests {
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
    public void canGoToAvailableServicesAfterASexualAssault()
    {
        sideInMenuBarElements.supportServicesTab().click();

        try{
            driver.waitDriverForElement(supportServicesElements.availableServicesAfterASexualAssaultTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        supportServicesElements.availableServicesAfterASexualAssaultTab().click();

        try{
            driver.waitDriverForElement(supportServicesElements.availableServicesAfterASexualAssaultTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(supportServices.canGoToAvailableServicesAfterASexualAssault(), true, "\"Available services after a sexual assault\" is not shown!");

    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(supportServicesElements.availableServicesAfterASexualAssaultUiCards().get(0).isDisplayed() && supportServicesElements.availableServicesAfterASexualAssaultUiCards().get(1).isDisplayed(), true, "\"Available services after a sexual assault\" is not showing UI cards on 1st page");
    }

    @Test(priority = 2)
    public void canNavigateTo2ndPage()
    {
        supportServicesElements.rightNavButton().click();
        Assert.assertEquals(supportServicesElements.availableServicesAfterASexualAssaultUiCards().get(2).isDisplayed(), true, "\"Available Services after a Sexual Assault\" is not showing UI cards on its 2nd page");
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
