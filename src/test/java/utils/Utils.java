package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by bzayats on 3/17/16.
 */
public class Utils {
    WebDriver driver;

    public Utils(WebDriver driver){
        this.driver = driver;
    }

    public void goTo(String url){
        driver.get(url);
    }

    public WebElement getElementByXpath(String xpath){
        try{
            WebElement ele = driver.findElement(By.xpath(xpath));
            return ele;
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getElementByClassName(String className){
        try{
            WebElement ele = driver.findElement(By.className(className));
            return ele;
        }catch(NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getElementByName(String name){
        try{
            WebElement ele = driver.findElement(By.name(name));
            return ele;
        }catch(NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getElementByCSS(String cssSelector){
        try{
            WebElement ele = driver.findElement(By.cssSelector(cssSelector));
            return ele;
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }

    public WebElement getElementByLinkText(String linkText){
        try{
            WebElement ele = driver.findElement(By.linkText(linkText));
            return ele;
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean explicitWait(WebElement ele, int time) {
        ele = (new WebDriverWait(driver, time))
                .until(ExpectedConditions.visibilityOf(ele));

        if (ele.isDisplayed()){
            System.out.println("Desired element found");
            return true;
        }else{
            System.out.println("Desired element not found");
            return false;
        }

        //        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
    }

    public int getCurrentWindows(){
        int counter = 0;
        for (String handle : driver.getWindowHandles()){
            counter++;
        }

        return counter;
    }
}
