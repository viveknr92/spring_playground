package com.springinit.springInitDemo;

import com.springinit.springInitDemo.model.Employee;
import com.springinit.springInitDemo.service.EmployeeRestClient;
import org.junit.jupiter.api.Test;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class EmployeeRestClientTest {
    private final String baseUrl = "http://localhost:8081/employeeservice";
    private WebClient webClient = WebClient.create(baseUrl);
    EmployeeRestClient employeeRestClient = new EmployeeRestClient(webClient);

    @Test
    void getAllEmployees() {
        List<Employee> employeeList = employeeRestClient.getAllEmployees();
        assertTrue(employeeList.size() > 0);
        Employee employee = employeeList.get(0);
        assertEquals("Chris", employee.getFirstName());
    }

}
