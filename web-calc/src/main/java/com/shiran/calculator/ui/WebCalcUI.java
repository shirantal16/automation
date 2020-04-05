package com.shiran.calculator.ui;

import com.shiran.calculator.pages.WebCalc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

/**
 * The class WebCalcUI implements the UI of the calculator functions
 * in the web page "https://web2.0calc.com/"
 * As a child of FluentUI it must get a WebDriver object in it's constructor.
 */
public class WebCalcUI extends FluentUI implements WebCalc {
    // locators
    private final static By CALC = By.id("BtnCalc");
    private final static By INPUT = By.id("input");
    private final static By CLEAR = By.id("BtnClear");
    private final static By SIGN = By.id("BtnSign");
    private final static By FLOATING_POINT = By.id("BtnDot");
    private final static By CLEAR_HISTORY = By.id("clearhistory");
    private final static By HISTORY = By.xpath("//*[@id='hist']//*[@class='btn dropdown-toggle pull-right']");
    private final static By HISTORY_LIST = By.xpath("//*[@id='histframe']//ul");
    private final static By HISTORY_ITEM = By.xpath("//*[@id='histframe']//li//p[2]");

    public WebCalcUI(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getExpression() {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(INPUT))
                .getAttribute("value");
    }

    @Override
    public WebCalc setExpression(String expression) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(INPUT)).sendKeys(expression);
        return this;
    }

    @Override
    public WebCalc number(String number) {
        char[] digits = number.toCharArray();
        for (int i = 0 ; i < digits.length ; i++){
            if(digits[i] == '.'){
                clickButton(FLOATING_POINT);
            }else {
                clickButton(By.id("Btn" + digits[i]));
            }
        }
        return this;
    }

    @Override
    public WebCalc operator(String operator) {
        clickButton(By.id(operator));
        return this;
    }

    @Override
    public WebCalc function(String function) {
        clickButton(By.id(function));
        return this;
    }

    @Override
    public WebCalc sign() {
        clickButton(SIGN);
        return this;
    }

    @Override
    public WebCalc clearExpression() {
        clickButton(CLEAR);
        return this;
    }

    @Override
    public double calc() {
        clickButton(CALC);
        return getExpression().equals("") ? 0 : Double.parseDouble(getExpression());
    }

    @Override
    public List<String> getHistory() {
        List<String> historyList = new ArrayList<>();
        clickButton(HISTORY);
        if(getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HISTORY_LIST)).size() > 0) {
            List<WebElement> elements = getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(HISTORY_ITEM));
            for (WebElement element : elements) {
                historyList.add(element.getText());
            }
        }
        return historyList;
    }

    @Override
    public WebCalc clearHistory() {
        clickButton(CLEAR_HISTORY);
        return this;
    }

    private void clickButton(By buttonId) {
        getWait().until(ExpectedConditions.elementToBeClickable(buttonId)).click();
        pause();
    }
}
