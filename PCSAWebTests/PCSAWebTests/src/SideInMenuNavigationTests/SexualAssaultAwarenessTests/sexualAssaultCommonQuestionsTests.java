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

public class sexualAssaultCommonQuestionsTests {
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
    public void canGoToSexualAssaultCommonQuestions(){
        sideInMenuBarElements.sexualAssaultAwarenesstTab().click();

        try{
            driver.waitDriverForElement(sexualAssaultAwarenessElements.sexualAssaultCommonQuestionsTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        sexualAssaultAwarenessElements.sexualAssaultCommonQuestionsTab().click();

        try{
            driver.waitDriverForElement(sexualAssaultAwarenessElements.sexualAssaultCommonQuestionsTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(sexualAssaultAwareness.canGoToSexualAssaultCommonQuestions(), true, "\"Sexual Assault Common Questions\" page is not loaded!");
    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(sexualAssaultAwarenessElements.sexualAssaultCommonQuestionsUiCards().get(0).isDisplayed(), true, "\"Sexual Assault Common Questions\" Ui cards are not loaded on 1st page!");
    }

    @Test(priority = 2)
    public void canNavigateTo2ndPage()
    {
        sexualAssaultAwarenessElements.rightNavButton().click();
        Assert.assertEquals(sexualAssaultAwarenessElements.sexualAssaultCommonQuestionsUiCards().get(2).isDisplayed() && sexualAssaultAwarenessElements.sexualAssaultCommonQuestionsUiCards().get(3).isDisplayed(), true, "\"Sexual Assault Common Questions\" Ui cards are not loaded on 2nd page!");
    }

    @Test(priority = 2)
    public void canNavigateTo3rdPage()
    {
        sexualAssaultAwarenessElements.rightNavButton().click();
        Assert.assertEquals(sexualAssaultAwarenessElements.sexualAssaultCommonQuestionsUiCards().get(4).isDisplayed(), true, "\"Sexual Assault Common Questions\" Ui cards are not loaded on 2nd page!");
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
