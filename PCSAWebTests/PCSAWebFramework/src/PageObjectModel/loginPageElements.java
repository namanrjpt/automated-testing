/*
 * @author Anjali
 * @since 2016-06-08
 * This class maintains page elements for Login page.
 */
package PageObjectModel;
import org.openqa.selenium.WebElement;

import WebDriver.driver;



public class loginPageElements 
{
	public static WebElement element = null;
	
	/*
	 * @return EmailId field from login page.
	 */
	public static WebElement emailId()
	{
		element = driver.Instance.findElement(constants.signInEmailId);
		return element;
	}
	
	/*
	 * @return Password field on login page.
	 */
	public static WebElement password()
	{
		element = driver.Instance.findElement(constants.signInPassword);
		return element;
	}
	
	/*
	 * @return Sign In button on login page.
	 */
	public static WebElement signInButton()
	{
		element = driver.Instance.findElement(constants.signInButton);
		return element;
	}

	/*
	 * @return red prompt for blank emailId field
	 */
	public static WebElement loginEmailIdRedPrompt()
	{
		element = driver.Instance.findElement(constants.loginEmailIdRedPrompt);
		return element;
	}

	/*
	 * @return red prompt for blank password field
	 */
	public static WebElement loginPasswordRedPrompt()
	{
		element = driver.Instance.findElement(constants.loginPasswordRedPrompt);
		return element;
	}

	/*
	 * @return sweet alert for invalid email
	 */
	public static WebElement alertInvalidEmail()
	{
		element = driver.Instance.findElement(constants.alertInvalidEmail);
		return element;
	}

	/*
	 * @return sweet alert for wrong credentials
	 */
	public static WebElement alertWrongCredentials()
	{
		element = driver.Instance.findElement(constants.alertWrongCredentials);
		return element;
	}

}
