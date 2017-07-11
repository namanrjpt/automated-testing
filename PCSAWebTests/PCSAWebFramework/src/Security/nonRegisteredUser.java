package Security;


import PageObjectModel.constants;
import WebDriver.driver;
import PageObjectModel.loginPageElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class nonRegisteredUser {

    /*
    * This function goes to a given URL, returns true if the landing page is not loaded
    * and returns false if landing page is loaded
    * */
    public static boolean isRedirectingToLandingPage(String url){

        driver.Instance.navigate().to(url);

        try{
            (new WebDriverWait(driver.Instance, 1)).until(ExpectedConditions.presenceOfElementLocated(constants.signInEmailId));
        }
        catch (org.openqa.selenium.TimeoutException e){
        }

        if(driver.Instance.getCurrentUrl() == "http://localhost/FirstAide-web/"){

            return true;
        }
        else{
            return false;
        }
    }
}
