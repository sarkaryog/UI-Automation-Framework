package com.qdpm.operations.utility;

import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CommonMethods {

    /**
     * This method is useful for getting dropdown options as list for compare
     * @param element
     * @return
     */
    @SneakyThrows
    public List<String> getDropDownOptionAsList(WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        List<String> actualContets = new ArrayList<String>();

        for (WebElement ref : options) {
            actualContets.add(ref.getText());
        }
        return actualContets;
    }

    /**
     * This method is useful for selecting values from dropdown by using visible text
     * @param element
     * @param value
     */
    @SneakyThrows
    public void selectDropDownOptions(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    /**
     * This method is useful for selecting radio button
     * @param elements
     * @param value
     */
    @SneakyThrows
    public void selectRadioButtonOption(List<WebElement> elements, String value) {
        for (WebElement ref : elements) {
            if (ref.getText().equalsIgnoreCase(value)) {
                ref.click();
                break;
            }
        }
    }

    /**
     * This method is useful for selecting multiple values from checkboxes
     * @param elements
     * @param value
     */
    @SneakyThrows
    public void selectCheckBoxValues(List<WebElement> elements, List<String> value) {
        for (String str : value) {
            for (WebElement ref : elements) {
                if (ref.getText().equalsIgnoreCase(str)) {
                    ref.click();
                    break;
                }
            }
        }
    }



}
