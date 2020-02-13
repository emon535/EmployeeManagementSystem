package com.emon535.emplmanagement.dao;

import com.emon535.emplmanagement.model.Employee;
import com.sun.tools.jconsole.JConsoleContext;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDTO {
    int insertEmployee(Employee employee);

    List<Employee> selectAllEmployee();

    Optional<Employee> selectEmployeeById(UUID id);
    Optional<Employee> selectEmployeeByName(String name);
    Optional<Employee> selectEmployeeByEmail(String email);
    Optional<Employee> selectEmployeeByContactNumber(Integer contactNumber);
    int updateEmployeeById(UUID id, Employee employee);
    int deleteEmployeeById(UUID id);

}
