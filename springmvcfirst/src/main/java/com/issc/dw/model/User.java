package com.issc.dw.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Length(min = 4,max = 18,message = "{password.length}")
    private String password;
    @ManyToOne
    @JoinColumn(name="classid")
    private Class aclass;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
