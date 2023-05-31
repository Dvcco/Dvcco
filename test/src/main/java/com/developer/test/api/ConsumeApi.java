package com.developer.test.api;

import com.developer.test.dto.EmployeConsult;
import com.developer.test.dto.EmployeDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
public interface ConsumeApi {

    @GET("employee/{id}")
    Call<EmployeConsult> getFindEmployeeById(@Path("id") Integer id);

    @GET("employees")
    Call<EmployeDto> getEmployesss();
    @GET("employee/{id}")
    Call<EmployeDto> getFindEmployeeBy(@Path("id") Integer id);
}
