package com.shiran.calculator.tests;

import com.shiran.calculator.pages.WebCalc;
import com.shiran.calculator.ui.PopupUI;
import com.shiran.calculator.ui.WebCalcUI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private WebDriver driver;
    private String baseUrl = "https://web2.0calc.com/";
    protected WebCalc webCalc;

    public BaseTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before
    public void beforeTest(){
        driver.get(baseUrl);
        webCalc = new WebCalcUI(driver);
        // cookie consent popup
        try {
            new PopupUI(driver).accept();
        }catch(Exception e){
            System.out.println("Caught exception: " +  e.getMessage());
        }
    }

    @After
    public void afterTest(){
        driver.close();
    }
}
