package com.PrimaryHealthCare.Departmentservice.model;

import java.util.Objects;

public class Employee 
{
    private long id;
    private long departmenId;
    private String name ;
    private int age;
    private String position;

    public Employee(long id, long departmenId, String name, int age, String position) {
        this.id = id;
        this.departmenId = departmenId;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public Employee(long departmenId, String name, int age, String position) {
        this.departmenId = departmenId;
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public Employee() {
    }

    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDepartmenId() {
        return departmenId;
    }

    public void setDepartmenId(long departmenId) {
        this.departmenId = departmenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", departmenId=" + departmenId + ", name=" + name + ", age=" + age + ", position=" + position + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + (int) (this.departmenId ^ (this.departmenId >>> 32));
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + this.age;
        hash = 67 * hash + Objects.hashCode(this.position);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.departmenId != other.departmenId) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }
    
    
}
