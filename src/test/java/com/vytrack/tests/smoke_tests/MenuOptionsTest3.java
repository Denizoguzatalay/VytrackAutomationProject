package com.vytrack.tests.smoke_tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utilities.VytrackUtilities;

import java.util.concurrent.TimeUnit;

public class MenuOptionsTest3 {
    WebDriver driver;


    @BeforeGroups(groups = {"a"})
    public void setUp1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.name("_username")).sendKeys("user10");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        VytrackUtilities.waitPlease(5);
    }

    @Test(groups = {"a"})
    public void driverTest1(){
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")).click();
        VytrackUtilities.waitPlease(2);
        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        String expectedName = "Cars";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName,actualName);
    }

    @Test(groups = {"a"})
    public void driverTest2(){
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[contains(text(),'Accounts')]")).click();
        VytrackUtilities.waitPlease(2);
        String expectedTitle = "Accounts - Customers";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        String expectedName = "Accounts";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName,actualName);
    }

    @Test(groups = {"a"})
    public void driverTest3(){
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
        VytrackUtilities.waitPlease(2);
        String expectedTitle = "Contacts - Customers";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        String expectedName = "Contacts";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName,actualName);
    }
    @Test(groups = {"a"})
    public void driverTest4(){
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item last']//span[@class='title title-level-2'][contains(text(),'Calendar Events')]")).click();
        VytrackUtilities.waitPlease(2);
        String expectedTitle = "Calendar Events - Activities";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        String expectedName = "Calendar Events";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName,actualName);
        driver.quit();
    }


    @BeforeGroups(groups = {"b"})
    public void setUp2(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.name("_username")).sendKeys("storemanager57");
        driver.findElement(By.name("_password")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        VytrackUtilities.waitPlease(5);
    }

    @Test(groups = {"b"})
    public void storeManagerTest1(){
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Dashboards')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Dashboard')]")).click();
        VytrackUtilities.waitPlease(5);
        String expectedTitle = "Dashboard - Dashboards";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        String expectedName = "Dashboard";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName,actualName);
    }
    @Test(groups = {"b"})
    public void storeManagerTest2() {
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Fleet')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Vehicles')]")).click();
        VytrackUtilities.waitPlease(5);
        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedName = "All Cars";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(groups = {"b"})
    public void storeManagerTest3() {
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Accounts')]")).click();
        VytrackUtilities.waitPlease(5);
        String expectedTitle = "All - Accounts - Customers";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedName = "All Accounts";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(groups = {"b"})
    public void storeManagerTest4() {
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Customers')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
        VytrackUtilities.waitPlease(5);
        String expectedTitle = "All - Contacts - Customers";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedName = "All Contacts";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(groups = {"b"})
    public void storeManagerTest5() {
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Sales')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Opportunities')]")).click();
        VytrackUtilities.waitPlease(5);
        String expectedTitle = "Open Opportunities - Opportunities - Sales";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedName = "Open Opportunities";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);
    }
    @Test(groups = {"b"})
    public void storeManagerTest6() {
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Calls')]")).click();
        VytrackUtilities.waitPlease(5);
        String expectedTitle = "All - Calls - Activities";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedName = "All Calls";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test(groups = {"b"})
    public void storeManagerTest7() {
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-1'][contains(text(),'Activities')]")).click();
        VytrackUtilities.waitPlease(5);
        driver.findElement(By.xpath("//span[@class='title title-level-2'][contains(text(),'Calendar Events')]")).click();
        VytrackUtilities.waitPlease(5);
        String expectedTitle = "All - Calendar Events - Activities";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        String expectedName = "All Calendar Events";
        String actualName = driver.findElement(By.xpath("//h1[@class='oro-subtitle']")).getText();
        Assert.assertEquals(expectedName, actualName);
        driver.quit();
    }

}