package com.PrimaryHealthCare.Departmentservice.model;

import java.util.ArrayList;
import java.util.List;

public class Department 
{
    private long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();

    public Department(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name=" + name + ", employees=" + employees + '}';
    } 
    
}
