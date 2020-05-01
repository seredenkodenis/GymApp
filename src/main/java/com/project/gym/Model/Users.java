package com.project.gym.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {

    @Id
    private Long id;

    @Column(name = "USERS_EMAIL")
    private String email;

    private String name;

    private String password;

    private String phone;

    private String aboniment;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Plan> plans;

    /*
    * @OneToMany(mapedBy="")
    * private List<Entry> entries;
    *
    * */

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roles", joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "id")},inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name")})
    private List<Role> roles;

    public Users(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public Users(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAboniment() {
        return aboniment;
    }

    public void setAboniment(String aboniment) {
        this.aboniment = aboniment;
    }



    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
