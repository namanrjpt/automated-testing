package SideInMenuBarFeatures;

import PageObjectModel.sideInMenuBarElements;
import PageObjectModel.sexualAssaultAwarenessElements;
import WebDriver.driver;
import org.openqa.selenium.WebElement;

/**
 * Created by naman on 24/6/17.
 */
public class sexualAssaultAwareness
{
    /*
    * @return true if the navigation to 'Was it Sexual Assault' is successful
    * */
    public static boolean canGoToWasItSexualAssault()
    {
        sideInMenuBarElements.sexualAssaultAwarenesstTab().click();
        WebElement sexualAssaultAwarenessTitle = sexualAssaultAwarenessElements.wasItSexualAssaultTitle();
        if(sexualAssaultAwarenessTitle.getText().contains("What is Sexual Assault?") && driver.Instance.getCurrentUrl().contains("sexual-assault"))
        {
            return true;
        }
        else
            return false;
    }

    /*
    * @return true if the navigation to 'Sexual Assault Common Question' is successful
    * */
    public static boolean canGoToSexualAssaultCommonQuestions()
    {
        sideInMenuBarElements.sexualAssaultAwarenesstTab().click();
        WebElement sexualAssaultCommonQuestionsTitle = sexualAssaultAwarenessElements.sexualAssaultCommonQuestionsTitle();
        if(sexualAssaultCommonQuestionsTitle.getText().contains("Sexual Assault Common Questions") && driver.Instance.getCurrentUrl().contains("common-questions"))
        {
            return true;
        }
        else
            return false;

    }

    /*
    * @return true if the navigation to 'Impact of sexual Assault' is successful
    * */
    public static boolean canGoToImpactOfSexualAssault()
    {
        sideInMenuBarElements.sexualAssaultAwarenesstTab().click();
        WebElement impactOfSexualAssaultTitle = sexualAssaultAwarenessElements.impactOfSexualAssaultTitle();
        if(impactOfSexualAssaultTitle.getText().contains("Impact Of Sexual Assault") && driver.Instance.getCurrentUrl().contains("impact-of-assault"))
        {
            return true;
        }
        else
            return false;

    }

    /*
    * @return true if the navigation to 'Sexual Harassment' is successful
    * */
    public static boolean canGoToSexualHarassment()
    {
        sideInMenuBarElements.sexualAssaultAwarenesstTab().click();
        WebElement sexualHarassmentTitle = sexualAssaultAwarenessElements.sexualHarassmentTitle();
        if(sexualHarassmentTitle.getText().contains("Sexual Harassment") && driver.Instance.getCurrentUrl().contains("sexual-harassment"))
        {
            return true;
        }
        else
            return false;

    }

    public static boolean canGoToHelpingAFriendOrCommunityMember()
    {
        sideInMenuBarElements.sexualAssaultAwarenesstTab().click();
        WebElement helpingAFriendOrCommunityMemberTitle = sexualAssaultAwarenessElements.helpingAFriendOrCommunityMemberTitle();
        if(helpingAFriendOrCommunityMemberTitle.getText().contains("Helping a Friend or Community Member") && driver.Instance.getCurrentUrl().contains("help-a-friend"))
        {
            return true;
        }
        else
            return false;

    }

}
