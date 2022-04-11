package com.jparelation.onetomany;

import com.jparelation.onetonoe.Ans;
import com.jparelation.onetonoe.Question;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
            emf = Persistence.createEntityManagerFactory("com.jparelation");
            entityManager = emf.createEntityManager();
            transaction = entityManager.getTransaction();
            // Write Operation
            transaction.begin();
            AnsOneToMany ansOneToMany1=new AnsOneToMany();
            ansOneToMany1.setAnswer("a");

            AnsOneToMany ansOneToMany2=new AnsOneToMany();
            ansOneToMany2.setAnswer("b");

            QuestionOneToMany questionOneToMany=new QuestionOneToMany();
            questionOneToMany.setQuestion("What is java");
            List<AnsOneToMany> ansList=new ArrayList<>();
            ansList.add(ansOneToMany1);
            ansList.add(ansOneToMany2);
            questionOneToMany.setAns(ansList);
            entityManager.persist(ansOneToMany1);
            entityManager.persist(ansOneToMany2);
            entityManager.persist(questionOneToMany);
//            entityManager.merge(ques1);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
