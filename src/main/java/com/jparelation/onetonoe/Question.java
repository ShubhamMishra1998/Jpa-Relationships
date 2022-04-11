package com.jparelation.onetonoe;

import javax.persistence.*;

@Entity
public class Question {
    @Id
    @Column(name = "ques_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ques;
    @OneToOne
    @JoinColumn(name = "ans_id")
    private Ans ans;

    public Question(Long id, String ques, Ans ans) {
        this.id = id;
        this.ques = ques;
        this.ans = ans;
    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public Ans getAns() {
        return ans;
    }

    public void setAns(Ans ans) {
        this.ans = ans;
    }
}
