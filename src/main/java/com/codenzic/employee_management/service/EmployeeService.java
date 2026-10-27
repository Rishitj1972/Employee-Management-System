package com.codenzic.employee_management.service;

import com.codenzic.employee_management.dto.EmployeeRequest;
import com.codenzic.employee_management.dto.EmployeeResponse;
import com.codenzic.employee_management.entity.Employee;
import com.codenzic.employee_management.exception.EmployeeNotFoundException;
import com.codenzic.employee_management.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponse createEmployee(EmployeeRequest request) {

        Employee employee = new Employee(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getDepartment()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeResponse(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartment()
        );
    }

    public Page<EmployeeResponse> getAllEmployee(int page, int size) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by("id").ascending()
        );

        Page<Employee> employees = employeeRepository.findAll(pageable);


        return employees.map(employee ->
                new EmployeeResponse(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmail(),
                        employee.getDepartment()
                ));
    }

    public EmployeeResponse getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found with id "+id
                ));

        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment()
        );
    }

    public EmployeeResponse updateEmployee(Long id,EmployeeRequest request) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found with "+id
                ));

        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setEmail(request.getEmail());
        employee.setDepartment(request.getDepartment());

        Employee updatedEmployee = employeeRepository.save(employee);

        return new EmployeeResponse(
                updatedEmployee.getId(),
                updatedEmployee.getFirstName(),
                updatedEmployee.getLastName(),
                updatedEmployee.getEmail(),
                updatedEmployee.getDepartment()
        );
    }

    public void deleteEmployee(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(
                        "Employee not found with id "+id
                ));

        employeeRepository.delete(employee);
    }
}
