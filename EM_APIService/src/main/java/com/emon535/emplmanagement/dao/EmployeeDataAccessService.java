package com.emon535.emplmanagement.dao;

import com.emon535.emplmanagement.model.Employee;
import org.springframework.stereotype.Repository;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("inMemoryArray")
public class EmployeeDataAccessService implements EmployeeDTO {
    private static List<Employee> DB = new ArrayList<>();


    @Override
    public int insertEmployee(Employee employee) {
        UUID id= UUID.randomUUID();
        System.out.println(id);
        employee.setId(id);
        DB.add(employee);
        return 1;
    }


    @Override
    public List<Employee> selectAllEmployee() {
        return DB;
    }

    @Override
    public Optional<Employee> selectEmployeeById(UUID id) {

        return DB.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<Employee> selectEmployeeByName(String name) {
        return DB.stream()
                .filter(employee -> employee.getName().equals(name))
                .findFirst();
    }

    @Override
    public Optional<Employee> selectEmployeeByEmail(String email) {
        return DB.stream()
                .filter(employee -> employee.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public Optional<Employee> selectEmployeeByContactNumber(Integer contactNumber) {
        return DB.stream()
                .filter(employee -> employee.getContractNumber().equals(contactNumber))
                .findFirst();
    }


    @Override
    public int updateEmployeeById(UUID id, Employee employee) {
        return selectEmployeeById(id).map(emp -> {

            int indexOfEmployeeToUpdate = DB.indexOf(emp);
            employee.setId(id);
            if(indexOfEmployeeToUpdate>=0){
                DB.set(indexOfEmployeeToUpdate, employee);
                return 1;
            }
            return  0;
        }).orElse(0);
    }

    @Override
    public int deleteEmployeeById(UUID id) {
        Optional<Employee> employee = selectEmployeeById(id);
        if(employee.isEmpty()){
            return  0;
        }
        DB.remove(employee.get());
        return 1;
    }

}
