package com.jparelation.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "p_id")
    private int id;
    @Column(name = "project_name")
    private String projectName;
    @ManyToMany(mappedBy = "projects")
    List<Employee> employees=new ArrayList<>();

    public Project() {
    }

    public Project(int id, String projectName, List<Employee> employees) {
        this.id = id;
        this.projectName = projectName;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
