package DatabaseTests;

import Database.dbChecks;
import LoginAndRegistration.registration;
import Logs.log4j;
import PageObjectModel.constants;
import Utilities.excelUtil;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by naman on 21/6/17.
 */
public class signUpDBCheckTest extends dbConnection{

    @DataProvider(name="Registration")
    public Object[][] registrationData() throws Exception
    {
        Object[][] testObjArray = excelUtil.getDataFromExcel("src//TestData//TestsData.xlsm", constants.registrationSheet);
        return (testObjArray);
    }

	/*
	 * @param Username for registration is the first parameter
	 * @param Password for registration is the second parameter
	 * @param Host Country for registration is the third parameter
	 * @param Email for registration is the forth parameter
	 */

    @Test(dataProvider="Registration")
    public void test(String emailId, String username, String password, String confirmPassword, String country){
        log4j.Log.info("Starting Registration Test");

        /*
        * Starting driver
        * */
        try
        {
            driver.initalizeDriver();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        registration.Goto();
        registration.registerWith(emailId, username, password, confirmPassword, country);

        /*
        * DB test
        * */
        log4j.Log.info("Starting loginDBCheckTest");
        Assert.assertEquals(dbChecks.isLoginDataPresent(emailId) && registration.hasRegistered(), true, "SignUp database test failed!");//actual,expected
        log4j.Log.info("loginDBCheckTest over");

        /*
        * Killing driver
        * */
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
