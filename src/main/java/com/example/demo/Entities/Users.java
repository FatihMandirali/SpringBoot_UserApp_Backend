package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="Users")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private int Id;
    @Column(name="UserName")
    private String UserName;
    @Column(name="LastName")
    private String LastName;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "users_student",
            joinColumns = { @JoinColumn(name = "users_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") })
    private List<Student> student;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "TeamId")
    private Team team;


    public void add(Student course){
        if(student==null){
            student=new ArrayList<>();
        }
        student.add(course);
    }

  //  @Override
  //  public String toString() {
   //     return "Users{" +
      //          "Id=" + Id +
      //          ", UserName='" + UserName + '\'' +
       //         ", LastName='" + LastName + '\'' +
        //        ", student=" + student +
        //        '}';
   // }


}
