package com.solopov.hillel.uquiz.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="questions")
public class Question implements Comparable<Question> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="multiple")
    private boolean multiple; //Multiple-choice question
    @Column(name="question")
    private String question;
    @OneToMany(mappedBy="question", cascade=CascadeType.ALL)
    private List<Answer> answer;
    @ManyToOne
    @JoinColumn(name = "id_quiz")
    private Quiz quiz;

    public Question(){}

    public Question(String question, List<Answer> answerList) {
        this.question= question;
        this.answer=answerList;
    }

    public Integer getId() {
        return id;
    }
    public String getQuestion() {
        return question;
    }
    public List<Answer> getAnswer() {
        return answer;
    }
    public boolean isMultiple() { return multiple; }
    public Quiz getQuiz() { return quiz; }

    public void setId(int id) {
        this.id = id;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswer(List<Answer> answer) { this.answer = answer; }
    public void setMultiple(boolean multiple) { this.multiple = multiple; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }

    @Override
    public int compareTo(Question qu) {
        if( qu.id <this.id)return 1;
        if(qu.id>this.id) return -1;

        return 0;
    }

}
