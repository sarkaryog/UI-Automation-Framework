package com.qdpm.operations.utility;

import com.aventstack.extentreports.Status;
import com.qdpm.operations.base.DriverFactory;
import com.qdpm.operations.base.ExtentFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

/**
 * This class can be used as customize action on web element
 */
public class ActionDriver {

    /**
     * This method is useful to type on text box fields
     *
     * @param element
     * @param elementName
     * @param value
     */
    public void type(WebElement element, String elementName, String value) {
        try {
            element.clear();
            element.sendKeys(value);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Successfully typed on " + elementName + " with value " + value);

        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to typed on " + elementName + " with value " + value + " due to Exception " + e);
        }


    }

    /**
     * This method is useful on click on any element such as link, radio button, checkboxes
     *
     * @param element
     * @param elementName
     */
    public void click(WebElement element, String elementName) {
        try {
            element.click();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Successfully clicked on " + elementName);

        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to click on " + elementName + " due to Exception " + e);
        }

    }


    /**
     * This method is useful for clearing text box fields
     *
     * @param element
     * @param elementName
     */
    public void clear(WebElement element, String elementName) {
        try {
            element.clear();
            Thread.sleep(250);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Data Cleared Successfully on " + elementName);
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to clear Data on field: " + elementName + " due to exception: " + e);

        }
    }

    /**
     * This method is useful for moved cursor to required element name
     *
     * @param element
     * @param elementName
     */
    public void moveToElement(WebElement element, String elementName) {
        try {
            JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
            executor.executeScript("arguments[0].scrollIntoView(true);", element);
            Actions actions = new Actions(DriverFactory.getInstance().getDriver());
            actions.moveToElement(element).build().perform();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Mouse hovered Successfully on " + elementName);
            Thread.sleep(1000);
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to hover mouse on field: " + elementName + " due to exception: " + e);

        }
    }


    /**
     * This method is useful to check element is visible on webpage or not
     *
     * @param element
     * @param elementName
     * @return
     */
    public boolean isElementPresent(WebElement element, String elementName) {
        boolean flag = false;
        try {
            flag = element.isDisplayed();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, elementName + " Presence of field is: " + flag);
            return flag;
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, elementName + " is not present on web page, due to exception: " + e);
            return flag;
        }
    }


    /**
     * This method is useful for selecting dropdown values by using visible text
     *
     * @param element
     * @param elementName
     * @param ddVisibleText
     */
    public void selectDropDownByVisibleText(WebElement element, String elementName, String ddVisibleText) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(ddVisibleText);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Dropdown Value Selected for " + elementName + " by visible text: " + ddVisibleText);
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown value not selected for field: " + elementName + "  due to exception: " + e);
        }
    }

    /**
     * This method is useful for selecting dropdown value by using value
     *
     * @param element
     * @param elementName
     * @param ddValue
     */
    public void selectDropDownByValue_custom(WebElement element, String elementName, String ddValue) {
        try {
            Select s = new Select(element);
            s.selectByValue(ddValue);
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Dropdown Value Selected from " + elementName + " by visible text: " + ddValue);
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Dropdown Value not Selected from " + elementName + " by visible text: " + ddValue + "  due to exception: " + e);
        }
    }

    /**
     * This method is useful for asserting two string values
     *
     * @param expValue
     * @param actualValue
     * @param locatorName
     */
    public void assertEqualsString(String expValue, String actualValue, String locatorName) {
        try {
            if (actualValue.equals(expValue)) {
                ExtentFactory.getInstance().getExtent().log(Status.PASS, "String Assertion is successful on field " + locatorName + " Expected value was: " + expValue + " actual value is: " + actualValue);
            } else {
                ExtentFactory.getInstance().getExtent().log(Status.FAIL, "String Assertion FAILED on field " + locatorName + " Expected value was: " + expValue + " actual value is: " + actualValue);
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            Assert.assertTrue(false, e.toString());
        }
    }

    /**
     * This method is use ful for retrieving text from any web element
     *
     * @param element
     * @param elementName
     * @return
     */
    public String getText(WebElement element, String elementName) {
        String text = "";
        try {
            text = element.getText();
            ExtentFactory.getInstance().getExtent().log(Status.PASS, "Text retrieved from :" + elementName + " is" + text);
            return text;
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Not able to retrieved text from :" + elementName + " due to " + e);

        }
        return text;
    }

    /**
     * This method is useful for selecting radio button
     *
     * @param elements
     * @param value
     */
    @SneakyThrows
    public void selectRadioButtonOption(List<WebElement> elements, String value) {
        try {
            for (WebElement ref : elements) {
                if (ref.getText().equalsIgnoreCase(value)) {
                    ref.click();
                    ExtentFactory.getInstance().getExtent().log(Status.PASS, "Successfully select radio button");
                    break;
                }
            }
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Unable to select radio button due to " + e);
        }

    }

    /**
     * This method is useful for selecting multiple values from checkboxes
     *
     * @param elements
     * @param value
     */
    @SneakyThrows
    public void selectCheckBoxValues(List<WebElement> elements, List<String> value) {
        try {
            for (String str : value) {
                for (WebElement ref : elements) {
                    if (ref.getText().equalsIgnoreCase(str)) {
                        ref.click();
                        ExtentFactory.getInstance().getExtent().log(Status.PASS, "Successfully select checkbox for " + value);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            ExtentFactory.getInstance().getExtent().log(Status.FAIL, "Not able to select checkbox due to " + e);
        }

    }


}
