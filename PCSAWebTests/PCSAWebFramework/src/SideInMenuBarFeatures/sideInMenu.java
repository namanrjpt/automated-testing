/*
 * @author Anjali
 * @since 2016-06-26
 * This class validates test steps for Side in Menu Bar.
 */
package SideInMenuBarFeatures;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import PageObjectModel.constants;
import PageObjectModel.logoutPageElements;
import PageObjectModel.policiesAndGlossaryElements;
import PageObjectModel.safetyToolsElements;
import PageObjectModel.sexualAssaultAwarenessElements;
import PageObjectModel.sideInMenuBarElements;
import PageObjectModel.supportServicesElements;
import WebDriver.driver;

public class sideInMenu 
{
	private static String pageTitle;
	/*
	 * Takes to the Welcome Page.
	 */
	public static void gotoWelcomePage()
	{
		log4j.Log.info("Navigating to Welcome page");
		existingUserLogin.login();
	}
	
	/*
	 * @return true if the user is at the Welcome Page after login else false
	 */
	public static boolean isAtWelcome()
	{
		if(driver.Instance.getCurrentUrl().contains(constants.baseURL+"welcome.php"))
		{
			System.out.println("inside check");
			return true;
		}
		
		return false;
	}

	/*
	 * @return true if the user is able to successfully navigate after clicking on "FirstAide" on the side in menu 
	 */
	public static boolean canNavigateToFirstAide() 
	{
		if(isAtWelcome())
		{
			WebElement firstAideTab = sideInMenuBarElements.firstAideTab();
			WebElement title = driver.Instance.findElement(constants.welcomeTtile);
			pageTitle = title.getText();
			firstAideTab.click();
			if(pageTitle.contains(constants.pageTitleWelcome)&& driver.Instance.getCurrentUrl().contains(constants.baseURL+"welcome.php"))
			{
				return true;
			}
		}
		return false;
	}

	/*
	 * @return true if the user is able to successfully navigate after clicking on "Circle of Trust" on the side in menu 
	 */
	public static boolean canNavigateToCircleOfTrust() 
	{
		WebElement circleOfTrustTab = sideInMenuBarElements.circleOfTrustTab();
		circleOfTrustTab.click();
		WebElement circleOfTrustTitle = driver.Instance.findElement(constants.circleOfTrustTitle);
		if(circleOfTrustTitle.getText().contains("Circle of Trust") && driver.Instance.getCurrentUrl().contains("circle-of-trust"))
		{
			return true;
		}
		
		else
			return false;
	}

	/*
	 * @return true if the user is able to successfully navigate after clicking on "Safety Tools" on the side in menu 
	 */
	public static void gotoSafetyToolsOptions() 
	{
		
			WebElement safetyToolsTab = sideInMenuBarElements.safetyToolsTab();
			safetyToolsTab.click();
		
	
	}

	/*
	 * @return true if the user is able to successfully navigate after clicking on "Support Services" on the side in menu 
	 */
	public static boolean canNavigateToSupportServices() 
	{
		WebElement supportServicesTab = sideInMenuBarElements.supportServicesTab();
		supportServicesTab.click();
		
		if(isAtWelcome())
		{
			//checks if the support services menu become visible after clicking on "Support Services"
			 try 
			 {
			        WebElement supportServicesMainTab = supportServicesElements.supportServicesMainTab();
			        System.out.println("Element Present");
			    
			 } 
			 catch (NoSuchElementException e) 
			 {
			        return false;
			 }
			    return true;
		}
		
		else
		{
			return false;
		}
	
	}

	/*
	 * @return true if the user is able to successfully navigate after clicking on "Sexual Assault Awareness" on the side in menu 
	 */
	public static boolean canNavigateToSexualAssualtAwareness() 
	{
		WebElement sexualAssaultAwarenesstTab = sideInMenuBarElements.sexualAssaultAwarenesstTab();
		sexualAssaultAwarenesstTab.click();
		
		if(isAtWelcome())
		{
			//checks if the sexual assault awareness menu become visible after clicking on "Sexual Assault Awareness"
			 try 
			 {
			        WebElement sexualAssaultMainTab = sexualAssaultAwarenessElements.sexualAssaultMainTab();
			        System.out.println("Element Present");
			    
			 } 
			 catch (NoSuchElementException e) 
			 {
			        return false;
			 }
			    return true;
		}
		
		else
		{
			return false;
		}
	}

	/*
	 * @return true if the user is able to successfully navigate after clicking on "Policies and Glossary" on the side in menu 
	 */
	public static boolean canNavigateToPoliciesAndGlossary()
	{
		WebElement policiesAndGlossaryTab = sideInMenuBarElements.policiesAndGlossaryTab();
		policiesAndGlossaryTab.click();
		
		if(isAtWelcome())
		{
			//checks if the policies and glossary menu become visible after clicking on "Policies and Glossary"
			 try 
			 {
			        WebElement policySummarySheetTab = policiesAndGlossaryElements.policySummarySheetTab();
			        System.out.println("Element Present");
			    
			 } 
			 catch (NoSuchElementException e) 
			 {
			        return false;
			 }
			    return true;
		}
		
		else
		{
			return false;
		}
	}

	public static boolean canNavigateToSafetyToolsMain() 
	{
		WebElement safetyToolsTab = sideInMenuBarElements.safetyToolsTab();
		safetyToolsTab.click();
		WebElement safetyToolsMainTab = safetyToolsElements.safetyToolsMainTab();
		safetyToolsMainTab.click();
		
		if(driver.Instance.getCurrentUrl().contains(constants.baseURL+"safetyTools1.php") && safetyToolsElements.safetyToolsPageTitle().getText().contains("Safety Tools"))
		{
			return true;
		}
		
		return false;
	}

	public static boolean canNavigateToPersonalSecurityStrategies()
	{
		WebElement safetyToolsTab = sideInMenuBarElements.safetyToolsTab();
		safetyToolsTab.click();
		
		WebDriverWait wait = new WebDriverWait(driver.Instance, 5);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(safetyToolsElements.personalSecurityStrategiesTab()));
		WebElement personalSecurityStrategiesTab = safetyToolsElements.personalSecurityStrategiesTab();
		personalSecurityStrategiesTab.click();
		
		if(driver.Instance.getCurrentUrl().contains(constants.baseURL+"personalSecurityStrategies.php") && safetyToolsElements.personalSecurityStrategiesTitle().getText().contains("Personal Security Strategies"))
		{
			return true;
		}
		
		return false;
	}

	public static boolean canNavigateToRADAR() 
	{
		WebElement safetyToolsTab = sideInMenuBarElements.safetyToolsTab();
		safetyToolsTab.click();
		WebDriverWait wait = new WebDriverWait(driver.Instance, 5);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(safetyToolsElements.radarTab()));
		WebElement radarTab = safetyToolsElements.radarTab();
		radarTab.click();
		
		if(driver.Instance.getCurrentUrl().contains(constants.baseURL+"radar.php") && safetyToolsElements.radarTitle().getText().contains("RADAR"))
		{
			return true;
		}
		
		return false;
	}

	public static boolean canNavigateToCopingwithUnwantedAttention() 
	{
		WebElement safetyToolsTab = sideInMenuBarElements.safetyToolsTab();
		safetyToolsTab.click();
		WebDriverWait wait = new WebDriverWait(driver.Instance, 5);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(safetyToolsElements.copingwithUnwantedAttentionTab()));
		WebElement copingwithUnwantedAttentionTab = safetyToolsElements.copingwithUnwantedAttentionTab();
		copingwithUnwantedAttentionTab.click();
		
		if(driver.Instance.getCurrentUrl().contains(constants.baseURL+"copingWithUnwantedAttentionStrategies.php") && safetyToolsElements.copingwithUnwantedAttentionTitle().getText().contains("Coping With Unwanted Attention Strategies"))
		{
			return true;
		}
		
		return false;
	}

	public static boolean canNavigateToCommonalitiesofSexualPredators() 
	{
		WebElement safetyToolsTab = sideInMenuBarElements.safetyToolsTab();
		safetyToolsTab.click();
		
		WebDriverWait wait = new WebDriverWait(driver.Instance, 5);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(safetyToolsElements.commonalitiesofSexualPredatorsTab()));
		WebElement commonalitiesofSexualPredatorsTab = safetyToolsElements.commonalitiesofSexualPredatorsTab();
		commonalitiesofSexualPredatorsTab.click();
		
		if(driver.Instance.getCurrentUrl().contains(constants.baseURL+"commonalitiesOfSexualPredators.php") && safetyToolsElements.commonalitiesofSexualPredatorsTitle().getText().contains("Commonalities Of Sexual Predators"))
		{
			return true;
		}
		
		return false;
	}

	public static boolean canNavigateToBystanderIntervention() 
	{
		WebElement safetyToolsTab = sideInMenuBarElements.safetyToolsTab();
		safetyToolsTab.click();
		
		WebDriverWait wait = new WebDriverWait(driver.Instance, 5);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(safetyToolsElements.bystanderInterventionTab()));
		WebElement bystanderInterventionTab = safetyToolsElements.bystanderInterventionTab();
		bystanderInterventionTab.click();
		
		if(driver.Instance.getCurrentUrl().contains(constants.baseURL+"bystanderIntervention.php") && safetyToolsElements.bystanderInterventionTitle().getText().contains("Bystander Intervention"))
		{
			return true;
		}
		
		return false;
	}

	public static boolean canNavigateToSafetyPlanBasics()
	{
		WebElement safetyToolsTab = sideInMenuBarElements.safetyToolsTab();
		safetyToolsTab.click();
		WebDriverWait wait = new WebDriverWait(driver.Instance, 5);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(safetyToolsElements.safetyPlanBasicsTab()));
		WebElement safetyPlanBasicsTab = safetyToolsElements.safetyPlanBasicsTab();
		safetyPlanBasicsTab.click();
		
		if(driver.Instance.getCurrentUrl().contains(constants.baseURL+"safetyPlanBasics.php") && safetyToolsElements.safetyPlanBasicsTitle().getText().contains("Safety Plan Basics"))
		{
			return true;
		}
		
		return false;
	}
}
