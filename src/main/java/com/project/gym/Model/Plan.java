package com.project.gym.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Plan {
    @Id
    private long id;
    private String mon;
    private String tue;
    private String wen;
    private String thu;
    private String fri;
    private String sat;
    private String sun;

    @ManyToOne
    @JoinColumn(name = "USERS_ID")
    private Users user;

    public Plan(String mon, String tue, String wen, String thu, String fri, String sat, String sun, Users user) {
        this.mon = mon;
        this.tue = tue;
        this.wen = wen;
        this.thu = thu;
        this.fri = fri;
        this.sat = sat;
        this.sun = sun;
        this.user = user;
    }
    public Plan(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWen() {
        return wen;
    }

    public void setWen(String wen) {
        this.wen = wen;
    }

    public String getThu() {
        return thu;
    }

    public void setThu(String thu) {
        this.thu = thu;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
