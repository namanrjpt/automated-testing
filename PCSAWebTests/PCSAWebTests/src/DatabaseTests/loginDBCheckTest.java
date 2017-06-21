/*
 * @author Anjali
 * @since 2016-06-28
 * This script checks the DB for login data passed from the test. If the data is present it passes otherwise it fails.
 */
package DatabaseTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Database.dbChecks;
import Logs.log4j;

public class loginDBCheckTest extends dbConnection
{
	@DataProvider(name = "Authentication")
	public static Object[][] credentials()
	{
		return new Object[][]{{"test_user_one@email.com"}};
	}
	
	/*
	 * Verify if the user is present in the DB.
	 */
	@Test(dataProvider="Authentication")
	public void test(String email)
	{
		log4j.Log.info("Starting loginDBCheckTest");
		Assert.assertEquals(dbChecks.isLoginDataPresent(email), true, "loginDBCheckTest");//actual,expected
		log4j.Log.info("loginDBCheckTest over");
	}
}
