package com.developer.test.controller;

import com.developer.test.dto.EmployeConsult;
import com.developer.test.dto.EmployeDto;
import com.developer.test.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getemployee")
    public EmployeDto getEmployesss() throws IOException {
        return employeeService.getEmployees();
    }

    @GetMapping("/findemployeebyid/{id}")
    public EmployeConsult getFindEmployeById(@PathVariable Integer id) throws IOException {
        return  employeeService.getFindByIdEmploye(id);
    }

}
