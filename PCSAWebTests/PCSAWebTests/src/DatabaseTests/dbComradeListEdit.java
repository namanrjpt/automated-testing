package DatabaseTests;

import Database.dbChecks;
import LoginAndRegistration.existingUserLogin;
import Logs.log4j;
import PageObjectModel.circleOfTrustPageElements;
import PageObjectModel.sideInMenuBarElements;
import WebDriver.driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class dbComradeListEdit extends dbConnection {

    @BeforeClass
    public static void startDriver()
    {
        try
        {
            driver.initalizeDriver();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        existingUserLogin.login();
    }


    /*
    * This test checks if the changes in the comrade list page's DOM
    * is being made in the database
    * */
    @Test
    public void editingComradeList(){
        WebElement circleOfTrustTab = sideInMenuBarElements.circleOfTrustTab();

        String testNumber = "87654321";

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
        circleOfTrustPageElements.comrade1_TextBox().sendKeys(testNumber);
        circleOfTrustPageElements.circleOfTrustSaveComradeButton().click();

        Assert.assertEquals(dbChecks.isComradeDataPresent(testNumber), true, "Database is not updated");


    }

    @AfterClass
    public static void tearDown()
    {
        try
        {
            driver.closeDriver();
        }
        catch( Exception e)
        {
            e.printStackTrace();
        }
    }
}
