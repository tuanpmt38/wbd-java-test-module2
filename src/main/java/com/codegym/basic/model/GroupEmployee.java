package com.codegym.basic.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "group_employee")
public class GroupEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @OneToMany
    @JoinColumn
    List<Employee> employee;

    public GroupEmployee(){}

    public GroupEmployee(String name, String description, List<Employee> employee) {
        this.name = name;
        this.description = description;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
