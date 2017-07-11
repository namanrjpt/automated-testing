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

public class sexualHarassmentTests {
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
    public void canGoToSexualHarassment(){
        sideInMenuBarElements.sexualAssaultAwarenesstTab().click();

        try{
            driver.waitDriverForElement(sexualAssaultAwarenessElements.sexualHarassmentTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        sexualAssaultAwarenessElements.sexualHarassmentTab().click();

        try{
            driver.waitDriverForElement(sexualAssaultAwarenessElements.sexualHarassmentTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(sexualAssaultAwareness.canGoToSexualHarassment(), true, "\"Sexual Harassment\" page is not loaded!");
    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(sexualAssaultAwarenessElements.sexualHarassmentUiCards().isDisplayed(), true, "\"Sexual Harassment\" Ui cards are not loaded on 1st page!");
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
