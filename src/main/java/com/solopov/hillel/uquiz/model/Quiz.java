package com.solopov.hillel.uquiz.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="quizzes")
public class Quiz implements Comparable<Quiz>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User creator;

    @OneToMany(mappedBy="quiz", cascade=CascadeType.ALL)
    private Set<Question> questions =new TreeSet();

    @NotEmpty(message = "Заполните поле")
    @Size(min=5, max=90, message = "должно иметь 5-90 символов")
    @Column(name="name")
    private String name;

    @NotEmpty(message = "Заполните поле")
    @Size(min=5, max=25, message = "должна иметь 5-25 символов")
    @Column(name="objective")
    private String objective;


    public Quiz(User creator, String name, String objective){
        this.creator=creator;
        this.name=name;
        this.objective=objective; }
    public Quiz(){}
    public Quiz(Integer id){ this.id=id; }

    public void setId(Integer id){
        this.id=id;
    }
    public void setCreator(User creator) { this.creator = creator; }
    public void setName(String name) {
        this.name = name;
    }
    public void setObjective(String objective) {
        this.objective = objective;
    }
    public void setQuestions(Set<Question> questions) { this.questions = questions; }

    public User getCreator() { return creator; }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getObjective() {
        return objective;
    }
    public Set<Question> getQuestions() { return questions; }

    @Override
    public int compareTo(Quiz quiz) {
        if(quiz.id <this.id)return 1;
        if(quiz.id>this.id) return -1;

        return 0;
    }
}