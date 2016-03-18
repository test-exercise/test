package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.IllegalFormatCodePointException;

/**
 * Created by bzayats on 3/17/16.
 */
public class TestBase {
    private WebDriver driver;

    //for this exercise, we are supporting only FireFox
    public TestBase(String driver){
        if(driver.equalsIgnoreCase("firefox")) {
            this.driver = new FirefoxDriver();
        }else{
            throw new IllegalArgumentException("Provided webdriver currently not supported");
        }
    }

    public WebDriver getDriver(){
        System.out.println("Base driver is: " + driver.toString());
        return driver;
    }
}
