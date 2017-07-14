/*
 * @author Anjali
 * @since 2016-06-22
 * This script checks if a user is able to goto 'Get Help Now' page after successful login.
 */
package GetHelpNowTests;
import LoginAndRegistration.existingUserLogin;
import PageObjectModel.getHelpNowPageElements;
import PageObjectModel.policiesAndGlossaryElements;
import PageObjectModel.sideInMenuBarElements;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import BaseTests.commonTest;
import GetHelpNowFeatures.getHelpNow;
import Logs.log4j;

import java.io.IOException;

public class canGoToGetHelpNow
{

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

	@Test
	public void test()
	{
		sideInMenuBarElements.getHelpNowTab().click();
		log4j.Log.info("canGoToGetHelpNow starting");
		try{
			driver.waitDriverForElement(getHelpNowPageElements.gethelpPageTitle());
		}
		catch(IOException e){
			log4j.Log.info(e);
		}
		Assert.assertEquals(getHelpNow.isAtGetHelpNow(), true, "canGoToGetHelpNow failed");
		log4j.Log.info("canGoToGetHelpNow over");
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
