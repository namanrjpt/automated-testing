/*
 * @author Anjali
 * @since 2016-06-08
 * This class maintains constants like URL and WebElements.
 */
package PageObjectModel;
import org.openqa.selenium.By;

public class constants 
{
	public static String baseURL = "http://localhost/FirstAide-web/";

	/*
	* Chromedriver urls
	* */
	public static String chromeDriverURL = "https://chromedriver.storage.googleapis.com/2.30/chromedriver_linux64.zip";
	public static String chromeDriverZip = "chromedriver.zip";
	public static String chromeDriverFileName = "chromedriver";

	/*
	 * Existing User credentials for carrying out tests which requires login
	 */

	public static String existingEmailId = "test_user_one@email.com";
	public static String existingPassword = "password";

	/*
	 * Negative test params
	 */
	public static String invalidEmailFormat = "random_text_here";
	public static String emailForNegativeTesting = "wrong_user@email.com";
	public static String passwordForNegativeTesting = "randomtext";
	public static String matchingConfirmPasswordForNegativeTesting = "randomtext";
	public static String mismatchingConfirmPasswordForNegativeTesting = "notrandom text";
	public static String usernameForNegativeTesting = "username";
	public static String countryForNegativeTesting = "Afghanistan";


	/*
	 * Login page
	 */
	public static By signInEmailId = By.xpath(".//form[contains(@class, 'login-form')]//*[@id='email']");
	public static By signInPassword = By.xpath(".//form[contains(@class, 'login-form')]//*[@id='password']");
	public static By signInButton = By.xpath(".//form[contains(@class, 'login-form')]//*[contains(@class, 'submit')]");
	public static By recommendedPagesTitle = By.xpath("html/body/center/div/div/h1");
	public static By pageLoginTitle = By.xpath("html/body/form/center/div[1]/h1");
	public static By loginEmailIdRedPrompt = By.xpath(".//form[contains(@class, 'login-form')]//div[text()=\"Please enter a valid email\"]\n");
	public static By loginPasswordRedPrompt = By.xpath(".//form[contains(@class, 'login-form')]//div[text()=\"Please enter your password\"]\n");
	public static By alertInvalidEmail = By.xpath(".//div[contains(@class, 'ui modal transition visible active')]/div[./text()=\"Invalid email\"]");
	public static By alertWrongCredentials = By.xpath(".//div[contains(@class, 'ui modal transition visible active')]/div[./text()=\"Invalid credentials.\n" +
			"                                    It seems that you have not signed up on this platform.\"]");
	public static By loginInvalidAlertCloseButton = By.xpath(".//div[contains(@class, \"ui cancel green button\")]");
	public static String loginTitle = "First Aide";
	public static String loginSheet="Sheet2";

	/*
	 * Logout
	 */
	public static By logoutButton = By.xpath(".//a[contains(text(), \"Logout\")]");

	/*
	 * Welcome Page
	 */
	public static By welcomeTtile = By.xpath("html/body/center/div/div/h1");
	public static String pageTitleWelcome = "Welcome to First Aide";

	/*
	 * Registration page
	 */
	public static By gotoCreateAccountLink = By.xpath("//*[@id='sign-up-link']");
	public static By username = By.xpath(".//form[contains(@class, 'signup-form')]//*[@id='name']");
	public static By signUpPassword = By.xpath(".//form[contains(@class, 'signup-form')]//*[@id='password']");
	public static By confirmPassword = By.xpath(".//form[contains(@class, 'signup-form')]//*[@id='confirm_password']");
	public static By country = By.xpath(".//form[contains(@class, 'signup-form')]//*[contains(@class, 'search')]");
	public static By signUpEmailId = By.xpath(".//form[contains(@class, 'signup-form')]//*[@id='email']");
	public static By signUpButton = By.xpath(".//form[contains(@class, 'signup-form')]//button");
	public static By countryListDropDown = By.xpath(".//div[contains(@class, 'menu transition visible')]");

	public static By successfulRegistrationAlert = By.xpath(".//div[text()=\"Account created. Welcome aboard.\"]");
	public static By signUpEmailIdRedPrompt = By.xpath(".//form[contains(@class, 'signup-form')]//div[text()=\"Please enter a valid email\"]");
	public static By signUpNameRedPrompt = By.xpath(".//form[contains(@class, 'signup-form')]//div[text()=\"Please enter your name\"]");
	public static By signUpPasswordRedPrompt = By.xpath(".//form[contains(@class, 'signup-form')]//div[text()=\"Please enter your password\"]");
	public static By signUpConfirmPasswordRedPrompt = By.xpath(".//form[contains(@class, 'signup-form')]//div[text()=\"Password did not match\"]");
	public static By signUpCountryRedPrompt = By.xpath(".//form[contains(@class, 'signup-form')]//div[text()=\"Please select your country\"]");
	public static String registrationSheet = "Sheet3";

	/*
	 * Recommended Pages
	 */
	public static By safetyStrategyButton = By.xpath(".//*[@id='bt-safetystg']");
	public static By helpButton = By.xpath(".//*[@id='bt-helping']");
	public static By thingsToKnowButton = By.xpath(".//*[@id='bt-ghana']");
	public static By setPreferences = By.xpath(".//*[@id='bt-peerstng']");

	/*
	 * Side In Menu Bar
	 */
	public static By firstAideTab= By.xpath(".//*[@id='accordian']/ul/li[1]/h2/a");
	public static By getHelpNowTab = By.xpath(".//*[@id='accordian']/ul/li[1]/h3[1]/a");
	public static By circleOfTrustTab = By.xpath(".//*[@id='accordian']/ul/li[1]/h3[2]/a");
	public static By safetyToolsTab = By.xpath(".//div[text()=\"Safety Tools\"]");
	public static By supportServicesTab = By.xpath(".//div[text()=\"Support Services\"]");
	public static By sexualAssaultAwarenesstTab = By.xpath(".//div[text()=\"Sexual Assault Awareness\"]");
	public static By policiesAndGlossaryTab = By.xpath(".//div[text()=\"Policies and Glossary\"]");
	public static By settingsTab = By.xpath(".//*[@id='accordian']/ul/li[6]/h3[1]/a");
	public static By loggedInAsTab = By.xpath(".//*[@id='accordian']/ul/li[6]/h3[2]/a");

	/*
	 * Safety Tools
	 */
	public static By safetyToolsMainTab = By.xpath(".//*[@id='accordian']/ul/li[2]/ul/li[1]/a");
	public static By personalSecurityStrategiesButton = By.xpath(".//*[@id='bt-personalstrategies']");
	public static By radarButton = By.xpath(".//*[@id='bt-radar']");
	public static By copingwithUnwantedAttentionButton = By.xpath(".//*[@id='bt-coping']");
	public static By commonalitiesofSexualPredatorsButton = By.xpath(".//*[@id='bt-commonalities']");
	public static By bystanderInterventionButton = By.xpath(".//*[@id='bt-bystander']");
	public static By safetyPlanBasicsButton = By.xpath(".//*[@id='bt-safetyBasic']");
	public static By safetyPlanWorksheetButton = By.xpath(".//*[@id='bt-safetyWorksheet']");

	public static By safetyToolsPageTitle = By.xpath("html/body/center/div/div[1]/h1");
	public static By personalSecurityStrategiesTitle = By.xpath("html/body/center/div/div[1]/h1");

	public static By radarTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"RADAR\"]");
	public static By radarUiCards = By.xpath(".//div[contains(@class, \"multi card custom\")]");
	public static By copingWithUnwantedAttentionUiCards = By.xpath(".//div[contains(@class, \"multi card custom\")]");
	public static By copingwithUnwantedAttentionTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Coping With Unwanted Attention Strategies\"]");
	public static By commonalitiesofSexualPredatorsTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Commonalities Of Sexual Predators\"]");
	public static By commonalitiesofSexualPredatorsUiCards = By.xpath(".//div[contains(@class, \"multi card custom\")]");
	public static By bystanderInterventionTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Bystander Intervention\"]");
	public static By bystanderInterventionUiCards = By.xpath(".//div[contains(@class, \"multi card custom\")]");
	public static By safetyPlanBasicsTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Safety Plan Basics\"]");
	public static By safetyPlanBasicsUiCards = By.xpath(".//div[contains(@class, \"multi card custom\")]");
	public static By safetyPlanWorksheetTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Safety Plan Worksheet\"]");
	public static By safetyPlanWorksheetUiCards = By.xpath(".//div[contains(@class, \"ui two column center grid\")]/div[contains(@class, \"column\")]");

	public static By toSafetyToolsPage2 = By.xpath(".//*[@id='fw-arrow']/a");
	public static By toSafetyToolsPage1fromPage2 = By.xpath(".//*[@id='bw-arrow']/a");
	
	public static By personalSecurityStrategiesTab = By.xpath(".//div[text()=\"Safety Tools\"]/following-sibling::div/a[contains(text(), \"Personal Security Strategies\")]");
	public static By radarTab = By.xpath(".//div[text()=\"Safety Tools\"]/following-sibling::div/a[contains(text(), \"RADAR\")]");
	public static By copingwithUnwantedAttentionTab = By.xpath(".//div[text()=\"Safety Tools\"]/following-sibling::div/a[contains(text(), \"Coping with Unwanted Strategies\")]");
	public static By commonalitiesofSexualPredatorsTab = By.xpath(".//div[text()=\"Safety Tools\"]/following-sibling::div/a[contains(text(), \"Commonalities of Sexual Predators\")]");
	public static By bystanderInterventionTab = By.xpath(".//div[text()=\"Safety Tools\"]/following-sibling::div/a[contains(text(), \"Bystander Intervention\")]");
	public static By safetyPlanBasicsTab = By.xpath(".//div[text()=\"Safety Tools\"]/following-sibling::div/a[contains(text(), \"Safety Plan Basics\")]");
	public static By safetyPlanWorksheetTab = By.xpath(".//div[text()=\"Safety Tools\"]/following-sibling::div/a[contains(text(), \"Safety Plan Worksheet\")]");

	/*
	 * Support services
	 */
	public static By supportServicesMainTab = By.xpath(".//*[@id='accordian']/ul/li[3]/ul/li[1]/a");

		//benefits of seeking staff support
	public static By benefitsofSeekingStaffSupportTab = By.xpath(".//div[text()=\"Support Services\"]/following-sibling::div/a[contains(text(), \"Benefits of Seeking Staff Support\")]");
	public static By benefitsofSeekingStaffSupportTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Benefits of Seeking Staff Support\"]");
	public static By benefitsofSeekingStaffSupportUiCards = By.xpath(".//div[contains(@class, \"ui raised cards\")]");

		//Available services After a sex assault
	public static By availableServicesAfterASexualAssaultTab = By.xpath(".//div[text()=\"Support Services\"]/following-sibling::div/a[contains(text(), \"Available Services after a Sexual Assault\")]");
	public static By availableServicesAfterASexualAssaultTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Available Services after a Sexual Assault\"]");
	public static By availableServicesAfterASexualAssaultUiCards = By.xpath(".//div[contains(@class, \"multi card custom\")]");

		//Peace Corps Commitment to Victims of Sexual Assualt
	public static By commitmentToVictimsOfSexualAssaultTab = By.xpath(".//div[text()=\"Support Services\"]/following-sibling::div/a[contains(text(), \"Peace Corps Commitment to Victims of Sexual Assualt\")]");
	public static By commitmentToVictimsOfSexualAssaultTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Peace Corps Commitment to Victims of Sexual Assualt\"]");
	public static By commitmentToVictimsOfSexualAssaultUiCards = By.xpath(".//div[contains(@class, \"ui raised cards\")]");

	public static By whatToDoAfterAnAssaultTab = By.xpath(".//div[text()=\"Support Services\"]/following-sibling::div/a[contains(text(), \"What to do After an Assault\")]");

		//Confidentiality
	public static By confidentialityTab = By.xpath(".//div[text()=\"Support Services\"]/following-sibling::div/a[contains(text(), \"Confidentiality\")]");
	public static By confidentialityTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Confidentiality\"]");
	public static By confidentialityUiCards = By.xpath(".//div[contains(@class, \"ui raised cards\")]");

		//Peace Corps Mythbusters: Assumptions and Facts
	public static By peaceCorpsMythbustersTab = By.xpath(".//div[text()=\"Support Services\"]/following-sibling::div/a[contains(text(), \"Peace Corps Mythbusters\")]");
	public static By peaceCorpsMythbustersTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Peace Corps Mythbusters: Assumptions and Facts\"]");
	public static By peaceCorpsMythbustersUiCards = By.xpath(".//div[contains(@class, \"ui raised segment\")]");

	/*
	 * Sexual Assault Awareness
	 */
	public static By sexualAssaultMainTab = By.xpath(".//*[@id='accordian']/ul/li[4]/ul/li[1]/a");

		// Was it sexual assault
	public static By wasItSexualAssaultTab = By.xpath(".//div[text()=\"Sexual Assault Awareness\"]/following-sibling::div/a[contains(text(), \"Was it Sexual Assault\")]");
	public static By wasItSexualAssaultTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"What is Sexual Assault?\"]");
	public static By wasItSexualAssaultUiCards = By.xpath(".//div[contains(@class, \"card full-page\")]");
	public static By wasItSexualAssaultKnowMoreButton = By.xpath(".//div[contains(@class, \"massive ui button\") and contains(text(), \"Know more About Sexual Assault\")]");

		// Sexual Assault Common Questions
	public static By sexualAssaultCommonQuestionsTab = By.xpath(".//div[text()=\"Sexual Assault Awareness\"]/following-sibling::div/a[contains(text(), \"Sexual Assault Common Questions\")]");
	public static By sexualAssaultCommonQuestionsTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Sexual Assault Common Questions\"]");
	public static By sexualAssaultCommonQuestionsUiCards = By.xpath(".//div[contains(@class, \"ui raised segment\")]");

		// Impact of sexual assault
	public static By impactOfSexualAssaultTab = By.xpath(".//div[text()=\"Sexual Assault Awareness\"]/following-sibling::div/a[contains(text(), \"Impact of Sexual Assault\")]");
	public static By impactOfSexualAssaultTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Impact Of Sexual Assault\"]");
	public static By impactOfSexualAssaultUiCards = By.xpath(".//div[contains(@class, \"multi card custom\")]");

		// Sexual Harassment
	public static By sexualHarassmentTab = By.xpath(".//div[text()=\"Sexual Assault Awareness\"]/following-sibling::div/a[contains(text(), \"Sexual Harassment\")]");
	public static By sexualHarassmentTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Sexual Harassment\"]");
	public static By sexualHarassmentUiCards = By.xpath(".//div[contains(@class, \"ui raised cards\")]");

		// Helping a friend or a community member
	public static By helpingAFriendOrCommunityMemberTab = By.xpath(".//div[text()=\"Sexual Assault Awareness\"]/following-sibling::div/a[contains(text(), \"Helping a Friend or a Community Member\")]");
	public static By helpingAFriendOrCommunityMemberTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Helping a Friend or Community Member\"]");
	public static By helpingAFriendOrCommunityMemberUiCards = By.xpath(".//td[contains(@class, \"three wide\")]");

	/*
	 * Policies and Glossary
	 */

		// Peace Corps Policy Summary Sheet
	public static By policySummarySheetTab = By.xpath(".//div[text()=\"Policies and Glossary\"]/following-sibling::div/a[contains(text(), \"Peace Corps Policy Summary Sheet\")]");
	public static By policySummarySheetTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Peace Corps Policy Summary Sheet\"]");
	public static By policySummarySheetUiCards = By.xpath(".//div[contains(@class, \"card full-page\")]");

		// Glossary
	public static By glossaryTab = By.xpath(".//div[text()=\"Policies and Glossary\"]/following-sibling::div/a[contains(text(), \"Glossary\")]");
	public static By glossaryTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Glossary\"]");
	public static By glossaryUiCards = By.xpath(".//div[contains(@class, \"card full-page\")]");

		// Further Resources
	public static By furtherResourcesTab = By.xpath(".//div[text()=\"Policies and Glossary\"]/following-sibling::div/a[contains(text(), \"Further Resources\")]");
	public static By furtherResourcesTitle = By.xpath(".//div[contains(@class, \"ui dividing header\") and text()=\"Further Resources\"]");
	public static By furtherResourcesUiCards = By.xpath(".//div[contains(@class, \"card full-page\")]");

	/*
	* Right and left page navigation buttons
	* */
	public static By rightNavButton = By.xpath(".//i[contains(@class, \"angle right icon\")]");
	public static By leftNavButton = By.xpath(".//i[contains(@class, \"angle left icon\")]");

	/*
	 * Get Help Now
	 */
	public static By gethelpPageTitle = By.xpath("html/body/center/div/div[1]/h1");
	public static String getHelpTitle = "Get Help Now";
	public static By contactPCMO = By.xpath(".//*[@id='bt-PCMO']");
	public static By contactSSM = By.xpath(".//*[@id='bt-SSM']");
	public static By contactSARL = By.xpath(".//*[@id='bt-SARL']");
	public static By toGetHelpPage2 = By.xpath(".//*[@id='tr-2']/td[2]/a");
	public static By pcSavesAnonymousHelpline = By.xpath(".//*[@id='bt-PCSaves']");
	public static By officeOfVictimAdvocacy = By.xpath(".//*[@id='bt-offVA']");
	public static By officeOfInspectorGeneral = By.xpath(".//*[@id='bt-offIG']");
	public static By officeOfCivilRightsAndDiversity = By.xpath(".//*[@id='bt-offCRD']");
	public static By toGetHelpPage1fromPage2 = By.xpath(".//*[@id='bw-arrow']/a");
	public static By changeLocationDropdown = By.xpath(".//*[@id='location']");
	public static By chooseLocationText = By.xpath(".//*[@id='loc']");
	public static By pcmoCallButton = By.xpath(".//*[@id='PCMO-call']");
	public static By pcmoSMSButton = By.xpath(".//*[@id='PCMO-msg']");
	public static By ssmCallButton = By.xpath(".//*[@id='SSM-call']");
	public static By ssmSMSButton = By.xpath(".//*[@id='SSM-msg']");
	public static By sarlCallButton = By.xpath(".//*[@id='SARL-call']");
	public static By sarlSMSButton = By.xpath(".//*[@id='SARL-msg']");
	public static By makeCallButton = By.xpath(".//*[@id='submit']");
	public static By smsBodyTextBox = By.xpath(".//*[@id='SMS-body']");
	public static By sendSMSButton = By.xpath(".//*[@id='bt-SMS']");
	public static By contactNowButtonPCSavesAnonymousHelpline = By.xpath(".//*[@id='bt-cntPC']");
	public static By contactNowButtonOfficeOfVictimAdvocacy = By.xpath(".//*[@id='bt-cntnw']");
	public static By contactNowButtonOfficeOfInspectorGeneral = By.xpath(".//*[@id='bt-cntnw']");
	public static By contactNowButtonoOfficeOfCivilRightsAndDiversity = By.xpath(".//*[@id='bt-cntnw']");
	public static By sendMessageButton = By.xpath(".//*[@id='msg']");
	public static By voiceCallButton = By.xpath(".//*[@id='call']");
	public static By pcSavesLearnMoreLink = By.xpath("html/body/center/div/div[3]/a");
	public static By officeOfVictimAdvocacyEmailLink = By.xpath("html/body/center/div/div[3]/a");
	public static By officeOfInspectorGeneralLearnMoreLink = By.xpath("html/body/center/div/div[3]/a");
	public static By officeOfCivilRightsAndDiversityEmailLink = By.xpath("html/body/center/div/div[3]/a");

	/*
	 * Circle of Trust
	 */
	public static By circleOfTrustTitle = By.xpath("html/body/center/div/div[1]/h1");
	public static By circleOfTrustEditButton = By.xpath(".//*[@id='ic-edit']");
	public static By circleOfTrusHelpMeButton = By.xpath(".//*[@id='help_me']");

	//Button for the message "Come Get me"
	public static By msg1_Button = By.xpath(".//*[@id='msg']");

	//Button for the message "Call I need an interruption"
	public static By msg2_Button = By.xpath(".//*[@id='msg2']");

	//Button for the message "I need to talk"
	public static By msg3_Button = By.xpath(".//*[@id='msg3']");

	public static By comrade1_TextBox = By.xpath(".//*[@id='comrade1']");
	public static By comrade2_TextBox = By.xpath(".//*[@id='comrade2']");
	public static By comrade3_TextBox = By.xpath(".//*[@id='comrade3']");
	public static By comrade4_TextBox = By.xpath(".//*[@id='comrade4']");
	public static By comrade5_TextBox = By.xpath(".//*[@id='comrade5']");
	public static By comrade6_TextBox = By.xpath(".//*[@id='comrade6']");
	public static By circleOfTrusSaveComradeButton = By.xpath("html/body/form/center/div/input");


	/*
	 * Sweet Alert Components
	 */
	public static By alertHeading = By.xpath("html/body/div[3]/h2");
	public static By alertText = By.xpath("html/body/div[3]/p");
	public static By alertButton = By.cssSelector("button.confirm");
}
