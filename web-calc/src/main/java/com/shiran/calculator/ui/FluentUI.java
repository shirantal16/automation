package com.shiran.calculator.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static java.lang.Thread.sleep;

/**
 * FluentUi is a base class for UI implementations of pages or components.
 */
public class FluentUI {
    private Wait<WebDriver> wait;

    public FluentUI(WebDriver driver){
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(25))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    public Wait<WebDriver> getWait(){
        return wait;
    }

    // after a click action, use pause and wait for the action to be completed
    public void pause(){
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
