package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.security.Credentials;
import pom.GmailPom;
import utils.TestBase;
import utils.Utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by bzayats on 3/17/16.
 */
public class GmailTest extends TestBase {

    private WebDriver driver = getDriver();
    GmailPom gmailPom = new GmailPom(driver);
    Utils utils = new Utils(driver);

    public GmailTest(){
        super("firefox");
    }

    @Before
    public void setUp(){
        utils.goTo("http://www.gmail.com");
    }

    @After
    public void tearDown(){
        gmailPom.getProfileIconTitle().click();
        gmailPom.getSignOutButton().click();
        driver.quit();
    }

    @Test
    public void testValidLogin(){
        gmailPom.signIn(gmailPom.getValidUserName(), gmailPom.getValidPassword());
        utils.explicitWait(gmailPom.getProfileIconTitle(), 10);

        //test
//        Assert.assertTrue(gmailPom.getProfileIconTitle().getAttribute("title").toString().contains("tester1.testeroff@gmail.com"));
        Assert.assertTrue(gmailPom.getProfileIconTitle().isDisplayed());
    }

}
