package com.moataz.springplaygrounds.springdata.service;

import com.moataz.springplaygrounds.springdata.customexecption.NegativeResult;
import com.moataz.springplaygrounds.springdata.customexecption.ZeroException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CalculatorService {



    public double add(double a, double b) {
        if (b == 0) {
            throw new ZeroException("adding Zero is redundant");
        }
        return a + b;
    }

    public double subtract(double a, double b) {
        if (b > a) {
            throw new NegativeResult("subtracting from a smaller number will result in a negative number");
        }
        return a - b;
    }

    public double multiply(double a, double b) {

        if (b == 0) {
            throw new ZeroException("Multiplying by Zero will result in a zero");
        }
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}
