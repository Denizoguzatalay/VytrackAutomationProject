package com.vytrack.pages.dashboards;

import com.vytrack.utilities.Driver;
import com.vytrack.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    public static void navigateToModule(WebDriver driver, String tab, String module){
        String tabLocator = "//span[contains(text(),'"+tab+"') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'"+module+"') and contains(@class, 'title title-level-2')]";
        Driver.getDriver().findElement(By.xpath(tabLocator)).click();
        BrowserUtils.waitForVisibility(By.xpath(moduleLocator),5);
        Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
    }

}