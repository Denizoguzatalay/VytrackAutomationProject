package com.vytrack.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import utilities.BrowserFactory;
import utilities.SeleniumUtils;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest {

//    Login	to	Vytrack	as	a	driver
//    2.Navigate	to	Fleet	àVehicles,	verify	page	title	Car	-Entities	-System	-Car	-Entities	-System,	page	name	All	Cars(updated)
//    3.Navigate	to	Customers	àAccounts,	verify	page	title	Accounts	-Customers,	verify	page	name	Accounts
//    4.Navigate	to	Customers	àContacts,	verify	page	title	Contacts-Customers,	verify	page	name	Contacts(updated)
//    5.Navigate	to	Activities	àCalendar	Events,	verify	page	title	Calendar	Events	-Activities,	page	name	Calendar	Events


    WebDriver driver  ;
   // Actions action = new Actions(driver);

   @BeforeGroups (groups = {"a"})
    public void setUp1TruckDriver(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.get("http://qa2.vytrack.com/user/login");
       driver.findElement(By.id("prependedInput")).sendKeys("User151");
       driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
       driver.findElement(By.id("_submit")).click();
       SeleniumUtils.waitPlease(5);

    }


    @Test(groups = {"a"})
    public void Truckdrivertest1(){

        SeleniumUtils.waitPlease(5);
        WebElement fleet1 =driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[1]"));
        fleet1.click();
        SeleniumUtils.waitPlease(4);
        // action.moveToElement(fleet1);
        WebElement fleet = driver.findElement(By.xpath("(//span[@class='title title-level-2'][contains(text(),'Vehicles')])[1]"));
        SeleniumUtils.waitPlease(4);
        fleet.click();
        SeleniumUtils.waitPlease(4);
        String actual = driver.getTitle();
        SeleniumUtils.waitPlease(4);
        System.out.println(actual);
        SeleniumUtils.waitPlease(4);
        Assert.assertTrue(actual.contains("Car - Entities - System - Car - Entities - System"));
       //action.moveToElement(fleet);
       //action.click().build().perform();

    }

    @Test (groups = {"a"})
    public void Truckdrivertest2(){
        SeleniumUtils.waitPlease(5);
       driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][2]")).click();
       SeleniumUtils.waitPlease(3);
       driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Account')]")).click();
       SeleniumUtils.waitPlease(3);
       String actual = driver.getTitle();
       Assert.assertTrue(actual.contains("Accounts - Customers"));
        SeleniumUtils.waitPlease(4);
    }

    @Test (groups = {"a"})
    public void Truckdrivertest3(){
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][2]")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Contacts')]")).click();
        SeleniumUtils.waitPlease(3);
        String actual = driver.getTitle();
        Assert.assertTrue(actual.contains("All - Contacts - Customers"));

    }

    @Test (groups = {"a"})
    public void Truckdrivertest4(){
        SeleniumUtils.waitPlease(5);
       driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        SeleniumUtils.waitPlease(3);
       driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Calendar Events')]")).click();
        SeleniumUtils.waitPlease(3);
        String actual = driver.getTitle();
        Assert.assertTrue(actual.contains("Calendar Events - Activities"));
        driver.quit();
    }

//    Login to Vytrack as a store manager
//2. Navigate to Dashboards à Dashboard, verify page title Dashboard - Dashboards, verify page name Dashboard
//3. Navigate to FleetàVehicles, verify page title All - Car - Entities - System - Car - Entities - System, page name All Cars (updated)
//4. Navigate to CustomersàAccounts, verify page title All - Accounts – Customers, verify page name All Accounts(updated)
//5. Navigate to CustomersàContacts, verify page title All - Contacts - Customers, verify page name All Contacts (updated)
//6. Navigate to Sales à Opportunities, verify page title Open Opportunities - Opportunities - Sales, verify page name Open Opportunities
//7. Navigate to ActivitiesàCalls verify page title All - Calls - Activities, page name All Calls (updated)
//8. Navigate to ActivitiesàCalendar Events, verify page title Calendar Events - Activities, page name All Calendar Events (updated)
    @BeforeGroups (groups = {"b"})
    public void setUp2StoreManager(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        SeleniumUtils.waitPlease(5);

    }

    @Test (groups = {"b"})
    public void StoreManagertest5(){
        SeleniumUtils.waitPlease(5);
       driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Dash')]")).click();
        SeleniumUtils.waitPlease(3);
       driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Dash')][1]")).click();
        SeleniumUtils.waitPlease(3);
       String actual = driver.getTitle();
        SeleniumUtils.waitPlease(3);
       Assert.assertTrue(actual.contains("Dashboard - Dashboards"));

    }


    //Navigate to FleetàVehicles, verify page title All - Car - Entities - System - Car - Entities - System, page name All Cars (updated)
    @Test (groups= {"b"})

    public void StoreManagertest6() {
        SeleniumUtils.waitPlease(5);
        //find location for Fleet
        WebElement fleet1 =driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[1]"));
        SeleniumUtils.waitPlease(5);
        fleet1.click();
        SeleniumUtils.waitPlease(5);

        //find location for Vehicle
        WebElement vehicle = driver.findElement(By.xpath("(//span[@class='title title-level-2'][contains(text(),'Vehicles')])[1]"));
        SeleniumUtils.waitPlease(5);
        vehicle.click();
        SeleniumUtils.waitPlease(5);

        String expectedTitle="All - Car - Entities - System - Car - Entities - System";
        System.out.println( driver.getTitle());

        SeleniumUtils.waitPlease(5);

        Assert.assertTrue( driver.getTitle().contains(expectedTitle));
        SeleniumUtils.waitPlease(5);
    }



    @Test (groups = {"b"})
    public void StoreManagertest7(){
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][2]")).click();
        SeleniumUtils.waitPlease(3);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Account')]")).click();
        SeleniumUtils.waitPlease(3);
        String actual = driver.getTitle();
        SeleniumUtils.waitPlease(3);
        System.out.println(actual);
        SeleniumUtils.waitPlease(3);
        Assert.assertTrue(actual.contains("All - Accounts - Customers"));


    }

    //5. Navigate to CustomersàContacts, verify page title All - Contacts - Customers, verify page name All Contacts (updated)
    @Test (groups = {"b"})
    public void StoreManagertest8(){
        SeleniumUtils.waitPlease(5);
       driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Cust')]")).click();
        SeleniumUtils.waitPlease(3);
       driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Contacts')]")).click();
        SeleniumUtils.waitPlease(3);
       String actual = driver.getTitle();
       SeleniumUtils.waitPlease(3);
       System.out.println(actual);
       SeleniumUtils.waitPlease(3);
       Assert.assertTrue(actual.contains("All - Contacts - Customers"));


    }


    //6. Navigate to Sales à Opportunities, verify page title Open Opportunities - Opportunities - Sales, verify pag

    @Test (groups = {"b"})
    public void StoreManagertest9(){
        SeleniumUtils.waitPlease(5);
       driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Sales')]")).click();
        SeleniumUtils.waitPlease(4);
       driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Opportunities')] ")).click();
        SeleniumUtils.waitPlease(4);
        String actual = driver.getTitle();
        SeleniumUtils.waitPlease(4);
        System.out.println(actual);
        SeleniumUtils.waitPlease(4);
        Assert.assertTrue(actual.contains("Open Opportunities - Opportunities - Sales"));

    }

//7. Navigate to ActivitiesàCalls verify page title All - Calls - Activities, page name All Calls (updated)

    @Test (groups = {"b"})
    public void StoreManagertest10(){
        SeleniumUtils.waitPlease(5);
       driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Acti')]")).click();
        SeleniumUtils.waitPlease(4);
       driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Calls')]")).click();
        SeleniumUtils.waitPlease(4);
        String actual = driver.getTitle();
        SeleniumUtils.waitPlease(4);
        System.out.println(actual);
        SeleniumUtils.waitPlease(4);
        Assert.assertTrue(actual.contains("All - Calls - Activities"));

    }

//8. Navigate to ActivitiesàCalendar Events, verify page title Calendar Events - Activities, page name All Calendar Events (updated)


    @Test (groups = {"b"})
    public void StoreManagertest11() {
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Acti')]")).click();
        SeleniumUtils.waitPlease(4);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Calendar Ev')]")).click();
        SeleniumUtils.waitPlease(4);
        String actual = driver.getTitle();
        SeleniumUtils.waitPlease(4);
        System.out.println(actual);
        SeleniumUtils.waitPlease(4);
        Assert.assertTrue(actual.contains("All - Calendar Events - Activities"));
        driver.quit();
    }


//    @Test
//    public void test2(){
//        driver.findElement(By.id("prependedInput")).sendKeys("User151");
//        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
//        driver.findElement(By.id("_submit")).click();
//        SeleniumUtils.waitPlease(3);
//        //Customers locator
//        WebElement customers = driver.findElement(By.xpath("(//li[@class='dropdown dropdown-level-1'])[2]"));
//
//        SeleniumUtils.waitPlease(3);
//        //actions work as hover over gives you methods
//        action.moveToElement(customers);
//
//        WebElement accounts1 = driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Accounts')]"));
//        //second way to locate accounts
//        WebElement accounts2 = driver.findElement(By.xpath("(//a[contains(@href,'account')])[1]"));
//       action.moveToElement(accounts1).click().build().perform();
//
//
//
//
//
//
//    }



}





















