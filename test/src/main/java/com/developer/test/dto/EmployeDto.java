package com.developer.test.dto;

import lombok.*;
import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeDto {
    private String status;
    private List<EmployeResponse> data;
    private String message;
}
