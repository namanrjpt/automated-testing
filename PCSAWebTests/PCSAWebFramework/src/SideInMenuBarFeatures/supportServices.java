package SideInMenuBarFeatures;

import PageObjectModel.safetyToolsElements;
import PageObjectModel.supportServicesElements;
import PageObjectModel.sideInMenuBarElements;
import WebDriver.driver;
import org.openqa.selenium.WebElement;

public class supportServices {
    /*
    * @return true if the navigation to 'Benefits of Seeking Staff Support' is successful
    * */
    public static boolean canGoToBenefitsOfSeekingStaffSupport()
    {
        sideInMenuBarElements.supportServicesTab().click();

        WebElement benefitsOfSeekingStaffSupportTitle = supportServicesElements.benefitsofSeekingStaffSupportTitle();

        if(benefitsOfSeekingStaffSupportTitle.getText().contains("Benefits of Seeking Staff Support") && driver.Instance.getCurrentUrl().contains("seeking-staff-support"))
        {
            return true;
        }
        else
            return false;
    }

    /*
    * @return true if the navigation to 'Available Services After a Sexual Assault' is successful
    * */
    public static boolean canGoToAvailableServicesAfterASexualAssault()
    {
        sideInMenuBarElements.supportServicesTab().click();

        WebElement availableServicesAfterASexualAssaultTitle = supportServicesElements.availableServicesAfterASexualAssaultTitle();

        if(availableServicesAfterASexualAssaultTitle.getText().contains("Available Services after a Sexual Assault") && driver.Instance.getCurrentUrl().contains("services-after-assault"))
        {
            return true;
        }
        else
            return false;
    }

    /*
    * @return true if the navigation to 'Commitment to Victims of Sexual Assault' is successful
    * */
    public static boolean canGoToCommitmentToVictimsOfSexualAssault()
    {
        sideInMenuBarElements.supportServicesTab().click();

        WebElement commitmentToVictimsOfSexualAssaultTitle = supportServicesElements.commitmentToVictimsOfSexualAssaultTitle();

        if(commitmentToVictimsOfSexualAssaultTitle.getText().contains("Peace Corps Commitment to Victims of Sexual Assualt") && driver.Instance.getCurrentUrl().contains("peace-corps-commitment"))
        {
            return true;
        }
        else
            return false;
    }

    /*
    * @return true if the navigation to 'Confidentiality' is successful
    * */
    public static boolean canGoConfidentiality()
    {
        sideInMenuBarElements.supportServicesTab().click();

        WebElement confidentialityTitle = supportServicesElements.confidentialityTitle();

        if(confidentialityTitle.getText().contains("Confidentiality") && driver.Instance.getCurrentUrl().contains("confidentiality"))
        {
            return true;
        }
        else
            return false;
    }

    /*
    * @return true if the navigation to 'Peace Corps Mythbusters' is successful
    * */
    public static boolean canGoToPeaceCorpsMythbusters()
    {
        sideInMenuBarElements.supportServicesTab().click();

        WebElement peaceCorpsMythbustersTitle = supportServicesElements.peaceCorpsMythbustersTitle();

        if(peaceCorpsMythbustersTitle.getText().contains("Peace Corps Mythbusters: Assumptions and Facts") && driver.Instance.getCurrentUrl().contains("mythbusters"))
        {
            return true;
        }
        else
            return false;
    }


}
