/*
 * @author Anjali
 * @since 2016-06-13
 * This class navigates to the registration page and validates against user registration in the application.
 */

package LoginAndRegistration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Logs.log4j;
import PageObjectModel.constants;
import PageObjectModel.loginPageElements;
import PageObjectModel.registrationPageElements;
import WebDriver.driver;

import java.io.IOException;


public class registration
{
	private static String URL;

	/*
	 * Takes to the registration page.
	 */
	public static void Goto() 
	{
		
		driver.Instance.get(constants.baseURL);
		log4j.Log.info("Navigating to the registration page");
		WebElement gotoCreateAccount = registrationPageElements.gotoCreateAccountLink();
		try{
			driver.waitDriverForElement(registrationPageElements.gotoCreateAccountLink());
		}catch (IOException e){
			System.out.print(e);
		}
		gotoCreateAccount.click();
		try{
			driver.waitDriverForElement(registrationPageElements.emaiId());
		}catch (IOException e){
			System.out.print(e);
		}

	}
	
	/*
	 * @return true if at registration page else false
	 */
	public static boolean isAtRegistrationPage()
	{
		URL = driver.Instance.getCurrentUrl();
		if(URL.contains(constants.baseURL))
		{
			log4j.Log.info("At Registration Page");
			return true;
		}
		else 
			return false;
	}
	
	public static String checkForAlert()
	{
		Alert simpleAlert = driver.Instance.switchTo().alert();
		String alertText = simpleAlert.getText();
		simpleAlert.accept();
		return alertText;
	}
    
	/*
	 * @param Username for registration is the first parameter
	 * @param Password for registration is the second parameter
	 * @param Host Country for registration is the third parameter
	 * @param Email for registration is the forth parameter
	 */
	public static void registerWith(String emailId, String username, String password, String confirmPassword, String country)
	{
		
		if(isAtRegistrationPage())
		{
			WebElement usrnm, passwrd, cntry, emlID, signUpButton, cnfPasswrd;
			usrnm = registrationPageElements.username();
			cnfPasswrd = registrationPageElements.confirmPassword();
			passwrd = registrationPageElements.password();
			cntry = registrationPageElements.hostCountry();
			emlID = registrationPageElements.emaiId();
			signUpButton = registrationPageElements.signUpButton();
			emlID.clear();
			emlID.sendKeys(emailId);
			usrnm.clear();
			usrnm.sendKeys(username);
			passwrd.clear();
			passwrd.sendKeys(password);
			cnfPasswrd.clear();
			cnfPasswrd.sendKeys(confirmPassword);

			cntry.click();
			(new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.visibilityOf(registrationPageElements.countryListDropDown()));
			registrationPageElements.countryOptionInDropdown(country).click();
			(new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//div[contains(@class, 'menu transition visible')]")));

			signUpButton.click();
			//System.out.println("reaching here");

		}
		else
			return;
		
	}

	/*
	 * Validates Registration
	 * @return true if user is at the welcome page after registration else false
	 */
	public static boolean hasRegistered() 
	{	
		System.out.println("inside hasRegistered");
		System.out.println(driver.Instance.getCurrentUrl());

		(new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.visibilityOf(registrationPageElements.successfulRegistrationAlert()));
		if(registrationPageElements.successfulRegistrationAlert().isDisplayed()){
			(new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.stalenessOf(loginPageElements.emailId()));
			(new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.visibilityOf(loginPageElements.emailId()));
			if(loginPageElements.emailId().isDisplayed()){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

}
