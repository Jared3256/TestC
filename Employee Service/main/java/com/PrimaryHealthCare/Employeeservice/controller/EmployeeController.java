package com.PrimaryHealthCare.Employeeservice.controller;

import com.PrimaryHealthCare.Employeeservice.model.Employee;
import com.PrimaryHealthCare.Employeeservice.repository.EmployeeRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
    private static final Logger logger  = LoggerFactory.getLogger(EmployeeController.class);
    
    @Autowired
    private EmployeeRepository repository;
    
    @PostMapping
    public Employee add( @RequestBody Employee employee)
    {
        logger.info("Employee Add {}" , employee);
        repository.addEmployee(employee);
        return employee;
    }
    
    @GetMapping
    public List<Employee> findAll()
    {
        logger.info("Employee findAll");
        return repository.findAll();
    }
    
    @GetMapping("/{id}")
    public Employee getById(@PathVariable long id)
    {
        logger.info("Employee find:  id : {} " , id);
        return repository.findById(id);
    }
    
    @GetMapping("/department/{departmentId}")
    public List<Employee> getByDepartmentId(@PathVariable long departmentId)
    {
        logger.info("Employee find by departmentID:  id : {} " , departmentId);
        List<Employee> employees = repository.findByDepartmentId(departmentId);
        return employees;
    }
}
