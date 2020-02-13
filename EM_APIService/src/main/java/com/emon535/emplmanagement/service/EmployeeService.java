package com.emon535.emplmanagement.service;

import com.emon535.emplmanagement.dao.EmployeeDTO;
import com.emon535.emplmanagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeDTO employeeDTO;

    @Autowired
    public EmployeeService(@Qualifier("inMemoryArray") EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }


    public int addEmployee(Employee employee) {
        return employeeDTO.insertEmployee(employee);
    }

    public List<Employee> getAllEmployee(){
        return  employeeDTO.selectAllEmployee();
    }

    public Optional<Employee> getEmployeeById(UUID id){
        return employeeDTO.selectEmployeeById(id);
    }

    public Optional<Employee> getEmployeeByName(String name){
        return employeeDTO.selectEmployeeByName(name);
    }

    public Optional<Employee> getEmployeeByEmail(String email){
        return employeeDTO.selectEmployeeByEmail(email);
    }

    public Optional<Employee> getEmployeeByContactNumber(Integer contactNumber){
        return employeeDTO.selectEmployeeByContactNumber(contactNumber);
    }

    public int deleteEmployeeById(UUID id){
        return employeeDTO.deleteEmployeeById(id);
    }

    public int updateEmployeeById(UUID id, Employee newEmployee){
        return employeeDTO.updateEmployeeById(id, newEmployee);
    }
}
