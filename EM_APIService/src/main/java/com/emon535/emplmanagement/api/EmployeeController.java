package com.emon535.emplmanagement.api;

import com.emon535.emplmanagement.model.Employee;
import com.emon535.emplmanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {
    private  final EmployeeService employeeService ;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public  void addEmployee(
            @Valid
            @NotNull(message = "Name cannot be null.")
            @RequestBody  Employee employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployeeList(){
        return employeeService.getAllEmployee();
    }

    @GetMapping(path = "{id}")
    public Employee getEmployeeById(@PathVariable("id") UUID id){
        return  employeeService.getEmployeeById(id).orElse(null);
    }

    @GetMapping(path = "name/{name}")
    public Employee getEmployeeByName(@PathVariable("name") String name){
        return  employeeService.getEmployeeByName(name).orElse(null);
    }

    @GetMapping(path = "email/{email}")
    public Employee getEmployeeByEmail(@PathVariable("email") String email){
        return  employeeService.getEmployeeByEmail(email).orElse(null);
    }

    @GetMapping(path = "contactNumber/{contactNumber}")
    public Employee getEmployeeByContactNumber(@Valid @PathVariable("contactNumber") Integer contactNumber){
        return  employeeService.getEmployeeByContactNumber(contactNumber).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEmployeeById(@PathVariable("id") UUID id){
        employeeService.deleteEmployeeById(id);
    }

    @PutMapping(path = "{id}")
    public void updateEmployee(@Valid @NotNull @PathVariable("id") UUID id ,@RequestBody Employee newEmployeeToUpdate){
        employeeService.updateEmployeeById(id, newEmployeeToUpdate);
    }
}


