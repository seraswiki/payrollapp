package com.example.payroll;

import org.assertj.core.internal.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PayrollApplicationIntegrationTests {
	@Autowired
	private MockMvc mvc;

	@MockBean
	EmployeeService employeeService;

	@Test()
	void testGetEmployeesSuccess() throws Exception {
		when(employeeService.getAll()).thenReturn(createMockEmployeeList());
		mvc.perform(get("/employees")
//		mvc.perform(post("/employees")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
//				.andExpect((ResultMatcher) content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//				.andExpect(jsonPath("$[0].name", is("Bilbo Baggins")));
	}

	private List<Employee> createMockEmployeeList() {
		List<Employee> employeeList = new ArrayList<>();

		Employee e1 = new Employee();
		e1.setId(1L);
		e1.setName("Seras");
		e1.setRole("Admin");

		employeeList.add(e1);

		return employeeList;
	}

//	@Test(expected=ArrayIndexOutOfBoundsException.class)
//	void testGetEmployeesFail() throws Exception {
//		mvc.perform(get("/employees")
//		mvc.perform(post("/employees")
//				.contentType(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk());
//				.andExpect((ResultMatcher) content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//				.andExpect(jsonPath("$[0].name", is("Bilbo Baggins")));
//	}

}
