package SideInMenuNavigationTests.SexualAssaultAwarenessTests;

import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import PageObjectModel.safetyToolsElements;
import PageObjectModel.sideInMenuBarElements;
import PageObjectModel.sexualAssaultAwarenessElements;
import SideInMenuBarFeatures.sexualAssaultAwareness;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class wasItSexualAssaultTests {
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
    public void canGoToWasItSexualAssault(){
        sideInMenuBarElements.sexualAssaultAwarenesstTab().click();

        try{
            driver.waitDriverForElement(sexualAssaultAwarenessElements.wasItSexualAssaultTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        sexualAssaultAwarenessElements.wasItSexualAssaultTab().click();

        try{
            driver.waitDriverForElement(sexualAssaultAwarenessElements.wasItSexualAssaultTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(sexualAssaultAwareness.canGoToWasItSexualAssault(), true, "\"Was It Sexual Assault\" page is not loaded!");
    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(sexualAssaultAwarenessElements.wasItSexualAssaultUiCards().get(0).isDisplayed(), true, "\"Was it Sexual Assault?\" Ui card is not loaded on 1st page");
    }

    @Test(priority = 2)
    public void canNavigateToKnowMorePage()
    {
        sexualAssaultAwarenessElements.wasItSexualAssaultKnowMoreButton().click();
        Assert.assertEquals(sexualAssaultAwarenessElements.wasItSexualAssaultUiCards().get(0).isDisplayed(), true, "\"Was it Sexual Assault?\" know more page Ui cards is not loaded!");
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
