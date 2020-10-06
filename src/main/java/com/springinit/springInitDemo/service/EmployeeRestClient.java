package com.springinit.springInitDemo.service;

import com.springinit.springInitDemo.model.Employee;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.springinit.springInitDemo.constants.EmployeeConstants.GET_ALL_EMP_V1;

public class EmployeeRestClient {

    private WebClient webClient;

    public EmployeeRestClient(WebClient webClient) {
        this.webClient = webClient;
    }

    // http://localhost:8081/employeeservice/v1/allEmployees

    public List<Employee> getAllEmployees() {
        return webClient.get().uri(GET_ALL_EMP_V1)
                .retrieve()
                .bodyToFlux(Employee.class)
                .collectList()
                .block();
    }
}
