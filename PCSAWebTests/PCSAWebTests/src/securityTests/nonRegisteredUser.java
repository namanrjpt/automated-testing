package securityTests;

import BaseTests.commonTest;
import Logs.log4j;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Security.*;

import java.util.concurrent.TimeUnit;


public class nonRegisteredUser extends commonTest {

    /*
    * This test is going to all the URLs listed in 'URLsForTestingSecurity' list and, for a non-registered user,
    * passes if the app is redirecting the same user to the landing page (login / signup page) every time a request to
    * access an inner page is made.
    * */
    @Test
    public static void canAccessUrls()
    {
        driver.Instance.manage().timeouts().implicitlyWait(1500, TimeUnit.MILLISECONDS);

        boolean status;
        for(String s: URLsForTestingSecurity.URLsForTestingSecurity){
            log4j.Log.info("Testing URL:" + s);
            if(Security.nonRegisteredUser.isRedirectingToLandingPage(s)){
                status = true;
            }
            else{
                status = false;
            }
            Assert.assertEquals(status, true, "Security Test Failed! A Non-Registered user can access the URL" + s);
        }
    }

}
