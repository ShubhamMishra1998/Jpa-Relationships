package com.jparelation.onetonoe;

import javax.persistence.*;

@Entity
public class Ans {
    @Id
    @Column(name ="ans_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String answer;

    public Ans() {
    }

    public Ans(int id, String ans) {
        this.id = id;
        this.answer = ans;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAns() {
        return answer;
    }

    public void setAns(String ans) {
        this.answer = ans;
    }
}
