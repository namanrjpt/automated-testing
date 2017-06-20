package NegativeTesting;

import Logs.log4j;
import PageObjectModel.constants;
import PageObjectModel.loginPageElements;
import PageObjectModel.registrationPageElements;
import WebDriver.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by naman on 18/6/17.
 */
public class signUp {

    private static WebElement emailId = registrationPageElements.emaiId();
    private static WebElement username = registrationPageElements.username();
    private static WebElement password = registrationPageElements.password();
    private static WebElement confirmPassword = registrationPageElements.confirmPassword();
    private static WebElement hostCountry = registrationPageElements.hostCountry();
    private static WebElement signUpButton = registrationPageElements.signUpButton();

    public static void allBlankFields(){
        log4j.Log.info("Negative Sign-Up test: testing registration with blank form");
        emailId.clear();
        username.clear();
        password.clear();
        confirmPassword.clear();
        signUpButton.click();
    }

    public static void blankEmailId(){
        log4j.Log.info("Negative Sign-Up test: testing registration with blank form");
        emailId.clear();
        username.clear();
        username.sendKeys(constants.usernameForNegativeTesting);
        password.clear();
        password.sendKeys(constants.passwordForNegativeTesting);
        confirmPassword.clear();
        confirmPassword.sendKeys(constants.matchingConfirmPasswordForNegativeTesting);
        hostCountry.click();
        (new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.visibilityOf(registrationPageElements.countryListDropDown()));
        registrationPageElements.countryOptionInDropdown(constants.countryForNegativeTesting).click();
        (new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[contains(@class, 'menu transition visible')]")));

        signUpButton.click();
    }

    public static void blankUsername(){
        log4j.Log.info("Negative Sign-Up test: testing registration with blank form");
        emailId.clear();
        emailId.sendKeys(constants.emailForNegativeTesting);
        username.clear();
        password.clear();
        password.sendKeys(constants.passwordForNegativeTesting);
        confirmPassword.clear();
        confirmPassword.sendKeys(constants.matchingConfirmPasswordForNegativeTesting);
        hostCountry.click();
        (new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.visibilityOf(registrationPageElements.countryListDropDown()));
        registrationPageElements.countryOptionInDropdown(constants.countryForNegativeTesting).click();
        (new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[contains(@class, 'menu transition visible')]")));
        signUpButton.click();
    }

    public static void blankPassword(){
        log4j.Log.info("Negative Sign-Up test: testing registration with blank form");
        emailId.clear();
        emailId.sendKeys(constants.emailForNegativeTesting);
        username.clear();
        username.sendKeys(constants.usernameForNegativeTesting);
        password.clear();
        confirmPassword.clear();
        confirmPassword.sendKeys(constants.matchingConfirmPasswordForNegativeTesting);
        hostCountry.click();
        (new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.visibilityOf(registrationPageElements.countryListDropDown()));
        registrationPageElements.countryOptionInDropdown(constants.countryForNegativeTesting).click();
        (new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[contains(@class, 'menu transition visible')]")));
        signUpButton.click();
    }

    /*
    * Here blank confirm password field will also be considered as mismatched passwords
    * ans should show "Password did not match prompt"
    * */
    public static void mismatchedPasswords(){
        log4j.Log.info("Negative Sign-Up test: testing registration with blank form");
        emailId.clear();
        emailId.sendKeys(constants.emailForNegativeTesting);
        username.clear();
        username.sendKeys(constants.usernameForNegativeTesting);
        password.clear();
        password.sendKeys(constants.passwordForNegativeTesting);
        confirmPassword.clear();
        confirmPassword.sendKeys(constants.mismatchingConfirmPasswordForNegativeTesting);
        hostCountry.click();
        (new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.visibilityOf(registrationPageElements.countryListDropDown()));
        registrationPageElements.countryOptionInDropdown(constants.countryForNegativeTesting).click();
        (new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[contains(@class, 'menu transition visible')]")));
        signUpButton.click();
    }

    public static void blankCountry(){
        log4j.Log.info("Negative Sign-Up test: testing registration with blank form");
        emailId.clear();
        emailId.sendKeys(constants.emailForNegativeTesting);
        username.clear();
        username.sendKeys(constants.usernameForNegativeTesting);
        password.clear();
        password.sendKeys(constants.passwordForNegativeTesting);
        confirmPassword.clear();
        confirmPassword.sendKeys(constants.mismatchingConfirmPasswordForNegativeTesting);
        signUpButton.click();
    }

    /*
    * Here methods starting with appearance_____ will be checks to validate the above tests
    * */

    public static boolean appearanceOfEmailPrompt(){
        if(registrationPageElements.signUpEmailIdRedPrompt().isDisplayed()){
            log4j.Log.info("read email prompt is shown!");
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean appearanceOfUsernamePrompt(){
        if(registrationPageElements.signUpNameRedPrompt().isDisplayed()){
            log4j.Log.info("red username prompt is shown!");
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean appearanceOfPasswordPrompt(){
        if(registrationPageElements.signUpPasswordRedPrompt().isDisplayed()){
            log4j.Log.info("read password prompt is shown!");
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean appearanceOfConfirmPasswordPrompt(){
        if(registrationPageElements.signUpConfirmPasswordRedPrompt().isDisplayed()){
            log4j.Log.info("read mismatched password prompt is shown!");
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean appearanceOfCountryPrompt(){
        if(registrationPageElements.signUpCountryRedPrompt().isDisplayed()){
            log4j.Log.info("red country prompt is shown!");
            return true;
        }
        else{
            return false;
        }
    }



}
