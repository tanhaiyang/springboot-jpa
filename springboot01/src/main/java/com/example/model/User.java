package com.example.model;

import javax.persistence.*;

import static javafx.scene.input.KeyCode.F;

/**
 * Created by hp on 2018/4/3.
 */
@Entity
@Table(name="t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   private String name;
    @ManyToOne//(fetch = FetchType.LAZY)
    private Dept dept;

    public User() {
    }

    public User(Integer id,String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name, Dept dept) {
        this.name = name;
        this.dept = dept;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept=" + dept.getName() +
                '}';
    }
}