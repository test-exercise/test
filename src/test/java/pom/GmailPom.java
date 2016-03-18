package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.concurrent.TimeUnit;


/**
 * Created by bzayats on 3/17/16.
 */
public class GmailPom {
    WebDriver driver;
    Utils utils;

    private String validUserName = "tester1.testeroff@gmail.com";
    private String validPassword = "testerofF1!";

    public GmailPom(WebDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public String getValidUserName(){
        return validUserName;
    }

    public String getValidPassword(){
        return validPassword;
    }

    public WebElement getProfileIconTitle(){
//        WebElement profileTitle = utils.getElementByXpath("//a[@title='Google Account: tester1 Testeroff (tester1.testeroff@gmail.com)']");
        WebElement profileTitle = utils.getElementByCSS(".gb_8a.gb_4c.gb_6e.gb_R");
        return profileTitle;
    }

    public WebElement getSignInPageUserNameField(){
        WebElement emailEntryField = utils.getElementByName("Email");
        return emailEntryField;
    }

    public WebElement getSignInPagePasswordField(){
        WebElement passwordEntryField = utils.getElementByName("Passwd");
        return passwordEntryField;
    }

    public WebElement getWrongPasswordError(){
        WebElement passwordError = utils.getElementByCSS("span#errormsg_0_Passwd.error-msg");
        return passwordError;
    }

    public WebElement getWrongUserNameError(){
        WebElement userNameError = utils.getElementByCSS("span#errormsg_0_Email.error-msg");
        return userNameError;
    }

    public WebElement getSignInPageNextButton(){
        WebElement signInNextButton = utils.getElementByCSS("input#next.rc-button.rc-button-submit");
        return signInNextButton;
    }

    public WebElement getSignInPageSignInButton(){
        WebElement signInButton = utils.getElementByCSS("input#signIn.rc-button.rc-button-submit");
        return signInButton;
    }

    public WebElement getSignOutButton(){
        WebElement signOutButton = utils.getElementByLinkText("Sign out");
        return signOutButton;
    }

    //signIn functionality
    public void signIn(String userName, String passWord){
        getSignInPageUserNameField().sendKeys(userName);
        getSignInPageNextButton().click();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);

        if (getSignInPagePasswordField() != null){
            getSignInPagePasswordField().sendKeys(passWord);
            driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
            getSignInPageSignInButton().click();
        }else{
            return;
        }

    }


}
