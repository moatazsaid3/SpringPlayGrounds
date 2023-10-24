package com.moataz.springplaygrounds.springdata.customexecption;

public class NegativeResult extends ArithmeticException{
    public NegativeResult() {
        super();
    }


    public NegativeResult(String s) {
        super(s);
    }
}
