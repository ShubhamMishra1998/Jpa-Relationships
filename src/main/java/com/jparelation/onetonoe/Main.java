package com.jparelation.onetonoe;

import javax.persistence.*;
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
            Question ques1 = new Question();
            ques1.setQues("what is java");
            Ans ans1=new Ans();
            ans1.setAns("programming language");
            ques1.setAns(ans1);
            entityManager.persist(ans1);
            entityManager.persist(ques1);
//            entityManager.merge(ques1);
            transaction.commit();

//             Read Operation(JPQl)
//            Query q = entityManager.createQuery("select s from Person s");
//            List resultList = q.getResultList();
//            System.out.println("num of cart items:" + resultList.size());
//            for (Object next : resultList) {
//                System.out.println("next shoppingCart: " + next);
//            }
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        } finally {
            entityManager.close();
            emf.close();
        }

    }
}
