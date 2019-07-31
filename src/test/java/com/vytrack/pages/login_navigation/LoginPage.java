package com.vytrack.pages.login_navigation;

//That's why we use page object, to remember it easily, we know which page it belongs to, you can figure out from the page
//we are not done at once,it depends on what you need, we don't create methods at once, we create them when we need them (edited)

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    @FindBy(id = "prependedInput")
    public WebElement userNameElement;

    @FindBy(name = "_password")
    public WebElement passwordElement;

    @FindBy(id="_submit")
    public WebElement loginButtonElement;

    @FindBy(className = "custom-checkbox__icon")
    public WebElement rememberMeElement;

    @FindBy(partialLinkText = "Forgot your password?")
    public WebElement forgotPasswordElement;

    @FindBy(tagName = "h2")
    public WebElement titleElement;

    @FindBy(css = "[class='alert alert-error'] > div")
    public WebElement errorMessageElement;



    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String username, String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
        BrowserUtils.waitUntilLoaderScreenDisappear(Driver.getDriver());
    }

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }

    public void clickRememberMe(){
        wait.until(ExpectedConditions.elementToBeClickable(rememberMeElement));
        if(!rememberMeElement.isSelected()){
            rememberMeElement.click();
        }
    }
}


























//    public String userNameLocator = "prependedInput";
//    public String passwordLocator = "prependedInput2";
//    public String loginButtonLocator = "_submit";
//    public String menuIconLocator = "fa-caret-down";
//    public String nameLocator=  "//li[@class='dropdown user-menu-dropdown']//a[@class='dropdown-toggle']";
//    public String pageNameLocator = "//h1[@class='oro-subtitle']";
//    public String errorMessageLocator = "//div[contains(text(),'Invalid user name or password.')]";
//
//
//    //login method
//    public void login(String userName, String password){
//        Driver.getDriver().findElement(By.id(userNameLocator)).sendKeys(userName);
//        Driver.getDriver().findElement(By.id(passwordLocator)).sendKeys(password);
//        Driver.getDriver().findElement(By.id(loginButtonLocator)).click();
//    }
//
//    //logout method
//    public void logout(){
//        Driver.getDriver().findElement(By.className(menuIconLocator)).click();
//        BrowserUtils.waitPlease(2);
//        Driver.getDriver().findElement(By.linkText("Logout")).click();
//    }

