package com.jparelation.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "emp_id")
    private int id;
    @Column(name = "emp_name")
    private String name;
    @ManyToMany
    @JoinTable(name = "emp_project",
            joinColumns = {@JoinColumn(name = "emp_id")}
            ,inverseJoinColumns = {@JoinColumn(name = "pid")})
    private List<Project> projects=new ArrayList<>();

    public Employee() {
    }

    public Employee(int id, String name, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.projects = projects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
