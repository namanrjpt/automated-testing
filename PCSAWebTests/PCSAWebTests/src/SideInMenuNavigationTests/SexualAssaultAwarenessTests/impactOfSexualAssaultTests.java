package SideInMenuNavigationTests.SexualAssaultAwarenessTests;

import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import PageObjectModel.sexualAssaultAwarenessElements;
import PageObjectModel.sideInMenuBarElements;
import SideInMenuBarFeatures.sexualAssaultAwareness;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class impactOfSexualAssaultTests {
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
    public void canGoToImpactOfSexualAssaultTests(){
        sideInMenuBarElements.sexualAssaultAwarenesstTab().click();

        try{
            driver.waitDriverForElement(sexualAssaultAwarenessElements.impactOfSexualAssaultTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        sexualAssaultAwarenessElements.impactOfSexualAssaultTab().click();

        try{
            driver.waitDriverForElement(sexualAssaultAwarenessElements.impactOfSexualAssaultTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(sexualAssaultAwareness.canGoToImpactOfSexualAssault(), true, "\"Impact Of Sexual Assault\" page is not loaded!");
    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(sexualAssaultAwarenessElements.impactOfSexualAssaultUiCards().get(0).isDisplayed() && sexualAssaultAwarenessElements.impactOfSexualAssaultUiCards().get(1).isDisplayed() && sexualAssaultAwarenessElements.impactOfSexualAssaultUiCards().get(2).isDisplayed(), true, "\"Sexual Assault Common Questions\" Ui cards are not loaded on 1st page!");
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
