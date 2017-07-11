/*
 * @author Anjali
 * @since 2016-06-11
 * This class checks if a user is at the welcome page after successful login.
 */
package LoginAndRegistration;

import java.util.concurrent.TimeUnit;

import PageObjectModel.logoutPageElements;
import org.openqa.selenium.WebElement;

import Logs.log4j;
import PageObjectModel.constants;
import WebDriver.driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class loggedInCheck {
	/*
     * @return boolean value for validation(pass or fail)
     */
	public static boolean hasLogeedIn() {
		/*
		* Code for Login check will go here.
		* */
		(new WebDriverWait(driver.Instance, 10)).until(ExpectedConditions.visibilityOf(logoutPageElements.logoutButton()));
		if(logoutPageElements.logoutButton().isDisplayed() && driver.Instance.findElement(constants.leftSidebarMenu).isDisplayed()){
			return true;
		}
		else{
			return false;
		}
	}
}