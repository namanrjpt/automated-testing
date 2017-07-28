/*
 * @author Anjali
 * @since 2016-07-24
 * This class maintains validation steps carried out for Circle of Trust Feature.
 */
package CircleOfTrustFeatures;

import Logs.log4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import LoginAndRegistration.existingUserLogin;
import PageObjectModel.circleOfTrustPageElements;
import PageObjectModel.constants;
import PageObjectModel.sideInMenuBarElements;
import WebDriver.driver;

import javax.naming.StringRefAddr;
import java.io.IOException;

public class circleOfTrust 
{

	/*
	 * This method navigates to Circle of Trust
	 */
	public static void gotoCOT() 
	{
		existingUserLogin.login();
		WebElement circleOfTrustTab = sideInMenuBarElements.circleOfTrustTab();
		circleOfTrustTab.click();
	}

	/*
	 * @return true if the user is at Circle of Trust
	 */
	private static boolean isAtCircleOfTrust()
	{
		//Page title of "Circle of Trust"
		WebElement pageTitle = circleOfTrustPageElements.circleOfTrustTitle();
		
		//Validate if at "Circle of Trust"
		if(driver.Instance.getCurrentUrl().contains("circle-of-trust"))
		{
			return true;
		}
		return false;
	}
	
	/*
	 * return true if the user is on Edit Comrade page.
	 */
	public static boolean isAtEditComrade() 
	{
		if(isAtCircleOfTrust())
		{
			WebElement circleOfTrustEditButton = circleOfTrustPageElements.circleOfTrustEditButton();
			circleOfTrustEditButton.click();
			if(driver.Instance.getCurrentUrl().contains(constants.baseURL+"editComrades.php"))
			{
				return true;
			}
			
			else
			{
				return false;
			}
		}
		return false;
	}

	/*
	 * @return true if the first message is sent successfully
	 */
	public static boolean canSendMsg1() 
	{
		if(isAtCircleOfTrust())
		{
			WebElement circleOfTrusHelpMeButton = circleOfTrustPageElements.circleOfTrustHelpMeButton();
			circleOfTrusHelpMeButton.click();
			WebElement msg1_Button = circleOfTrustPageElements.msg1_Button();
			msg1_Button.click();
			
			//handling sweet alert for message 1
			try
			{
				WebElement okButton = driver.Instance.findElement(constants.alertButton);
				okButton.click();
				System.out.println("inside try1");
				return true;
			}
			catch(NoSuchElementException e)
			{
				return false;
			}
		}
		return false;
	}

	/*
	 * @return true if the second message is sent successfully
	 */
	public static boolean canSendMsg2() 
	{
		if(isAtCircleOfTrust())
		{
			WebElement circleOfTrusHelpMeButton = circleOfTrustPageElements.circleOfTrustHelpMeButton();
			circleOfTrusHelpMeButton.click();
			WebElement msg2_Button = circleOfTrustPageElements.msg2_Button();
			msg2_Button.click();
			
			//handling sweet alert for message 2
			try
			{
				WebElement okButton = driver.Instance.findElement(constants.alertButton);
				okButton.click();
				System.out.println("inside try2");
				return true;
			}
			catch(NoSuchElementException e)
			{
				return false;
			}
		}
		return false;
	}

	/*
	 * @return true if the third message is sent successfully
	 */
	public static boolean canSendMsg3() 
	{
		if(isAtCircleOfTrust())
		{
			WebElement circleOfTrusHelpMeButton = circleOfTrustPageElements.circleOfTrustHelpMeButton();
			circleOfTrusHelpMeButton.click();
			WebElement msg3_Button = circleOfTrustPageElements.msg3_Button();
			msg3_Button.click();
			
			//handling sweet alert for message 3
			try
			{
				WebElement okButton = driver.Instance.findElement(constants.alertButton);
				okButton.click();
				System.out.println("inside try3");
				return true;
			}
			catch(NoSuchElementException e)
			{
				return false;
			}
		}
		return false;
	}

	public static boolean canEditComradesNumbers(String exampleNumber){
		WebElement circleOfTrustTab = sideInMenuBarElements.circleOfTrustTab();
		try{
			driver.waitDriverForElement(circleOfTrustTab);
		}
		catch(IOException e){
			log4j.Log.info(e);
		}
		circleOfTrustTab.click();

		try{
			driver.waitDriverForElement(circleOfTrustPageElements.circleOfTrustEditButton());
		}
		catch(IOException e){
			log4j.Log.info(e);
		}

		circleOfTrustPageElements.circleOfTrustEditButton().click();

		try{
			driver.waitDriverForElement(circleOfTrustPageElements.comrade1_TextBox());
		}
		catch(IOException e){
			log4j.Log.info(e);
		}

		circleOfTrustPageElements.comrade1_TextBox().clear();
		circleOfTrustPageElements.comrade1_TextBox().sendKeys(exampleNumber);
		circleOfTrustPageElements.circleOfTrustSaveComradeButton().click();

		circleOfTrustPageElements.backButtonOnEditComradePage().click();

		try{
			driver.waitDriverForElement(circleOfTrustPageElements.circleOfTrustEditButton());
		}
		catch(IOException e){
			log4j.Log.info(e);
		}

		circleOfTrustPageElements.circleOfTrustEditButton().click();
		try{
			driver.waitDriverForElement(circleOfTrustPageElements.comrade1_TextBox());
		}
		catch(IOException e){
			log4j.Log.info(e);
		}

		String sd = circleOfTrustPageElements.comrade1_TextBox().getAttribute("value");

		if(sd.equals(exampleNumber)){
			return true;
		}
		else{
			return false;
		}
	}

	public static Object canAddComradesNumbers(String[] phNumbers) 
	{
		if(isAtEditComrade())
		{
			WebElement comrade1_TextBox, comrade2_TextBox, comrade3_TextBox, comrade4_TextBox, comrade5_TextBox, comrade6_TextBox;
			comrade1_TextBox = circleOfTrustPageElements.comrade1_TextBox();
			comrade2_TextBox = circleOfTrustPageElements.comrade2_TextBox();
			comrade3_TextBox = circleOfTrustPageElements.comrade3_TextBox();
			comrade4_TextBox = circleOfTrustPageElements.comrade4_TextBox();
			comrade5_TextBox = circleOfTrustPageElements.comrade5_TextBox();
			comrade6_TextBox = circleOfTrustPageElements.comrade6_TextBox();
			
			//check if number already exists and is not the same number which already exists
			if(comrade1_TextBox.getText() != "" && !(phNumbers[0].equals(comrade1_TextBox.getText())))
			{
				comrade1_TextBox.sendKeys(phNumbers[0]);
			}
			
			//check if number already exists and is not the same number which already exists
			if(comrade2_TextBox.getText() != "" && !(phNumbers[0].equals(comrade2_TextBox.getText())))
			{
				comrade2_TextBox.sendKeys(phNumbers[1]);
			}
			
			//check if number already exists and is not the same number which already exists
			if(comrade3_TextBox.getText() != "" && !(phNumbers[0].equals(comrade3_TextBox.getText())))
			{
				comrade3_TextBox.sendKeys(phNumbers[2]);
			}
			
			//check if number already exists and is not the same number which already exists
			if(comrade4_TextBox.getText() != "" && !(phNumbers[0].equals(comrade4_TextBox.getText())))
			{
				comrade4_TextBox.sendKeys(phNumbers[3]);
			}
			
			//check if number already exists and is not the same number which already exists
			if(comrade5_TextBox.getText() != "" && !(phNumbers[0].equals(comrade5_TextBox.getText())))
			{
				comrade5_TextBox.sendKeys(phNumbers[4]);
			}
			
			//check if number already exists and is not the same number which already exists
			if(comrade6_TextBox.getText() != "" && !(phNumbers[0].equals(comrade6_TextBox.getText())))
			{
				comrade6_TextBox.sendKeys(phNumbers[5]);
			}
			
			WebElement circleOfTrusSaveComradeButton = circleOfTrustPageElements.circleOfTrustSaveComradeButton();
			circleOfTrusSaveComradeButton.click();
			
			try
			{
				WebElement okButton = driver.Instance.findElement(constants.alertButton);
				okButton.click();
				System.out.println("inside save comrade");
				return true;
			}
		    catch(NoSuchElementException e)
			{
		    	return false;
			}
			
		}
		return false;
	}
}
