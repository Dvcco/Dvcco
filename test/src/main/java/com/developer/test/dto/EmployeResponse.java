package com.developer.test.dto;

import lombok.*;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeResponse {
    private Integer id;
    private String employee_name;
    private Double employee_salary;
    private Integer employee_age;
    private String profile_image;
}
