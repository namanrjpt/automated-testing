package NegativeTests;

import BaseTests.commonTest;
import LandingPage.landingPageNavigation;
import PageObjectModel.loginPageElements;
import WebDriver.driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import NegativeTesting.login;

import java.io.IOException;

/**
 * Created by naman on 18/6/17.
 */
public class negativeLoginTests extends commonTest {
    @Test
    public void blankFieldsTest(){
        landingPageNavigation.navigateToURL();
        login.tryBlankFields();
        Assert.assertEquals((login.appearanceOfEmailPrompt() && login.appearanceOfPasswordPrompt()), true, "Login failed");
    }

    @Test
    public void partiallyFilledForm(){
        landingPageNavigation.navigateToURL();
        login.tryPartiallyFilledForm();
        Assert.assertEquals(login.appearanceOfPasswordPrompt(), true, "Invalid Email alert is not showing!");
    }


    @Test
    public void invalidEmailTest(){
        landingPageNavigation.navigateToURL();
        login.tryInvalidEmailFormat();
        Assert.assertEquals(login.appearanceOfAlertInvalidEmail(), true, "Invalid Email alert is not showing!");
    }

    @Test
    public void invalidCredentialsTest(){
        landingPageNavigation.navigateToURL();
        login.tryWrongCredentials();
        Assert.assertEquals(login.appearanceOfAlertWrongCredentials(), true, "Invalid Credentials alert is not showing!");
    }


}
