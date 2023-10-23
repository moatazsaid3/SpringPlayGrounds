package com.moataz.springplaygrounds.springdata.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class CalculatorServiceTest {

    // AAA -> Arrange -> Action -> Assert
    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void InstructorRepository_FindALL_ReturnMoreThanOneInstructor() {
        double a = 10.0;
        double b = 5.0;
        double expected = 15.0;
        double actual = calculatorService.add(a, b);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void CalculatorService_Add_ReturnSumOfTwoNumbers() {
        double a = 10.0;
        double b = 5.0;
        double expected = 15.0;
        double actual = calculatorService.add(a, b);
        Assertions.assertEquals(expected, actual);
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
    public void CalculatorService_Multiply_ReturnTheMultiplicationOfTwoNumbers() {
        double a = 10.0;
        double b = 5.0;
        double expected = 50.0;
        double actual = calculatorService.multiply(a, b);
        Assertions.assertEquals(expected, actual);
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
