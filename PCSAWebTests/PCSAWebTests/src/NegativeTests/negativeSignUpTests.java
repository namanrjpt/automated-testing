package NegativeTests;

import BaseTests.commonTest;
import NegativeTesting.login;
import org.testng.Assert;
import org.testng.annotations.Test;
import LoginAndRegistration.registration;
import NegativeTesting.signUp;

/**
 * Created by naman on 18/6/17.
 */
public class negativeSignUpTests extends commonTest {
    @Test
    public void AllBlankFieldsTest(){
        registration.Goto();
        signUp.allBlankFields();
        Assert.assertEquals(signUp.appearanceOfEmailPrompt(), true, "Prompt is not showing");
    }

    @Test
    public void BlankEmailId(){
        registration.Goto();
        signUp.blankEmailId();
        Assert.assertEquals(signUp.appearanceOfEmailPrompt(), true, "Prompt is not showing");
    }

    @Test
    public void BlankUsername(){
        registration.Goto();
        signUp.blankUsername();
        Assert.assertEquals(signUp.appearanceOfUsernamePrompt(), true, "Prompt is not showing");
    }

    @Test
    public void BlankPassword(){
        registration.Goto();
        signUp.blankPassword();
        Assert.assertEquals(signUp.appearanceOfPasswordPrompt(), true, "Prompt is not showing");
    }

    @Test
    public void MismatchedPasswords(){
        registration.Goto();
        signUp.mismatchedPasswords();
        Assert.assertEquals(signUp.appearanceOfConfirmPasswordPrompt(), true, "Prompt is not showing");
    }

    @Test
    public void passwordLessThanSixCharacters(){
        registration.Goto();
        signUp.passwordLessThanSixCharacters();
        Assert.assertEquals(signUp.appearanceOfMinSixCharsLongPrompt(), true, "Prompt is not showing");
    }

    @Test
    public void BlankCountry(){
        registration.Goto();
        signUp.blankCountry();
        Assert.assertEquals(signUp.appearanceOfCountryPrompt(), true, "Prompt is not showing");
    }
}
