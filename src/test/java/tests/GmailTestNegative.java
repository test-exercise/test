package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pom.GmailPom;
import utils.TestBase;
import utils.Utils;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by bzayats on 3/17/16.
 */
@RunWith(value = Parameterized.class)
public class GmailTestNegative extends TestBase{

    WebDriver driver = getDriver();
    GmailPom gmailPom = new GmailPom(driver);
    Utils utils = new Utils(driver);

    //data fields
    private String userName;
    private String passWord;

    public GmailTestNegative(String userName, String passWord){
        super("firefox");
        this.userName = userName;
        this.passWord = passWord;
    }

    //declaring arguments for negative tests
    @Parameterized.Parameters(name = "{index}: [{0}] = {1}")
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{{"tester1testeroff", "testerofF1!"}, {"tester1.testeroff", "testeroff1!"},
                {"#$%^&", "testerofF1!"}, {"tester1.testeroff", "@#$%^"}, {" ", "testerofF1!"}, {"tester1.testeroff", " "}};

        return Arrays.asList(data);
    }

    @Before
    public void setUp(){
        utils.goTo("http://www.gmail.com");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testInvalidSignIn(){
        gmailPom.signIn(userName, passWord);

        //test
        if(gmailPom.getProfileIconTitle() != null){
            //with first negative test it will sign in
            Assert.assertTrue(gmailPom.getProfileIconTitle().isDisplayed());
        }else if (gmailPom.getWrongUserNameError() != null){
            Assert.assertTrue(gmailPom.getWrongUserNameError().isEnabled());
        }else{
            Assert.assertTrue(gmailPom.getWrongPasswordError() != null && gmailPom.getWrongPasswordError().isEnabled());
        }
    }

//    @Test
//    public void invalidLoginWrongPasswordTest(){
//        gmailPom.signIn(userName, passWord);
//        //test
//        Assert.assertFalse(gmailPom.getProfileIconTitle().isDisplayed());
//    }

//
//    @Test
//    public void invalidLoginUserName_specialCharsTest(){
//
//    }
//
//    @Test
//    public void invalidLoginPassWord_specialCharsTest(){
//
//    }
//
//    @Test
//    public void invalidLoginEmptyUserNameTest(){
//
//    }
//
//    @Test
//    public void invalidLoginEmptyPasswordTest(){
//
//    }
}
