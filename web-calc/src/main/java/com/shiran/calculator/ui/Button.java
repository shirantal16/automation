package com.shiran.calculator.ui;

/**
 * The Button enum provides locator ids for operators and function buttons
 */
public enum Button {
    // operators
    PLUS("BtnPlus"),
    MINUS("BtnMinus"),
    MULTI("BtnMult"),
    DIV("BtnDiv"),

    // function buttons
    SIN("BtnSin"),
    COS("BtnCos"),
    TAN("BtnTan"),
    SINH("BtnSinH"),
    COSH("BtnCosH"),
    TANH("BtnTanH"),
    COT("BtnCot"),
    SEC("BtnSec"),
    CSC("BtnCsc");

    Button(String locatorId){
        this.locatorId = locatorId;
    }

    String locatorId;

    public String getLocatorId(){
        return this.locatorId;
    }
}
