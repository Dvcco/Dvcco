package com.developer.test.service;

import com.developer.test.api.ConsumeApi;
import com.developer.test.dto.EmployeConsult;
import com.developer.test.dto.EmployeDto;
import com.developer.test.dto.EmployeResponse;
import com.developer.test.model.EmployeeBusiness;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private ConsumeApi consumeApi;
    @Autowired
    private EmployeeBusiness employeeBusiness;

    public EmployeDto getEmployees() throws IOException {
        Call<EmployeDto> callEmployee = consumeApi.getEmployesss();
        Response<EmployeDto> response = callEmployee.execute();
        if (response.isSuccessful()) {
            EmployeDto employeeResponse = response.body();
            List<EmployeResponse> employees = employeeResponse.getData();
            employees.forEach(employee -> {
                double annualSalary = employeeBusiness.calculateSalaryAnual(employee.getEmployee_salary());
                employee.setEmployee_salary(annualSalary);
            });
            return employeeResponse;
        } else {
            throw new IOException("Error consumiendo api listar empleados: " + response.message());
        }
    }
    public EmployeConsult getFindByIdEmploye(Integer id) throws IOException {
        Call<EmployeConsult> callEmployees = consumeApi.getFindEmployeeById(id);
        Response<EmployeConsult> listResponse = callEmployees.execute();
        if (listResponse.isSuccessful()) {
            EmployeConsult employee = listResponse.body();
            EmployeResponse employess = employee.getData();
            double annualSalary = employeeBusiness.calculateSalaryAnual(employess.getEmployee_salary());
            employess.setEmployee_salary(annualSalary);
            return employee;
        } else {
            throw new IOException("Error buscando el empleado: " + listResponse.message());
        }
    }
}
