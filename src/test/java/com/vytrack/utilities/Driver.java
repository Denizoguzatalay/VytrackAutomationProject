package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private static WebDriver driver;

    //make the constructor private so that this class cannot be instantiated
    private Driver(){

    }
    //whenever we need driver it will create the instance but one and only one instance!(SingleTon)
    public static WebDriver getDriver(){
        if(driver==null){
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Illegal browser name!");
            }
        }
        return driver;
    }

    //will kill driver
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}