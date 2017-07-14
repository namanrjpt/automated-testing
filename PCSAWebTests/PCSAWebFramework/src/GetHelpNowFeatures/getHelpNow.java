/*
 * @author Anjali
 * @since 2016-06-22
 * This class maintains validation steps carried out for Get Help Now Feature.
 */
package GetHelpNowFeatures;

import java.util.ArrayList;
import java.util.List;

import Logs.log4j;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import LoginAndRegistration.existingUserLogin;
import PageObjectModel.constants;
import PageObjectModel.getHelpNowPageElements;
import PageObjectModel.sideInMenuBarElements;
import WebDriver.driver;

public class getHelpNow 
{
	private static String URL;
	public static void gotoGetHelp()
	{
		existingUserLogin.login();
		WebElement getHelpTab = sideInMenuBarElements.getHelpNowTab();
		getHelpTab.click();
	}
	
	/*
	 * This function navigates to the second page of Get Help Now
	 */
	public static void gotoHelp2()
	{
		gotoGetHelp();
		WebElement getHelpNow2Button = getHelpNowPageElements.toGetHelpPage2();
		getHelpNow2Button.click();
		System.out.println(driver.Instance.getCurrentUrl());
	}
	
	/*
	 * Common function for switching to an alert on voice call and send sms available in Get Help Now.
	 * @return alert text for alerts that appear on making a call and sending message.
	 */
	public static String goToAlert()
	{
		Alert simpleAlert = driver.Instance.switchTo().alert();
		String alertText = simpleAlert.getText();
		simpleAlert.accept();
		return alertText;
	}

	/*
	 * Checks if the user is at Page 1 of Get Help Now
	 */
	public static boolean isAtGetHelpNow() 
	{
		URL = driver.Instance.getCurrentUrl();
		log4j.Log.info("url is "+URL);
		if(getHelpNowPageElements.gethelpPageTitle().getText().contains("Get Help Now") && driver.Instance.getCurrentUrl().contains("get-help-now"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*
	 * Checks if the user is at Page 2 of Get Help Now
	 */
	public static boolean isAtGetHelpNow2() 
	{
		URL = driver.Instance.getCurrentUrl();
		WebElement gethelpPageTitle = getHelpNowPageElements.gethelpPageTitle();
		if(URL.contains(constants.baseURL+"getHelpNow2.php")&& gethelpPageTitle.getText().contains(constants.getHelpTitle))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/*
	 * Function for making a voice call.
	 */
	public static void makeVoiceCall(WebElement callButton)
	{
		callButton.click();
	}
	
	/*
	 * Function for sending text message
	 */
	public static void sendSMS(WebElement SmsTextBox, WebElement SMSButton, String message)
	{
		SmsTextBox.sendKeys(message);
		SMSButton.click();
	}
	
	/*
	 * Checks if the user is able to select the country from the dropdown
	 */
	public static boolean canSelectCountry() 
	{
		WebElement changeLocationDropdown = getHelpNowPageElements.changeLocationDropdown();
		WebElement chooseLocationText = getHelpNowPageElements.chooseLocationText();
		String countryArr[] = {"Syria","Uganda","Tunisia"};
		Select country = new Select(changeLocationDropdown);
		//get all the option from the dropdown
		List<WebElement> optionCount = country.getOptions();
		String s="";
		
		if(isAtGetHelpNow())
		{
			//iterate through all the option
			for(int i= 0;i<optionCount.size();i++)
			{
				country.selectByIndex(i);
				s = optionCount.get(i).getText();
				if(!(s.equals(countryArr[i]))||!(chooseLocationText.getText().contains(optionCount.get(i).getText())))
				{
					System.out.println("inside");
					return false;
				}
				System.out.println(s);
				System.out.println(chooseLocationText.getText());
			}
			
			return true;
		}
		
		return false;
		
	}

	/*
	 * @return true if voice call is successful otherwise false
	 */
	public static boolean canCallPCMO()
	{
		if(isAtGetHelpNow())
		{
			WebElement contactPCMO = getHelpNowPageElements.contactPCMO();
			contactPCMO.click();
			WebElement pcmoCallButton = getHelpNowPageElements.pcmoCallButton();
			makeVoiceCall(pcmoCallButton);
			
			
			/*Alert simpleAlert = driver.Instance.switchTo().alert();
			String alertText = simpleAlert.getText();
			simpleAlert.accept();*/
			
			
			try
			{
				//Switch for alert pop up for Voice Call 
				String alertText = goToAlert();
				if(alertText.contains("Call started")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioCall.php?phone="))
				{
					return true;
				}
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
			
		}
			return false;
	}

	/*
	 * @return true if message is sent successfully otherwise false
	 */
	public static boolean canMessagePCMO(String msg)
	{
		if(isAtGetHelpNow())
		{
			WebElement contactPCMO = getHelpNowPageElements.contactPCMO();
			contactPCMO.click();
			WebElement pcmoSMSButton = getHelpNowPageElements.pcmoSMSButton();
			pcmoSMSButton.click();
			WebElement smsBodyTextBox = getHelpNowPageElements.smsBodyTextBox();
			WebElement sendSMSButton = getHelpNowPageElements.sendSMSButton();
			sendSMS(smsBodyTextBox, sendSMSButton, msg);

			/*Alert simpleAlert = driver.Instance.switchTo().alert();
			String alertText = simpleAlert.getText();
			simpleAlert.accept();*/
			try
			{
				//Go to Alert 
				String alertText = goToAlert();
				if(alertText.contains("SMS Sent Successfully")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioSMS.php?phone="))
				{
					return true;
				}
				
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
		}
		return false;
	}

	/*
	 * @return true if voice call is successful otherwise false
	 */
	public static boolean canCallSSM()
	{
		if(isAtGetHelpNow())
		{
			WebElement contactSSM = getHelpNowPageElements.contactSSM();
			contactSSM.click();
			WebElement ssmCallButton = getHelpNowPageElements.ssmCallButton();
			makeVoiceCall(ssmCallButton);
			
			
			/*Alert simpleAlert = driver.Instance.switchTo().alert();
			String alertText = simpleAlert.getText();
			simpleAlert.accept();*/
			try
			{
				//Switch for alert pop up for Voice Call 
				String alertText = goToAlert();
				if(alertText.contains("Call started")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioCall.php?phone="))
				{
					return true;
				}
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
			
		}
			return false;
	}

	/*
	 * @return true if voice call is successful otherwise false
	 */
	public static boolean canCallSarl()
	{
		if(isAtGetHelpNow())
		{
			WebElement contactSARL = getHelpNowPageElements.contactSARL();
			contactSARL.click();
			WebElement sarlCallButton = getHelpNowPageElements.sarlCallButton();
			makeVoiceCall(sarlCallButton);
			
			/*Alert simpleAlert = driver.Instance.switchTo().alert();
			String alertText = simpleAlert.getText();
			simpleAlert.accept();*/
			try
			{
				//Switch for alert pop up for Voice Call 
				String alertText = goToAlert();
				if(alertText.contains("Call started")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioCall.php?phone="))
				{
					return true;
				}
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
			
		}
			return false;
	}

	/*
	 * @return true if message is sent successfully otherwise false
	 */
	public static boolean canMessageSARL(String msg) 
	{
		if(isAtGetHelpNow())
		{
			WebElement contactSARL = getHelpNowPageElements.contactSARL();
			contactSARL.click();
			WebElement sarlSMSButton = getHelpNowPageElements.sarlSMSButton();
			sarlSMSButton.click();
			WebElement smsBodyTextBox = getHelpNowPageElements.smsBodyTextBox();
			WebElement sendSMSButton = getHelpNowPageElements.sendSMSButton();
			
			sendSMS(smsBodyTextBox, sendSMSButton, msg);
			
			/*Alert simpleAlert = driver.Instance.switchTo().alert();
			String alertText = simpleAlert.getText();
			simpleAlert.accept();*/
			try
			{
				//Go to Alert 
				String alertText = goToAlert();
				if(alertText.contains("SMS Sent Successfully")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioSMS.php?phone="))
				{
					return true;
				}
				
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
		}
		return false;
	}

	/*
	 * @return true if message is sent successfully otherwise false
	 */
	public static boolean canMessageSSM(String msg) 
	{
		if(isAtGetHelpNow())
		{
			WebElement contactSSM = getHelpNowPageElements.contactSSM();
			contactSSM.click();
			WebElement ssmSMSButton = getHelpNowPageElements.ssmSMSButton();
			ssmSMSButton.click();
			WebElement smsBodyTextBox = getHelpNowPageElements.smsBodyTextBox();
			WebElement sendSMSButton = getHelpNowPageElements.sendSMSButton();
			sendSMS(smsBodyTextBox, sendSMSButton, msg);
			
			/*Alert simpleAlert = driver.Instance.switchTo().alert();
			String alertText = simpleAlert.getText();
			simpleAlert.accept();*/
			try
			{
				//Go to Alert 
				String alertText = goToAlert();
				if(alertText.contains("SMS Sent Successfully")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioSMS.php?phone="))
				{
					return true;
				}
				
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
		}
		return false;
	}

	/*
	 * @return true if voice call is successful otherwise false
	 */
	public static boolean canVoiceCallPC() 
	{
		if(isAtGetHelpNow2())
		{
			WebElement PCHelpline, contactNow, voiceCall;
		    PCHelpline = getHelpNowPageElements.PCHelpline();
			PCHelpline.click();
			contactNow = getHelpNowPageElements.contactNowPCHelpline();
			contactNow.click();
			voiceCall = getHelpNowPageElements.voiceCallButton();
			makeVoiceCall(voiceCall);
			
			try
			{
				//Go to Alert 
				String alertText = goToAlert();
				if(alertText.contains("Call started")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioCall.php?phone="))
				{
					return true;
				}
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
		}
		return false;
	}

	/*
	 * @return true if message is sent successfully otherwise false
	 */
	public static boolean canMessagePC(String msg) 
	{
		if(isAtGetHelpNow2())
		{
			WebElement PCHelpline, contactNow, sendMessage;
		    PCHelpline = getHelpNowPageElements.PCHelpline();
			PCHelpline.click();
			contactNow = getHelpNowPageElements.contactNowPCHelpline();
			contactNow.click();
			sendMessage = getHelpNowPageElements.sendMessageButton();
			sendMessage.click();
			WebElement smsBodyTextBox = getHelpNowPageElements.smsBodyTextBox();
			WebElement sendSMSButton = getHelpNowPageElements.sendSMSButton();
			sendSMS(smsBodyTextBox, sendSMSButton, msg);
			try
			{
				//Go to Alert 
				String alertText = goToAlert();
				if(alertText.contains("SMS Sent Successfully")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioSMS.php?phone="))
				{
					return true;
				}
				
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
		}
		return false;
	}

	/*
	 * @return true if voice call is successful otherwise false
	 */
	public static boolean canVoiceOfficeofVA() 
	{
		if(isAtGetHelpNow2())
		{
			WebElement officeOfVictimAdvocacy, contactNow, voiceCall;
			officeOfVictimAdvocacy = getHelpNowPageElements.officeOfVictimAdvocacy();
			officeOfVictimAdvocacy.click();
			System.out.println("Page title"+ driver.Instance.getTitle());
			contactNow = getHelpNowPageElements.contactNowButtonOfficeOfVictimAdvocacy();
			contactNow.click();
			voiceCall = getHelpNowPageElements.voiceCallButton();
			
			makeVoiceCall(voiceCall);
			
			try
			{
				//Go to Alert 
				String alertText = goToAlert();
				if(alertText.contains("Call started")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioCall.php?phone="))
				{
					return true;
				}
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
			
		}
		return false;
	}

	/*
	 * @return true if message is sent successfully otherwise false
	 */
	public static boolean canMessageOfficeofVA(String msg) 
	{
		if(isAtGetHelpNow2())
		{
			WebElement officeOfVictimAdvocacy, contactNow, sendMessage;
			officeOfVictimAdvocacy = getHelpNowPageElements.officeOfVictimAdvocacy();
			officeOfVictimAdvocacy.click();
			contactNow = getHelpNowPageElements.contactNowButtonOfficeOfVictimAdvocacy();
			contactNow.click();
			sendMessage = getHelpNowPageElements.sendMessageButton();
			sendMessage.click();
			WebElement smsBodyTextBox = getHelpNowPageElements.smsBodyTextBox();
			WebElement sendSMSButton = getHelpNowPageElements.sendSMSButton();
			sendSMS(smsBodyTextBox, sendSMSButton, msg);
			
			try
			{
				//Go to Alert 
				String alertText = goToAlert();
				if(alertText.contains("SMS Sent Successfully")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioSMS.php?phone="))
				{
					return true;
				}
				
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
		}
		return false;
	}

	/*
	 * @return true if voice call is successful otherwise false
	 */
	public static boolean canVoiceOfficeofIG()
	{

		if(isAtGetHelpNow2())
		{
			WebElement officeOfInspectorGeneral, contactNow, voiceCall;
			officeOfInspectorGeneral = getHelpNowPageElements.officeOfInspectorGeneral();
			officeOfInspectorGeneral.click();
			
			contactNow = getHelpNowPageElements.contactNowButtonOfficeOfInspectorGeneral();
			contactNow.click();
			voiceCall = getHelpNowPageElements.voiceCallButton();
			
			makeVoiceCall(voiceCall);
			try
			{
				//Go to Alert 
				String alertText = goToAlert();
				if(alertText.contains("Call started")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioCall.php?phone="))
				{
					return true;
				}
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
			
		}
		return false;
	}

	/*
	 * @return true if message is sent successfully otherwise false
	 */
	public static boolean canMessageOfficeofIG(String msg) 
	{
		if(isAtGetHelpNow2())
		{
			WebElement officeOfInspectorGeneral, contactNow, sendMessage;
			officeOfInspectorGeneral = getHelpNowPageElements.officeOfInspectorGeneral();
			officeOfInspectorGeneral.click();
			contactNow = getHelpNowPageElements.contactNowButtonOfficeOfInspectorGeneral();
			contactNow.click();
			sendMessage = getHelpNowPageElements.sendMessageButton();
			sendMessage.click();
			WebElement smsBodyTextBox = getHelpNowPageElements.smsBodyTextBox();
			WebElement sendSMSButton = getHelpNowPageElements.sendSMSButton();
			sendSMS(smsBodyTextBox, sendSMSButton, msg);
			
			try
			{
				//Go to Alert 
				String alertText = goToAlert();
				if(alertText.contains("SMS Sent Successfully")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioSMS.php?phone="))
				{
					return true;
				}
				
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}

		}
		return false;
	}

	/*
	 * @return true if voice call is successful otherwise false
	 */
	public static boolean canVoiceOfficeofCivilRights() 
	{
		if(isAtGetHelpNow2())
		{
			WebElement officeOfCivilRightsAndDiversity, contactNow, voiceCall;
			officeOfCivilRightsAndDiversity = getHelpNowPageElements.officeOfCivilRightsAndDiversity();
			officeOfCivilRightsAndDiversity.click();
			
			contactNow = getHelpNowPageElements.contactNowButtonoOfficeOfCivilRightsAndDiversity();
			contactNow.click();
			voiceCall = getHelpNowPageElements.voiceCallButton();
			
			makeVoiceCall(voiceCall);
			try
			{
				//Got to Alert 
				String alertText = goToAlert();
				if(alertText.contains("Call started")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioCall.php?phone="))
				{
					return true;
				}
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}
			
		}
		return false;
	}

	/*
	 * @return true if message is sent successfully otherwise false
	 */
	public static boolean canMessageOfficeofCivilRights(String msg) 
	{
		if(isAtGetHelpNow2())
		{
			WebElement officeOfCivilRightsAndDiversity, contactNow, sendMessage;
			officeOfCivilRightsAndDiversity = getHelpNowPageElements.officeOfCivilRightsAndDiversity();
			officeOfCivilRightsAndDiversity.click();
			contactNow = getHelpNowPageElements.contactNowButtonoOfficeOfCivilRightsAndDiversity();
			contactNow.click();
			sendMessage = getHelpNowPageElements.sendMessageButton();
			sendMessage.click();
			WebElement smsBodyTextBox = getHelpNowPageElements.smsBodyTextBox();
			WebElement sendSMSButton = getHelpNowPageElements.sendSMSButton();
			sendSMS(smsBodyTextBox, sendSMSButton, msg);
			
			try
			{
				//Go to Alert 
				String alertText = goToAlert();
				if(alertText.contains("SMS Sent Successfully")&&driver.Instance.getCurrentUrl().contains(constants.baseURL+"twilioSMS.php?phone="))
				{
					return true;
				}
				
			}
			//if alert does not appear, case of test failure
			catch(NoAlertPresentException Ex)
			{
				return false;
			}

		}
		return false;
	}

	/*
	 * @return true if navigation is successful on clicking "Learn more" from PC Saves otherwise false
	 */
	public static boolean canGotoLearnMorePCSaves()
	{
		if(isAtGetHelpNow2())
		{
			WebElement PCHelpline, pcSavesLearnMoreLink;
		    PCHelpline = getHelpNowPageElements.PCHelpline();
			PCHelpline.click();
			pcSavesLearnMoreLink = getHelpNowPageElements.pcSavesLearnMoreLink();
			pcSavesLearnMoreLink.click();
			
			//for getting no of open tabs
			ArrayList<String> tabs = new ArrayList<String> (driver.Instance.getWindowHandles());
			 
			//Switch to Peace corps HELPLINE tab
			driver.Instance.switchTo().window(tabs.get(1));
			String URL = driver.Instance.getCurrentUrl();
			String pageTitle = driver.Instance.getTitle();
			System.out.println("Title is "+driver.Instance.getTitle());
			//close the second tab
			driver.Instance.close();
			 
			//Switch to the main tab
			driver.Instance.switchTo().window(tabs.get(0));
			//Validate
			if(URL.contains("https://pcsaveshelpline.org/")&& pageTitle.contains("Peace Corps"))
			{
				return true;
			}
			else
				return false;
			
		}
		return false;
	}

	/*
	 * @return true if navigation is successful on clicking "Learn more" from Office of Inspector General false
	 */
	public static Object canGotoLearnMoreOfficeOfIG() 
	{
		if(isAtGetHelpNow2())
		{
			WebElement officeOfInspectorGeneral, officeOfInspectorGeneralLearnMoreLink;
			officeOfInspectorGeneral = getHelpNowPageElements.officeOfInspectorGeneral();
			officeOfInspectorGeneral.click();
			officeOfInspectorGeneralLearnMoreLink = getHelpNowPageElements.pcSavesLearnMoreLink();
			officeOfInspectorGeneralLearnMoreLink.click();
			
			//for getting no of open tabs
			ArrayList<String> tabs = new ArrayList<String> (driver.Instance.getWindowHandles());
			 
			//Switch to Office of Inspector General tab
			driver.Instance.switchTo().window(tabs.get(1));
			String URL = driver.Instance.getCurrentUrl();
			String pageTitle = driver.Instance.getTitle();
			System.out.println("Title is "+driver.Instance.getTitle());
			System.out.println("URL is "+URL);
			//close the second tab
			driver.Instance.close();
			 
			//Switch to the main tab
			driver.Instance.switchTo().window(tabs.get(0));
			//Validate
			if(URL.contains("https://www.peacecorps.gov/about/inspector-general/")&& pageTitle.contains("Office of Inspector General"))
			{
				return true;
			}
			else
				return false;
			
		}
		return false;
	}
}
