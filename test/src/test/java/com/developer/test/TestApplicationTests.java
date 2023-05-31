package com.developer.test;

import com.developer.test.api.ConsumeApi;
import com.developer.test.dto.EmployeConsult;
import com.developer.test.dto.EmployeDto;
import com.developer.test.dto.EmployeResponse;
import com.developer.test.model.EmployeeBusiness;
import com.developer.test.service.EmployeeService;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class TestApplicationTests {

	@Mock
	private ConsumeApi consumeApi;

	@Mock
	private EmployeeBusiness employeeBusiness;

	@InjectMocks
	private EmployeeService employeeService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void whenGetEmployeThenSuccessfulResponse() throws IOException {
		EmployeDto mockEmployeeDto = new EmployeDto();
		List<EmployeResponse> listEmploye = new ArrayList<>();
		listEmploye.add(new EmployeResponse(1,"John Doe", 5000D, 25 ,"profile"));
		mockEmployeeDto.setData(listEmploye);
		Call<EmployeDto> mockCall = mock(Call.class);
		Mockito.when(consumeApi.getEmployesss()).thenReturn(mockCall);
		Response<EmployeDto> mockResponse = Response.success(mockEmployeeDto);
		Mockito.when(mockCall.execute()).thenReturn(mockResponse);
		Mockito.when(employeeBusiness.calculateSalaryAnual(5000)).thenReturn(60000.0);
		EmployeDto result = employeeService.getEmployees();
		verify(consumeApi).getEmployesss();
		verify(mockCall).execute();
		verify(employeeBusiness).calculateSalaryAnual(5000);
		assertNotNull(result);
		assertEquals(1, result.getData().size());
		assertEquals("John Doe", result.getData().get(0).getEmployee_name());
		assertEquals(60000, result.getData().get(0).getEmployee_salary());
	}

	@Test
	void whenGetEmployeThenUnsuccessfulResponse() throws IOException {
		Call<EmployeDto> mockCall = mock(Call.class);
		Mockito.when(consumeApi.getEmployesss()).thenReturn(mockCall);
		Response<EmployeDto> mockResponse = Response.error(404, ResponseBody.create(null, "Error consumiendo api listar empleados: Error message"));
		Mockito.when(mockCall.execute()).thenReturn(mockResponse);
		assertThrows(IOException.class, () -> employeeService.getEmployees());
		verify(consumeApi).getEmployesss();
		verify(mockCall).execute();
		verifyZeroInteractions(employeeBusiness);
	}

	@Test
	void testGetFindByIdEmploye_SuccessfulResponse() throws IOException {
		int employeeId = 1;
		EmployeConsult mockEmployeeConsult = new EmployeConsult();
		EmployeResponse mockEmployess = new EmployeResponse(1,"John Doe", 5000D, 25 ,"profile");
		mockEmployeeConsult.setData(mockEmployess);
		Call<EmployeConsult> mockCall = mock(Call.class);
		when(consumeApi.getFindEmployeeById(employeeId)).thenReturn(mockCall);
		Response<EmployeConsult> mockResponse = Response.success(mockEmployeeConsult);
		when(mockCall.execute()).thenReturn(mockResponse);
		when(employeeBusiness.calculateSalaryAnual(5000)).thenReturn(60000.0);
		EmployeConsult result = employeeService.getFindByIdEmploye(employeeId);
		verify(consumeApi).getFindEmployeeById(employeeId);
		verify(mockCall).execute();
		verify(employeeBusiness).calculateSalaryAnual(5000);
		assertNotNull(result);
		assertEquals("John Doe", result.getData().getEmployee_name());
		assertEquals(60000, result.getData().getEmployee_salary());
	}

	@Test
	void testGetFindByIdEmploye_UnsuccessfulResponse() throws IOException {
		int employeeId = 1;
		Call<EmployeConsult> mockCall = mock(Call.class);
		when(consumeApi.getFindEmployeeById(employeeId)).thenReturn(mockCall);
		Response<EmployeConsult> mockResponse = Response.error(404, ResponseBody.create(null, "Error consumiendo api listar empleados: Error message"));
		when(mockCall.execute()).thenReturn(mockResponse);
		assertThrows(IOException.class, () -> employeeService.getFindByIdEmploye(employeeId));
		verify(consumeApi).getFindEmployeeById(employeeId);
		verify(mockCall).execute();
		verifyZeroInteractions(employeeBusiness);
	}
}
