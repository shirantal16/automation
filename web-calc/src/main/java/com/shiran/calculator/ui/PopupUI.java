package com.shiran.calculator.ui;

import com.shiran.calculator.pages.Popup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PopupUI extends FluentUI implements Popup {
    // locators
    private final static By ACCEPT = By.id("cookieconsentallowall");
    private final static By CONFIGURE = By.id("cookieconsentsettings");

    public PopupUI(WebDriver driver) {
        super(driver);
    }

    @Override
    public void accept() {
        getWait().until(ExpectedConditions.elementToBeClickable(ACCEPT)).click();
    }

    @Override
    public void configure() {
        getWait().until(ExpectedConditions.elementToBeClickable(CONFIGURE)).click();
    }
}
