package com.shiran.calculator.tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class WebCalcTest extends BaseTest {
    List<String> history = new ArrayList<>();

    @Test
    public void test(){
        boolean result1 = testExpression("2+3", 5);
        boolean result2 = testExpression("10-2", 8);
        boolean result3 = !testExpression("(10-2)*2", 20);
        boolean result4 = testExpression("sin(30)", 0.5);
        // the list is ordered from last action to first
        Collections.reverse(history);
        boolean result5 = webCalc.getHistory().equals(history);
        assertTrue(result1 && result2 && result3 && result4 && result5);
    }

    // testExpression method is using the calculator's text-box to set an expression.
    // (WebCalc interface also provides buttons functionality to set an expression)
    public boolean testExpression(String expression, double expected) {
        double result = webCalc.setExpression(expression).calc();
        webCalc.clearExpression();
        history.add(expression);
        return result == expected;
    }
}
