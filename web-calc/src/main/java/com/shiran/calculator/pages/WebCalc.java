package com.shiran.calculator.pages;

import java.util.List;

/**
 * The WebCalc interface is describing the calculator in the web page "https://web2.0calc.com/"
 * and it's functions.
 */
public interface WebCalc {
    // set an expression by using the calculator's buttons
    public WebCalc number(String number);
    public WebCalc operator(String operator);
    public WebCalc function(String function);
    public WebCalc sign();

    // set an expression by using the text box
    public WebCalc setExpression(String expression);

    public String getExpression();
    public WebCalc clearExpression();
    public double calc();
    public List<String> getHistory();
    public WebCalc clearHistory();
}
