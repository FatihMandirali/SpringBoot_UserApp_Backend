package com.example.demo.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Team")
public class Team {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private int Id;
    @Column(name="TeamName")
    private String TeamName;

    @OneToMany(mappedBy = "team" , cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private List<Users> users;

    @Override
    public String toString() {
        return "Team{" +
                "Id=" + Id +
                ", TeamName='" + TeamName + '\'' +
                ", users=" + users +
                '}';
    }

    public void add(Users users1){
        if(users==null){
            users=new ArrayList<>();
        }
        users.add(users1);
        users1.setTeam(this);
    }
}
