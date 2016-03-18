package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pom.EbayPom;
import utils.TestBase;
import utils.Utils;

/**
 * Created by bzayats on 3/17/16.
 */
public class EbayTest extends TestBase{

    private WebDriver driver = getDriver();
    EbayPom ebayPom = new EbayPom(driver);
    Utils utils = new Utils(driver);

    public EbayTest(){
        super("firefox");
    }

    @Before
    public void setUp(){
        utils.goTo("http://www.ebay.com");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testGetFirstSearchResult(){
        ebayPom.enterQuery();
        System.out.println("First item's price is: " + ebayPom.getFirstItemPrice().getText());
        Assert.assertTrue(ebayPom.getFirstItemPrice().isDisplayed());
    }

}
