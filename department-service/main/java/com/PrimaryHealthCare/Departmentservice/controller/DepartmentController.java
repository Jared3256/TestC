package com.PrimaryHealthCare.Departmentservice.controller;

import com.PrimaryHealthCare.Departmentservice.Client.EmployeeClient;
import com.PrimaryHealthCare.Departmentservice.model.Department;
import com.PrimaryHealthCare.Departmentservice.repository.DepartmentRepository;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/department")
public class DepartmentController 
{
    private static final Logger logger  = LoggerFactory.getLogger(DepartmentController.class);
    
    @Autowired
    private DepartmentRepository repository;
    
    @Autowired
    private EmployeeClient employeeClient;
    
    @PostMapping
    public Department add( @RequestBody Department department)
    {
        logger.info("Department Add {}" , department);
        repository.addDepartment(department);
        return department;
    }
    
    @GetMapping
    public List<Department> findAll()
    {
        logger.info("Department findAll");
        return repository.findAll();
    }
    
    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees()
    {
        logger.info("Department findAll with Employees");
        List<Department> departments =  repository.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.getByDepartmentId(department.getId())));
        System.out.println(departments);
        return departments;
    }
    
    @GetMapping("/{id}")
    public Department getById(@PathVariable long id)
    {
        logger.info("Department find:  id : {} " , id);
        return repository.findById(id);
    }
}
