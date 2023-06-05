package com.PrimaryHealthCare.Departmentservice.Client;

import com.PrimaryHealthCare.Departmentservice.model.Employee;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface EmployeeClient 
{
    @GetExchange("/employee/department/{departmentId}")
    public List<Employee> getByDepartmentId(@PathVariable long departmentId);
}
