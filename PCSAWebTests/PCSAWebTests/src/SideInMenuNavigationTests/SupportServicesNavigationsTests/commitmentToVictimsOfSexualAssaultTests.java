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

public class commitmentToVictimsOfSexualAssaultTests {
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
    public void canGoToCommitmentToVictimsOfSexualAssault() {
        sideInMenuBarElements.supportServicesTab().click();

        try {
            driver.waitDriverForElement(supportServicesElements.commitmentToVictimsOfSexualAssaultTab());
        } catch (IOException e) {
            log4j.Log.info(e);
        }

        supportServicesElements.commitmentToVictimsOfSexualAssaultTab().click();

        try{
            driver.waitDriverForElement(supportServicesElements.commitmentToVictimsOfSexualAssaultTitle());
        }
        catch(IOException e){
            log4j.Log.info(e);
        }

        Assert.assertEquals(supportServices.canGoToCommitmentToVictimsOfSexualAssault(), true, "\"Peace Corps Commitment to Victims Of Sexual Assault\" page is not loading!");
    }

    @Test(priority = 1)
    public void page1CardsPresent()
    {
        Assert.assertEquals(supportServicesElements.commitmentToVictimsOfSexualAssaultUiCards().isDisplayed(), true,"\"Peace Corps Commitment to Victims Of Sexual Assault\" UI cards are not loading");
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
