/*
 * @author Anjali
 * @since 2016-06-11
 * This script checks login by taking in different permutations of successful and failure login credentials.
 */
package LoginAndRegistrationTests;

import LoginAndRegistration.loginCommand;
import PageObjectModel.loginPageElements;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTests.commonTest;
import LoginAndRegistration.loggedInCheck;
import LoginAndRegistration.loginPage;
import Logs.log4j;
import PageObjectModel.constants;
import Utilities.excelUtil;

import java.io.IOException;

public class loginTest extends commonTest
{
	/*
	 * @return Data for test cases 
	 * @throws Exception
	 */
	@DataProvider(name="Authentication")
	public Object[][] loginData() throws Exception
	{
	       Object[][] testObjArray = excelUtil.getDataFromExcel("src//TestData//TestsData.xlsm",constants.loginSheet);
	       return (testObjArray);
	  }
	
	/*
	 * @param EmailId is the first parameter
	 * @param Password is the second parameter
	 */
	@Test(dataProvider="Authentication")
	public void test(String emailId, String password)
	{
		log4j.Log.info("Starting Login test");
		loginPage.Goto();
		loginCommand logInObj = new loginCommand(emailId).withPassword(password);
		try {
			driver.waitDriverForElement(loginPageElements.emailId());
		}catch(IOException ex) {
			System.out.print(ex);
		}
		log4j.Log.info("On login page");
		logInObj.login();
		Assert.assertEquals(loggedInCheck.hasLogeedIn(), true, "Login failed");
		log4j.Log.info("Login test over");
	}
	
}
