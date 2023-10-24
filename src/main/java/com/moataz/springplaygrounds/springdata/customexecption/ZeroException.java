package com.moataz.springplaygrounds.springdata.customexecption;

public class ZeroException extends ArithmeticException{
    public ZeroException() {
        super();
    }


    public ZeroException(String s) {
        super(s);
    }
}
