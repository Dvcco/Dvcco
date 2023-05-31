package com.developer.test.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeConsult {
    private String status;
    private EmployeResponse data;
    private String message;
}
