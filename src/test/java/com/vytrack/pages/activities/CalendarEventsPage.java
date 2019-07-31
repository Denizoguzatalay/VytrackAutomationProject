package com.vytrack.pages.activities;

import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class CalendarEventsPage {

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEventBtn;

    @FindBy(css = "[id^='oro_calendar_event_form_title']")
    public WebElement titleInputLocator;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDateLocator;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDateLocator;

    @FindBy(css = ".ui-datepicker-current.ui-state-default.ui-priority-secondary.ui-corner-all")
    public WebElement todayDateButtonLocator;


    @FindBy(css = ".input-small.timepicker-input.start.ui-timepicker-input")
    public WebElement startTimeLocator;

    @FindBy(css = ".ui-timepicker-pm.ui-timepicker-selected")
    public WebElement selectedTime;

    @FindBy(css = ".input-small.timepicker-input.end.ui-timepicker-input")
    public WebElement endTimeLocator;


///////////////////////////////////////////////////////////////

    @FindBy(css = "[id^='recurrence-repeat-']")
    public WebElement repeatCheckBoxLocator;


    @FindBy(css = "select[id^='recurrence-repeats-view']")
    public WebElement repeatsDailyDropdownLocator;


    @FindBy(css = "label[class='fields-row']>input[checked='checked']")
    public WebElement repeatEveryRadioButtonLocator;

//    @FindBy(css = "label[class='fields-row']>input[value='daily']+input")
//    public WebElement dailyValueLocator;

    @FindBy(css = "label[class='fields-row']>input[value='daily']+input")//DAY BOX OLAN YER
     public WebElement repeatEveryLocator;

    //div[class='controls'][data-name='recurrence-summary']>div>span
    @FindBy(xpath = "//div[@class='control-label wrap']/following-sibling::div[@data-name='recurrence-summary']//div//span")
    public WebElement summaryLocator;//EN ALLTTAKI TEXT MESSAGE

    @FindBy(xpath = "//label[@data-role='control-section-switcher']//span[contains(text(),'Weekday')]")
    public WebElement weekdayRadioButtonLocator;

    @FindBy(css = ".validation-failed>span>span")//POP UP MESSAGE
    public WebElement boundyValueAttention;





    public CalendarEventsPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }



    public void createNewEvent() {
        LoginPage loginpage = new LoginPage();

        //    1.Log in as Valid user
        loginpage.login(ConfigurationReader.getProperty("salesmanagerusername"), ConfigurationReader.getProperty("salesmanagerpassword"));

        //    2.Go to Activities -> Calendar Events
        BrowserUtils.navigateToModule(Driver.getDriver(), "Activities", "Calendar Events");
        //    3.Click on create new calendar event
        BrowserUtils.waitForClickablility(createCalendarEventBtn, 20).click();
        BrowserUtils.waitForPageToLoad(20);

    }


    public void pickStartTime(String am_pm, String time) {
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.clickWithJS(startTimeLocator);
        WebElement startTime = Driver.getDriver().findElement(By.xpath("//li[@class='ui-timepicker-" + am_pm + "'][text()='" + time + "']"));
        BrowserUtils.waitForClickablility(startTime, 20).click();
    }

    public void pickEndingTime(String am_pm, String time) {
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.waitPlease(3);
        BrowserUtils.clickWithJS(endTimeLocator);
        WebElement endTime = Driver.getDriver().findElement(By.xpath("//li[@class='ui-timepicker-" + am_pm + "'][contains(text(),'" + time + " ')]"));
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.waitForClickablility(endTime, 20).click();
    }


    public List<String> getRepeatOptions() {
        //we crated select object to work with dropdown
        Select select = new Select(repeatsDailyDropdownLocator);
        //.getOptions(); return all available options in the dropdown.
        //every option is a webelement
        List<WebElement> options = select.getOptions();
        //this is a collection that will store text of every option
        List<String> optionsTextList = new ArrayList<>();
        for (WebElement option : options) {
            //go through every option and retrieve text
            //add that text into collection of text options
            optionsTextList.add(option.getText());
        }
        return optionsTextList;
    }


    public void untilRepeatCheckBox() {

        LoginPage loginpage = new LoginPage();

        //    1.Log in as Valid user
        //    2.Go to Activities -> Calendar Events
        //    3.Click on create new calendar event
        createNewEvent();

        //4. Click on Repeat checkbox
        BrowserUtils.clickOn(Driver.getDriver(), repeatCheckBoxLocator, 20);
    }


    public void boundryValue(String value) {
        // BrowserUtils.waitForPageToLoad(10);
        repeatEveryLocator.clear();
        BrowserUtils.waitPlease(2);
        BrowserUtils.sendKeys(Driver.getDriver(), repeatEveryLocator, 5, value);
        int val = Integer.parseInt(value);

        if (val < 1 || val > 99) {
            System.out.println(boundyValueAttention.getText());
            if (val < 1) {
                Assert.assertTrue(boundyValueAttention.getText().equals("The value have not to be less than 1."));
            } else {
                Assert.assertTrue(boundyValueAttention.getText().equals("The value have not to be more than 99."));
            }
        } else {
            System.out.println(repeatEveryLocator.getAttribute("value"));
            Assert.assertTrue(Integer.parseInt(repeatEveryLocator.getAttribute("value")) == val);
        }

    }

//This method cehck summary box woth valid random values
    public void randomValue(){
        BrowserUtils.waitFor(3);
        int num = (int) (Math.random() * 100 + 1);
        String n = num + "";
        repeatEveryLocator.clear();
        BrowserUtils.sendKeys(Driver.getDriver(),repeatEveryLocator, 10, n);
        repeatEveryLocator.click();
        BrowserUtils.waitFor(3);
        String expected ="";
        if(n.equals("1")){
            expected = "Daily every "+n+" day";
        }else{
            expected = "Daily every "+n+" days";
        }
        System.out.println(summaryLocator.getText());
        Assert.assertEquals(summaryLocator.getText(), expected);
    }





}






















//    public int replaceAllDate(String date){
//        int s=date.indexOf(" ")+1;
//        date=date.replaceAll(date.substring(0,s),"").replaceAll(date.substring(date.indexOf(",")),"");
//        int startDay = Integer.parseInt(date);
//        return  startDay;
//    }
//
//    public int replaceAllTime(String time) {
//        time = time.replaceAll(":", "").replaceAll(time.substring(time.indexOf(" ")), "");
//        int time1 = Integer.parseInt(time);
//        return time1;
//    }






//    @FindBy(css ="label[class='fields-row']>input[checked='checked']" )
//    public WebElement radioButtonLocator;
//
//    @FindBy(css = "label[class='fields-row']>input[value='daily']+input")
//    public WebElement dailyValueLocator;
//
//    @FindBy(xpath = "//div[@class='control-label wrap']/following-sibling::div[@data-name='recurrence-summary']//div//span")
//    public WebElement summaryLocator;
//
//    @FindBy(xpath = "//label[@data-role='control-section-switcher']//span[contains(text(),'Weekday')]")
//    public WebElement weekdayRadioButtonLocator;
//
//    @FindBy(xpath = "//span[@class='validation-failed']//span//span")
//    public WebElement eMessage;
//
//
//    public String getCurrentDay (){
//        //Create a Calendar Object
//        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
//
//        //Get Current Day as a number
//        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
//
//        //Integer to String Conversion
//        String todayStr = Integer.toString(todayInt);
//
//        return todayStr;
//    }
////nn
//    //this method would return collection of repeat options
//
//    public List<String> getRepeatOptions(){
//        //we crated select object to work with dropdown
//        Select select = new Select(repeatsDropdownLocator);
//        //.getOptions(); return all available options in the dropdown.
//        //every option is a webelement
//        List<WebElement> options = select.getOptions();
//        //this is a collection that will store text of every option
//        List<String> optionsTextList = new ArrayList<>();
//        for(WebElement option: options){
//            //go through every option and retrieve text
//            //add that text into collection of text options
//            optionsTextList.add(option.getText());
//        }
//        return  optionsTextList;
//    }
