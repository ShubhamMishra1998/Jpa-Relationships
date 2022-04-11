package com.jparelation.onetomany;

import javax.persistence.*;

@Entity
public class AnsOneToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ans_id")
    private Long id;
    private String answer;

    public AnsOneToMany(Long id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    public AnsOneToMany() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
