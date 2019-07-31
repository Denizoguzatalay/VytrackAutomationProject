package com.vytrack.tests.components.activities;

import com.vytrack.pages.activities.CalendarEventsPage;
import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class CalendarEventsTest extends TestBase {


    @Test
    public void CalenderEventsTests1() {

        CalendarEventsPage cep = new CalendarEventsPage();
        LoginPage loginpage = new LoginPage();

        //    1.Log in as Valid user
        //    2.Go to Activities -> Calendar Events
        //    3.Click on create new calendar event
        cep.createNewEvent();

        //    4.Change the start date to future date
        cep.startDateLocator.clear();
        BrowserUtils.sendKeys(Driver.getDriver(), cep.startDateLocator, 20, "Aug 8, 2019");

        //  5.Verify that end date changes to the same date
        Assert.assertEquals(cep.startDateLocator.getText(), cep.endDateLocator.getText());

        // 6.Change back the start date to today’s date
        cep.startDateLocator.clear();
        BrowserUtils.clickWithJS(cep.todayDateButtonLocator);

        // 7.Verify that end date changes back to today’s date
        Assert.assertEquals(cep.startDateLocator.getText(), cep.endDateLocator.getText());

    }


    @Test
    public void CalenderEventsTests2() {

        CalendarEventsPage cep = new CalendarEventsPage();
        LoginPage loginpage = new LoginPage();

        //    1.Log in as Valid user
        //    2.Go to Activities -> Calendar Events
        //    3.Click on create new calendar event
        cep.createNewEvent();

        //4. Change the start time to any other time

        BrowserUtils.waitPlease(3);
        cep.startTimeLocator.click();
        BrowserUtils.waitPlease(3);
        List<WebElement> times =driver.findElements(By.cssSelector("li[class*='ui-timepicker']"));
        String desiredTime = "6:30 PM";
        for (WebElement each : times) {
            if (each.getText().equals(desiredTime)){
                each.click();
                break;
            }
        }
        //5. Verify that end time changes exactly 1 hours later
        BrowserUtils.waitForVisibility( cep.endTimeLocator,15);

        String start= cep.startTimeLocator.getAttribute("value").replaceAll("[^\\d]", "" );
        String end= cep.endTimeLocator.getAttribute("value").replaceAll("[^\\d]", "" );

        int startT=Integer.parseInt(start);
        int endT=Integer.parseInt(end);

        System.out.println(startT);
        System.out.println(endT);
        Assert.assertTrue(endT-startT==100);


    }


    @Test
    public void CalenderEventsTests3() {

        CalendarEventsPage cep = new CalendarEventsPage();
        LoginPage loginpage = new LoginPage();

        //1. Log in as Valid user
        //2. Go to Activities -> Calendar Events
        //3. Click on create new calendar event
        cep.createNewEvent();

        //4. Change the start time to 11.30 PM
        cep.pickStartTime("pm","11:30 PM");

        //5. Verify that end date shows tomorrows date
        BrowserUtils.waitForVisibility(cep.startDateLocator,20);
        String start= cep.startDateLocator.getAttribute("value").replaceAll("[^\\d]", "" );
        System.out.println(start);
        int starttime = Integer.parseInt(start);

        BrowserUtils.waitForVisibility(cep.endDateLocator,20);
        String end= cep.endDateLocator.getAttribute("value").replaceAll("[^\\d]", "" );
        System.out.println(end);
        int endtime = Integer.parseInt(end);

        System.out.println(endtime-starttime);
        Assert.assertTrue(endtime-starttime==10000);

        //    6.Verify that end time is 12:30 AM

        //6. Verify that end time is 12:30 AM
        System.out.println( cep.endTimeLocator.getAttribute("value"));
        Assert.assertEquals(cep.endTimeLocator.getAttribute("value"),"12:30 AM");


    }



//////////////////////////////////////////////////////////////////////////////


    //1)Daily repeat option, Repeat every, summary
    @Test
    public void CalenderEventsTests4() {



        CalendarEventsPage cep = new CalendarEventsPage();

        //1. Log in as Valid user
        //2. Go to Activities -> Calendar Events
        //3. Click on create new calendar event
        //4. Click on Repeat checkbox
        //5. Verify that Daily is selected by default
        //6. Verify day(s) checkbox is selected and default value is 1
        //7. Verify summary says Daily every 1 day
        CalenderEventsTests5(); //Tests5 is being called here

        //8. Check the weekday checkbox
        cep.weekdayRadioButtonLocator.click();

        //9. Verify that days input now disabled
        Assert.assertTrue(cep.repeatEveryLocator.isEnabled()==false);

        //10. Verify summary says Daily every weekday
        Assert.assertTrue(cep.summaryLocator.getText().equals("Daily, every weekday"));
   }


    //2) Daily repeat option, Repeat every, default values
    @Test
    public void CalenderEventsTests5() {

        CalendarEventsPage cep = new CalendarEventsPage();

        //1.Log in as Valid user
        //2.Go to Activities -> Calendar Events
        //3.Click on create new calendar event
        //4. Click on Repeat checkbox
        cep.untilRepeatCheckBox();

        //5. Verify that Daily is selected by default
        Assert.assertTrue(cep.getRepeatOptions().get(0).equals("Daily"));

        //6. Verify day(s) checkbox is selected and default value is 1
        //Assert.assertTrue(cep.repeatEveryRadioButtonLocator.isEnabled());
        Assert.assertTrue(cep.repeatEveryLocator.getAttribute("value").equals("1"));

        //7. Verify summary says Daily every 1 day
        Assert.assertTrue(cep.summaryLocator.getText().equals("Daily every 1 day"));

    }


    //3)Daily repeat option, Repeat everyday(s), error messages
    @Test
    public void CalenderEventsTests6() {

        CalendarEventsPage cep = new CalendarEventsPage();

        //1.Log in as Valid user
        //2.Go to Activities -> Calendar Events
        // 3.Click on create new calendar event
        //4. Click on Repeat checkbox
        cep.untilRepeatCheckBox();

        //5.Test the day(s) input entering different values(boundary value analysis)
        cep.boundryValue("30");
        cep.boundryValue("10");
        cep.boundryValue("97");

        //6.Verify error messages The value have not to be less than 1.
        cep.boundryValue("0");

//    andThe value have not to be more than 99.occur when values are too big or small
//    7.Verify that error messages disappear when valid values are enter


    }

    //4)Daily repeat option, Repeat everyday(s), functionality
    @Test
    public void CalenderEventsTests7() {

        CalendarEventsPage cep = new CalendarEventsPage();

        //1.Log in as Valid user
        //2.Go to Activities -> Calendar Events
        // 3.Click on create new calendar event
        //4. Click on Repeat checkbox
        cep.untilRepeatCheckBox();

        //5.Enter random value to the day(s) field
        //6.Verify that Summary says Daily every<random number>day
        cep.randomValue();
        //7.Enter another random value to the day(s) field
        //8.Verify that Summary updated withDaily every<random number>day
        cep.randomValue();

    }


    //    5) Daily repeat option, blank fields

    @Test
    public void CalenderEventsTests8() {

        CalendarEventsPage cep = new CalendarEventsPage();

        //1.Log in as Valid user
        //2.Go to Activities -> Calendar Events
        // 3.Click on create new calendar event
        //4. Click on Repeat checkbox
        cep.untilRepeatCheckBox();

        //5. Clear the value of the day(s) field
        cep.repeatEveryLocator.clear();
        //6. Message This value should not be blank. should come up
        System.out.println(cep.boundyValueAttention.getText());
        String expected="This value should not be blank.";
        Assert.assertEquals(cep.boundyValueAttention.getText(), expected);

        //7. Enter a valid value to the day(s) field the
        int num = (int) (Math.random() * 100 + 1);
        String n = num + "";
        BrowserUtils.sendKeys(Driver.getDriver(),cep.repeatEveryLocator, 10, n);
        cep.repeatEveryLocator.click();

//!!!!!!!!!!!!!!8. Message This value should not be blank. should disappear
        try {
           cep.boundyValueAttention.isDisplayed();
            System.out.println("Failed");
        }
        catch (NoSuchElementException e) {
            System.out.println("passed");
        }
        //Assert.assertFalse(cep.boundyValueAttention.getText().equals(expected));

        BrowserUtils.waitPlease(3);
        //9. Clear the value of the After occurrences field
        cep.repeatEveryLocator.clear();

        //10. Message This value should not be blank. should come up

        // 11. Enter a valid value to the After occurrences field the

        //12. Message This value should not be blank. should disappear

    }

    //6) Daily repeat option, Ends, error messages
    @Test
    public void CalenderEventsTests9() {

        CalendarEventsPage cep = new CalendarEventsPage();

        //1.Log in as Valid user
        //2.Go to Activities -> Calendar Events
        // 3.Click on create new calendar event
        //4. Click on Repeat checkbox
        cep.untilRepeatCheckBox();

        //5. Test the After occurrences input entering different values (boundary value analysis)
        //6. Verify error messages The value have not to be less than 1. and
        // The value have not to be  more than 99. occur when values are too big or small
        cep.boundryValue("0");
        cep.boundryValue("1");
        cep.boundryValue("99");
        cep.boundryValue("100");

        //7. Verify that error messages disappear when valid values are entered
    }


    //7) Daily repeat option, Ends, functionality
    @Test
    public void CalenderEventsTests10() {

        CalendarEventsPage cep = new CalendarEventsPage();

        //1.Log in as Valid user
        //2.Go to Activities -> Calendar Events
        // 3.Click on create new calendar event
        //4. Click on Repeat checkbox
        cep.untilRepeatCheckBox();

        //5. Enter random value to the After occurrences field


//        5. Enter random value to the After occurrences field
//        6. Verify that Summary says Daily every <random number> day
//        7. Enter another random value to the After occurrences field
//        8. Verify that Summary updated with Daily every <random number> day
//
//


        //Date andTimeTests

//    1.Log in as Valid user
//    2.Go to Activities -> Calendar Events
//    3.Click on create new calendar event
//    4.Change the start date to future date
//    5.Verify that end date changes to the same date
//    6.Change back the start date to today’s date
//    7.Verify that end date changes back to today’s date


//    1Log in as Valid user
//    2.Go to Activities -> Calendar Events
//    3.Click on create new calendar event
//    4.Change the start time to any other time
//    5.Verify that end time changes exactly 1 hours later


//    Log in as Valid user
//    2.Go to Activities -> Calendar Events
//    3.Click on create new calendar event
//    4.Change the start time to 11.30 PM
//    5.Verify that end date shows tomorrows date
//    6.Verify that end time is 12:30 AM


        // Daily Repeat Tests

//1. Log in as Valid user
//2. Go to Activities -> Calendar Events
//3. Click on create new calendar event
//4. Click on Repeat checkbox
//5. Verify that Daily is selected by default
//6. Verify day(s) checkbox is selected and default value is 1
//7. Verify summary says Daily every 1 day
//8. Check the weekday checkbox
//9. Verify that days input now disabled
//10. Verify summary says Daily every weekday


//    3)Daily repeat option, Repeat everyday(s), error messages
//    1.Log in as Valid user
//    2.Go to Activities -> Calendar Events
//    3.Click on create new calendar event
//    4.Click on Repeat checkbox
//    5.Test the day(s) inputentering different values(boundary value analysis)
//    6.Verify error messagesThe value have not to be less than 1.
//    andThe value have not to be more than 99.occur when values are too big or small
//    7.Verify that error messages disappear when valid values are entere

    }}