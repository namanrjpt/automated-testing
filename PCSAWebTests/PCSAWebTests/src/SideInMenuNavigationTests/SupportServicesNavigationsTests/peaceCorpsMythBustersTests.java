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

public class peaceCorpsMythBustersTests {
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
    public void canGoToPeaceCorpsMythbusters()
    {
        sideInMenuBarElements.supportServicesTab().click();

        try{
            driver.waitDriverForElement(supportServicesElements.peaceCorpsMythbustersTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        supportServicesElements.peaceCorpsMythbustersTab().click();

        try{
            driver.waitDriverForElement(supportServicesElements.peaceCorpsMythbustersTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(supportServices.canGoToPeaceCorpsMythbusters(), true, "\"Peace Corps Mythbusters\" page is not loading!");

    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(supportServicesElements.peaceCorpsMythbustersUiCards().get(0).isDisplayed() && supportServicesElements.peaceCorpsMythbustersUiCards().get(1).isDisplayed(), true, "\"Peace Corps Mythbusters\" UI Cards are not loading on 1st page!");
    }

    @Test(priority = 2)
    public void canNavigateTo2ndPage()
    {
        supportServicesElements.rightNavButton().click();
        Assert.assertEquals(supportServicesElements.peaceCorpsMythbustersUiCards().get(2).isDisplayed() && supportServicesElements.peaceCorpsMythbustersUiCards().get(3).isDisplayed(), true, "\"Peace Corps Mythbusters\" UI Cards are not loading on 2nd page!");
    }

    @Test(priority = 3)
    public void canNavigateTo3rddPage()
    {
        supportServicesElements.rightNavButton().click();
        Assert.assertEquals(supportServicesElements.peaceCorpsMythbustersUiCards().get(4).isDisplayed() && supportServicesElements.peaceCorpsMythbustersUiCards().get(5).isDisplayed(), true, "\"Peace Corps Mythbusters\" UI Cards are not loading on 2nd page!");
    }

    @Test(priority = 4)
    public void canNavigateTo4thPage()
    {
        supportServicesElements.rightNavButton().click();
        Assert.assertEquals(supportServicesElements.peaceCorpsMythbustersUiCards().get(6).isDisplayed() && supportServicesElements.peaceCorpsMythbustersUiCards().get(7).isDisplayed(), true, "\"Peace Corps Mythbusters\" UI Cards are not loading on 2nd page!");
    }

    @Test(priority = 5)
    public void canNavigateTo5thPage()
    {
        supportServicesElements.rightNavButton().click();
        Assert.assertEquals(supportServicesElements.peaceCorpsMythbustersUiCards().get(8).isDisplayed(), true, "\"Peace Corps Mythbusters\" UI Cards are not loading on 2nd page!");
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
