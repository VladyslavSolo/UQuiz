package com.solopov.hillel.uquiz.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User implements Comparable<User>{
    public enum Role{USER,ADMIN,SUPERADMIN,BANNED}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy="creator", cascade=CascadeType.ALL)
    List<Quiz> quizzes = new ArrayList<>();

    @NotEmpty(message = "Заполните поле")
    @Size(min=5, max=15, message = "Должно быть 5-15 символов")
    @Column(name="login")
    private String login;

    @NotEmpty(message = "Заполните поле")
    @Size(min=5, max=60, message = "Должно быть 60   символов")
    @Column(name="password")
    private String password;

    @Column(name="role")
    String role= Role.USER.name();

    @Temporal(TemporalType.DATE)
    @Column(name = "regdate")
    Date dateOfRegistration;

    @Column(name="surname")
    String surname;

    @Column(name="name")
    String name;

    @Column(name="email")
    String email;

    @Column(name="sex")
    boolean sex; //0-Male; 1-Female


    public User(){}

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, Date dateOfRegistration, String surname, String name, String email, boolean sex) {
        this.login = login;
        this.password = password;
        this.dateOfRegistration = dateOfRegistration;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.sex = sex;
    }

    public void setRole(String role) { this.role = role; }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setDateOfRegistration(Date dateOfReg) { this.dateOfRegistration = dateOfReg; }
    public void setSurname(String surname) { this.surname = surname; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setSex(boolean sex) { this.sex = sex; }

    public String getRole() { return role; }
    public Integer getId() { return id; }
    public String getPassword() {
        return password;
    }
    public String getLogin() {
        return login;
    }
    public Date getDateOfRegistration() { return dateOfRegistration; }
    public String getSurname() { return surname; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public boolean isSex() { return sex; }
    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return login != null ? login.equals(user.login) : user.login == null;
    }

    @Override
    public int hashCode() {
        return login != null ? login.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", dateOfRegistration=" + dateOfRegistration +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                '}';
    }

    @Override
    public int compareTo(User user) {
        return (this.login.compareTo(user.login));
    }
}