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

public class helpingAFriendOrCommunityMemberTests {

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
    public void canGoToHelpingAFriendOrCommunityMember(){
        sideInMenuBarElements.sexualAssaultAwarenesstTab().click();

        try{
            driver.waitDriverForElement(sexualAssaultAwarenessElements.helpingAFriendOrCommunityMemberTab());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        sexualAssaultAwarenessElements.helpingAFriendOrCommunityMemberTab().click();

        try{
            driver.waitDriverForElement(sexualAssaultAwarenessElements.helpingAFriendOrCommunityMemberTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(sexualAssaultAwareness.canGoToHelpingAFriendOrCommunityMember(), true, "\"Helping a Friend or Community Member\" page is not loaded!");
    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(sexualAssaultAwarenessElements.helpingAFriendOrCommunityMemberUiCards().get(0).isDisplayed() && sexualAssaultAwarenessElements.helpingAFriendOrCommunityMemberUiCards().get(1).isDisplayed() && sexualAssaultAwarenessElements.helpingAFriendOrCommunityMemberUiCards().get(2).isDisplayed() , true, "\"Helping a Friend or Community Member\" Ui cards are not loaded on 1st page!");
    }

    @Test(priority = 2)
    public void canNavigateTo2ndPage()
    {
        sexualAssaultAwarenessElements.rightNavButton().click();
        Assert.assertEquals(sexualAssaultAwarenessElements.helpingAFriendOrCommunityMemberUiCards().get(3).isDisplayed() && sexualAssaultAwarenessElements.helpingAFriendOrCommunityMemberUiCards().get(4).isDisplayed() && sexualAssaultAwarenessElements.helpingAFriendOrCommunityMemberUiCards().get(5).isDisplayed() , true, "\"Helping a Friend or Community Member\" Ui cards are not loaded on 2nd page!");
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
