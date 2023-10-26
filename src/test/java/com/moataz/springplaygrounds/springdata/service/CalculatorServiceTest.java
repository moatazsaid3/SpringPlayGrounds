package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.customexecption.NegativeResult;
import com.moataz.springplaygrounds.springdata.customexecption.ZeroException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    // AAA -> Arrange -> Action -> Assert
    private CalculatorService calculatorService = new CalculatorService();


    @Test
    public void CalculatorService_Add_ReturnSumOfTwoNumbers() {
        //Arrange
        double a = 10.0;
        double b = 5.0;
        double expected = 15.0;
        //Action
        double actual = calculatorService.add(a, b);
        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void CalculatorService_Add_ThrowExceptionWhenAddingZero() {

        double a = 10.0;
        double b = 0.0;
        Assertions.assertThrows(ZeroException.class, () -> {
            calculatorService.add(a, b);
        });
    }
    @Test
    public void CalculatorService_Subtract_ReturnTheSubtractionOfTwoNumbers() {
        double a = 10.0;
        double b = 5.0;
        double expected = 5.0;
        double actual = calculatorService.subtract(a, b);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void CalculatorService_Add_ThrowExceptionWhenSubtractingABiggerNumber() {

        double a = 10.0;
        double b = 15.0;
        Assertions.assertThrows(NegativeResult.class, () -> {
            calculatorService.subtract(a, b);
        });
    }
    @Test
    public void CalculatorService_Multiply_ReturnTheMultiplicationOfTwoNumbers() {
        double a = 10.0;
        double b = 5.0;
        double expected = 50.0;
        double actual = calculatorService.multiply(a, b);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void CalculatorService_Add_ThrowExceptionWhenMultiplyingByZero() {

        double a = 10.0;
        double b = 0.0;
        Assertions.assertThrows(ZeroException.class, () -> {
            calculatorService.multiply(a, b);
        });
    }
    @Test
    public void CalculatorService_Division_ReturnTheDivisionOfTwoNumbers() {
        double a = 10.0;
        double b = 5.0;
        double expected = 2.0;
        double actual = calculatorService.divide(a, b);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void CalculatorService_Divide_ThrowExceptionWhenDividedByZero() {
        double a = 10.0;
        double b = 0.0;
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculatorService.divide(a, b);
        });
    }

}
