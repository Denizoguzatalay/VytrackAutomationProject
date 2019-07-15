package com.vytrack.tests.components.login_navigation;

//Automate	 the	 following	 page	 visibility	 and	 navigation	 related	 tests	 in	 new	 class	PageAccessTest.
//TEST	CASE:Vehicle	contracts	test	store	manager
//        1.Login	to	Vytrack	as	a	store	manager
//        2Verify	that	you	can	access	Vehicle	contract page

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

public class PageAccessTest {

    WebDriver driver;


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

    }

    @Test (priority = 1)
    public void storemanagertest() {

        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);

       // 2Verify	that	you	can	access	Vehicle	contract page
        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]"));
        SeleniumUtils.waitPlease(3);
        fleet.click();
        SeleniumUtils.waitPlease(3);

        WebElement contract = driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Vehicle Contracts')]"));
        SeleniumUtils.waitPlease(3);
        contract.click();
        SeleniumUtils.waitPlease(3);

        String actualtitle = driver.getTitle();
        System.out.println(actualtitle);
        Assert.assertTrue(actualtitle.contains("All - Vehicle Contract - Entities - System - Car - Entities - System"));

    }



//    Vehicle	contracts	test	store	manager
//    1.Login	to	Vytrack	as	a	salesmanager
//    2.Verify	that	you	can	access	Vehicle	contracts page

    @Test (priority = 2)
    public void salesmanagertest() {

        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("salesmanager252");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);

        // 2Verify	that	you	can	access	Vehicle	contract page
        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]"));
        SeleniumUtils.waitPlease(3);
        fleet.click();
        SeleniumUtils.waitPlease(3);

        WebElement contract = driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Vehicle Contracts')]"));
        SeleniumUtils.waitPlease(3);
        contract.click();
        SeleniumUtils.waitPlease(3);

        String actualtitle = driver.getTitle();
        System.out.println(actualtitle);
        Assert.assertTrue(actualtitle.contains("All - Vehicle Contract - Entities - System - Car - Entities - System"));

    }


//    	Vehicle	contracts	test	store	manager
//        1.Login	to	Vytrack	as	a	driver
//        2.Verify	that	you	cannot	access	Vehicle	contracts	page
//        3.Message	You do not have permission to perform this action.should be	displayed


    @Test (priority = 3)
    public void truckdriverrtest() {

        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("User151");
        driver.findElement(By.cssSelector("#prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(3);

        // 2Verify	that	you	can	access	Vehicle	contract page
        WebElement fleet = driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]"));
        SeleniumUtils.waitPlease(3);
        fleet.click();
        SeleniumUtils.waitPlease(3);

        WebElement contract = driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Vehicle Contracts')]"));
        SeleniumUtils.waitPlease(3);
        contract.click();
        SeleniumUtils.waitPlease(3);

        String actualmessage = driver.findElement(By.xpath("//div[@class='message'][contains(text(),'You do not have permission to perform this action.')]")).getText();
        String expectedmessage = "You do not have permission to perform this action.";
        System.out.println(actualmessage);
        Assert.assertEquals(expectedmessage, actualmessage);

    }


    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
