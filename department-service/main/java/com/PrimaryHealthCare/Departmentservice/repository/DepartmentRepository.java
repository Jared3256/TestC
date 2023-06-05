package com.PrimaryHealthCare.Departmentservice.repository;

import com.PrimaryHealthCare.Departmentservice.model.Department;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepository {
    
    private List<Department> departments = new ArrayList<>();
    
    
    public Department addDepartment(Department department)
    {
        this.departments.add(department);
        return department;
    }
    
    public Department findById(long id)
    {
        return (Department) this.departments.stream().filter(department -> (department.getId() == id)).findFirst().orElseThrow();
    }
    
    public List<Department> findAll ()
    {
        return this.departments;
    }
}
