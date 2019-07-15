package com.vytrack.tests.components.login_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class LoginTest {

// 1. Login to Vytrack as a store manager
//2. Verify name of the store manager is displayed on top right
//3. Verify Dashboad page is open
//4. Log out
//5. Login to Vytrack as a sales manager
//6. Verify Dashboad page is open
//7. A different name should be displayed on top right
//8. Log out
//9. Login to Vytrack as a driver
//10. Verify Dashboad/Quick Launchpad page is open
//11. A different name should be displayed on top right



    WebDriver driver;


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

    }

// 1. Login to Vytrack as a store manager
//2. Verify name of the store manager is displayed on top right
//3. Verify Dashboad page is open
//4. Log out
    @Test (priority = 1)
    public void storemanagertest(){

       driver.findElement(By.cssSelector("#prependedInput")).sendKeys("storemanager85");
       driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
       driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);

       // Verify name of the store manager is displayed on top right
        WebElement storemanagername = driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a"));
        String actualname = storemanagername.getText();
        SeleniumUtils.waitPlease(3);
        Assert.assertTrue(actualname.contains("Pearl Wuckert"));
        SeleniumUtils.waitPlease(3);

      //  Verify Dashboad page is open
        String actualtitle = driver.getTitle();
        SeleniumUtils.waitPlease(3);
        Assert.assertTrue(actualtitle.contains("Dashboard"));
        SeleniumUtils.waitPlease(3);

     // Log out
        SeleniumUtils.waitPlease(3);
        storemanagername = driver.findElement(By.xpath("//*[@id=\"user-menu\"]/a"));//Found above
        SeleniumUtils.waitPlease(3);
        storemanagername.click();
        SeleniumUtils.waitPlease(3);
        WebElement logout = driver.findElement(By.xpath("//a[@class='no-hash'][contains(text(),Log)]"));
        SeleniumUtils.waitPlease(3);
        logout.click();

    }

//5. Login to Vytrack as a sales manager
//6. Verify Dashboad page is open
//7. A different name should be displayed on top right
//8. Log out

    @Test (priority = 2)
    public void salesmanagertest() {

        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("salesmanager252");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);

        //6. Verify Dashboad page is open
        String title = driver.getTitle();
        SeleniumUtils.waitPlease(3);
        Assert.assertTrue(title.contains("Dashboard"));
        SeleniumUtils.waitPlease(3);

       // A different name should be displayed on top right
        WebElement name = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Clifton')]"));
        SeleniumUtils.waitPlease(3);
        String actualname = name.getText();
        SeleniumUtils.waitPlease(3);
        Assert.assertFalse(actualname.contains("Pearl Wuckert"));

        //8. Log out
        SeleniumUtils.waitPlease(3);
        name = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Clifton')]"));
        SeleniumUtils.waitPlease(3);
        name.click();
        SeleniumUtils.waitPlease(3);
        WebElement logout = driver.findElement(By.xpath("//a[@class='no-hash'][contains(text(),Log)]"));
        SeleniumUtils.waitPlease(3);
        logout.click();

    }

    //9. Login to Vytrack as a driver
//10. Verify Dashboad/Quick Launchpad page is open
//11. A different name should be displayed on top right


    @Test (priority = 3)
    public void truckdrivertest() {

        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("User151");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);


        //10. Verify Dashboad/Quick Launchpad page is open
        WebElement launchpad = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
        String actualheader = launchpad.getText();
        Assert.assertTrue(actualheader.contains("Quick Launchpad"));
        String actualtitle = driver.getTitle();
        Assert.assertTrue(actualtitle.contains("Dashboard"));

        //11. A different name should be displayed on top right
        SeleniumUtils.waitPlease(3);
        WebElement name = driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Abdi')]"));
        SeleniumUtils.waitPlease(3);
        String actualname = name.getText();
        SeleniumUtils.waitPlease(3);
        Assert.assertFalse(actualname.contains("Pearl Wuckert"));




    }


//    TEST CASE: Login test (negative)
//1. Open Vytrack login page
//2. Enter valid username and invalid password information
//3. Click login
//4. Message Invalid user name or password. should be displayed
//5. Page title and url should be same

    @Test (priority = 4)
    public void LoginTestNegative(){

        String beforeloginURL = driver.getCurrentUrl();
        String beforeloginTitle = driver.getTitle();

        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);


       //4. Message Invalid user name or password. should be displayed
        String message = driver.findElement(By.xpath("//div[contains(text(),'Invalid user name or password.')]")).getText();
        SeleniumUtils.waitPlease(2);
         Assert.assertEquals(message,"Invalid user name or password.");

        //5. Page title and url should be same
        SeleniumUtils.waitPlease(2);
        String afterloginURL = driver.getCurrentUrl();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(beforeloginURL,afterloginURL);

        SeleniumUtils.waitPlease(2);
        String afterloginTitle = driver.getTitle();
        SeleniumUtils.waitPlease(2);
        Assert.assertEquals(beforeloginTitle,afterloginTitle);

    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }




}
