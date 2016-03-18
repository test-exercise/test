package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.util.concurrent.TimeUnit;

/**
 * Created by bzayats on 3/17/16.
 */
public class EbayPom {
    WebDriver driver;
    Utils utils;

    private String query = "Electric Guitar";

    public EbayPom(WebDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
    }

    public String getQuery(){
        return query;
    }

    public WebElement getSearchInputField(){
        WebElement searchInputField = utils.getElementByCSS("input#gh-ac.gh-tb.ui-autocomplete-input");
        return searchInputField;
    }

    public WebElement getSearchButton(){
        WebElement searchButton = utils.getElementByCSS("input#gh-btn.btn.btn-prim.gh-spr");
        return searchButton;
    }

    public WebElement getFirstItemPrice(){
        WebElement firstItemPrice = utils.getElementByCSS("li.lvprice.prc");
        return firstItemPrice;
    }

    public void enterQuery(){
        getSearchInputField().sendKeys(query);
        getSearchButton().click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }
}
