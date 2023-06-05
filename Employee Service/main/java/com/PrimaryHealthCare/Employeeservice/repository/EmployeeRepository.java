package com.PrimaryHealthCare.Employeeservice.repository;

import com.PrimaryHealthCare.Employeeservice.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeRepository 
{
    private List<Employee> employees = new ArrayList<>();
    
    public Employee addEmployee(Employee employee)
    {
        this.employees.add(employee);
        return employee;
    }
    
    public Employee findById(long id)
    {
        return (Employee) this.employees.stream().filter(employee -> (employee.getId() == id)).findFirst().orElseThrow();
    }
    
    public List<Employee> findAll ()
    {
        return this.employees;
    }
    
    public List<Employee> findByDepartmentId(long id)
    {
        return this.employees.stream().filter(emp -> emp.getDepartmentId() == id).toList();
    }
}
