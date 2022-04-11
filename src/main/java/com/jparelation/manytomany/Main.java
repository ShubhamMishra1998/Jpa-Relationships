package com.jparelation.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager entityManager=null;
        EntityTransaction transaction=null;
        try{
            emf = Persistence.createEntityManagerFactory("com.jparelation");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            Employee e1=new Employee();
            Employee e2=new Employee();
            Employee e3=new Employee();
            e1.setName("Ram");
            e2.setName("Shyam");
            e3.setName("Kajal");
            List<Project> projects1=new ArrayList<>();
            List<Project> projects2=new ArrayList<>();
            List<Project> projects3=new ArrayList<>();
            Project p1=new Project();
            Project p2=new Project();
            Project p3=new Project();
            p1.setProjectName("Java");
            p2.setProjectName("Python");
            p3.setProjectName("C++");
            List<Employee> employees1=new ArrayList<>();
            List<Employee> employees2=new ArrayList<>();
            List<Employee> employees3=new ArrayList<>();
            projects1.add(p1);
            projects1.add(p2);
            projects2.add(p1);
            projects3.add(p2);
            employees1.add(e1);
            employees1.add(e2);
            employees2.add(e1);
            employees2.add(e3);
            e1.setProjects(projects1);
            e2.setProjects(projects2);
            e3.setProjects(projects3);
            p1.setEmployees(employees1);
            p2.setEmployees(employees2);

            entityManager.persist(e1);
            entityManager.persist(e2);
            entityManager.persist(e3);
            entityManager.persist(p1);
            entityManager.persist(p2);
            entityManager.persist(p3);

            transaction.commit();

        }catch (Exception e){
              e.printStackTrace();
              transaction.rollback();
        }finally {
            entityManager.close();
            emf.close();
        }
    }
}
