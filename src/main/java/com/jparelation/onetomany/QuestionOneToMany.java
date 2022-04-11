package com.jparelation.onetomany;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class QuestionOneToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ques_id")
    private Long id;
    private String question;
    @OneToMany
    @JoinTable(name = "onetomany")
    private List<AnsOneToMany> ans=new ArrayList<>();

    public QuestionOneToMany(Long id, String question, List<AnsOneToMany> ans) {
        this.id = id;
        this.question = question;
        this.ans = ans;
    }

    public QuestionOneToMany() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnsOneToMany> getAns() {
        return ans;
    }

    public void setAns(List<AnsOneToMany> ans) {
        this.ans = ans;
    }
}
