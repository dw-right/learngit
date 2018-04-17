package com.issc.dw.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int classid;
    private String name;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "aclass",cascade = CascadeType.ALL)
    private List<User> users;
}
