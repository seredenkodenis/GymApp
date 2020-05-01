package com.project.gym.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Role {

    @Id
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Users> users;

    public Role(String name, List<Users> users) {
        this.name = name;
        this.users = users;
    }

    public Role(){}

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
