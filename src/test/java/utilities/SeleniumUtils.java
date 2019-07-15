package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumUtils {
    /**
     * @param expectedResult
     * @param actualResult   Verifies if two strings are equals.
     */
    public static void verifyEquals(String expectedResult, String actualResult) {
        if (expectedResult.equals(actualResult)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
            System.out.println("Expected result: " + expectedResult);
            System.out.println("Actual result: " + actualResult);
        }
    }

    /**
     * This method will put on pause execution
     *
     * @param seconds
     */
    public static void waitPlease(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * @param page
     * @param driver This method will open example page based on link name
     */
    public static void openPage(String page, WebDriver driver) {
        //we will find all examples on the home page
        List<WebElement> listOfExamples = driver.findElements(By.tagName("a"));//=>tag name for hyperlinks is a
        for (WebElement example : listOfExamples) {
            if (example.getText().contains(page)) {
                example.click();
                break;
            }
        }
    }


    /**
     *
     * @param element
     * Thsi method verifies whetheran element is displayed
     */
    public static void verifyIsDisplayed(WebElement element){
        if(element.isDisplayed()){
            System.out.println("Passes");
            System.out.println(element.getText()+" is visible");
        }else{
            System.out.println("Failed");
            System.out.println(element.getText()+" is not visible");
        }

    }





}