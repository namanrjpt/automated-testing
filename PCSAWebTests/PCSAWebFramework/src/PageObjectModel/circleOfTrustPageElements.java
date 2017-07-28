/*
 * @author Anjali
 * @since 2016-07-22
 * This class maintains page elements for the Circle of Trust Features.
 */
package PageObjectModel;
import org.openqa.selenium.WebElement;
import WebDriver.driver;

public class circleOfTrustPageElements 
{

	public static WebElement element = null;

	
	/*
	 * @return Page Title of Circle of Trust main page.
	 */
	public static WebElement circleOfTrustTitle() 
	{
		element = driver.Instance.findElement(constants.circleOfTrustTitle);
		return element;
	}
	
	/*
	 * @return 'Edit' Button on the Circle of Trust main page.
	 */
	public static WebElement circleOfTrustEditButton() 
	{
		element = driver.Instance.findElement(constants.circleOfTrustEditButton);
		return element;
	}
	
	/*
	 * @return 'Help Me' Button on the Circle of Trust main page.
	 */
	public static WebElement circleOfTrustHelpMeButton()
	{
		element = driver.Instance.findElement(constants.circleOfTrustHelpMeButton);
		return element;
	}
	
	/*
	 * @return 'Come Get me' Button on the message dialogue that appears after clicking on Help Me.
	 */
	public static WebElement msg1_Button() 
	{
		element = driver.Instance.findElement(constants.msg1_Button);
		return element;
	}
	
	/*
	 * @return 'Call I need an interruption' Button on the message dialogue that appears after clicking on Help Me.
	 */
	public static WebElement msg2_Button() 
	{
		element = driver.Instance.findElement(constants.msg2_Button);
		return element;
	}
	
	/*
	 * @return 'I need to talk' Button on the message dialogue that appears after clicking on Help Me.
	 */
	public static WebElement msg3_Button() 
	{
		element = driver.Instance.findElement(constants.msg3_Button);
		return element;
	}
	
	/*
	 * @return Text Box for Comrade 1 on the Comrade Edit page.
	 */
	public static WebElement comrade1_TextBox() 
	{
		element = driver.Instance.findElement(constants.comrade1_TextBox);
		return element;
	}
	
	/*
	 * @return Text Box for Comrade 2 on the Comrade Edit page.
	 */
	public static WebElement comrade2_TextBox() 
	{
		element = driver.Instance.findElement(constants.comrade2_TextBox);
		return element;
	}
	
	/*
	 * @return Text Box for Comrade 3 on the Comrade Edit page.
	 */
	public static WebElement comrade3_TextBox() 
	{
		element = driver.Instance.findElement(constants.comrade3_TextBox);
		return element;
	}
	
	/*
	 * @return Text Box for Comrade 4 on the Comrade Edit page.
	 */
	public static WebElement comrade4_TextBox() 
	{
		element = driver.Instance.findElement(constants.comrade4_TextBox);
		return element;
	}
	
	/*
	 * @return Text Box for Comrade 5 on the Comrade Edit page.
	 */
	public static WebElement comrade5_TextBox() 
	{
		element = driver.Instance.findElement(constants.comrade5_TextBox);
		return element;
	}
	
	/*
	 * @return Text Box for Comrade 6 on the Comrade Edit page.
	 */
	public static WebElement comrade6_TextBox() 
	{
		element = driver.Instance.findElement(constants.comrade6_TextBox);
		return element;
	}
	
	/*
	 * @return "Save" Button on the Comrade Edit page.
	 */
	public static WebElement circleOfTrustSaveComradeButton()
	{
		element = driver.Instance.findElement(constants.circleOfTrustSaveComradeButton);
		return element;
	}

	/*
	 * @return back Button on the Comrade Edit page.
	 */
	public static WebElement backButtonOnEditComradePage()
	{
		element = driver.Instance.findElement(constants.backButtonOnEditComradePage);
		return element;
	}
	
	
}
