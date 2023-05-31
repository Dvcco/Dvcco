package com.developer.test.model;

import org.springframework.stereotype.Component;
@Component
public class EmployeeBusiness {

    public double calculateSalaryAnual(double salary){
        return salary * 12;
    }
}
