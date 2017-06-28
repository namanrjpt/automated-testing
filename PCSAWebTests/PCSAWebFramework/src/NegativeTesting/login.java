package NegativeTesting;

import Logs.log4j;
import PageObjectModel.constants;
import PageObjectModel.loginPageElements;
import WebDriver.driver;
import org.openqa.selenium.WebElement;

/**
 * Created by naman on 18/6/17.
 */
public class login {

    /*
    * here methods starting with try_____ will be the actual tests
    * */
    public static void tryBlankFields(){
        log4j.Log.info("Negative login test: testing blank fields");


        WebElement emailId = loginPageElements.emailId();
        WebElement password = loginPageElements.password();
        WebElement submit = loginPageElements.signInButton();
        log4j.Log.info("Clearing emailID and password fields for negative testing!");
        emailId.clear();
        password.clear();
        submit.click();

    }

    public static void tryPartiallyFilledForm(){
        log4j.Log.info("Negative login test: testing partially filled form");


        WebElement emailId = loginPageElements.emailId();
        WebElement password = loginPageElements.password();
        WebElement submit = loginPageElements.signInButton();
        log4j.Log.info("Clearing emailID and password fields for negative testing!");
        emailId.clear();
        loginPageElements.emailId().sendKeys(constants.emailForNegativeTesting);
        password.clear();
        submit.click();

    }

    public static void tryInvalidEmailFormat(String invalidEmail){
        log4j.Log.info("Negative login test: testing invalid email format");
        log4j.Log.info("Clearing emailID and password fields for negative testing!");
        loginPageElements.emailId().clear();
        loginPageElements.emailId().sendKeys(invalidEmail);
        loginPageElements.password().clear();
        loginPageElements.password().sendKeys(constants.passwordForNegativeTesting);
        loginPageElements.signInButton().click();


    }

    public static void tryWrongCredentials(){
        log4j.Log.info("Negative login test: testing login with wrong credentials");
        log4j.Log.info("Clearing emailID and password fields for negative testing!");
        loginPageElements.emailId().clear();
        loginPageElements.emailId().sendKeys(constants.emailForNegativeTesting);
        loginPageElements.password().clear();
        loginPageElements.password().sendKeys(constants.passwordForNegativeTesting);
        loginPageElements.signInButton().click();
    }

    /*
    * Here methods starting with appearance_____ will be checks to validate the above tests
    * */

    public static boolean appearanceOfEmailPrompt(){
        if(loginPageElements.loginEmailIdRedPrompt().isDisplayed()){
            log4j.Log.info("email red prompt is shown!");
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean appearanceOfPasswordPrompt(){
        if(loginPageElements.loginPasswordRedPrompt().isDisplayed()){
            log4j.Log.info("password red prompt is shown!");
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean appearanceOfAlertInvalidEmail(){
        if(loginPageElements.alertInvalidEmail().isDisplayed()){
            log4j.Log.info("Invalid email alert is shown!");
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean appearanceOfAlertWrongCredentials(){
        if(loginPageElements.alertWrongCredentials().isDisplayed()){
            log4j.Log.info("Invalid Credentials alert is shown!");
            return true;
        }
        else{
            return false;
        }
    }
}